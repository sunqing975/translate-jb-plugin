package com.sun.action;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import com.sun.utils.AuthV3Util;
import com.sun.utils.HttpUtil;
import com.sun.config.PluginConfig;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

// 添加FastJSON2导入
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONArray;

/**
 * @author superman
 */
public class TranslateAction extends AnAction {
    private static final Logger LOG = Logger.getInstance(TranslateAction.class);

    private static final String TRANSLATE_API_URL = "https://openapi.youdao.com/api";

    /**
     * 创建请求参数
     *
     * @param q      待翻译文本
     * @param from   源语言语种
     * @param to     目标语言语种
     * @return 请求参数
     */
    private static Map<String, String[]> createRequestParams(String q, String from, String to) {
        /*
         * note: 将下列变量替换为需要请求的参数
         * 取值参考文档: https://ai.youdao.com/DOCSIRMA/html/%E8%87%AA%E7%84%B6%E8%AF%AD%E8%A8%80%E7%BF%BB%E8%AF%91/API%E6%96%87%E6%A1%A3/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1/%E6%96%87%E6%9C%AC%E7%BF%BB%E8%AF%91%E6%9C%8D%E5%8A%A1-API%E6%96%87%E6%A1%A3.html
         */
        return new HashMap<>() {{
            put("q", new String[]{q});
            put("from", new String[]{from});
            put("to", new String[]{to});
        }};
    }

    private static String translate(Map<String, String[]> params, String appKey, String appSecret) throws NoSuchAlgorithmException {
        // 添加鉴权相关参数
        AuthV3Util.addAuthParams(appKey, appSecret, params);
        // 请求api服务
        byte[] result = HttpUtil.doPost(TRANSLATE_API_URL, null, params, "application/json");
        
        // 将结果转换为JSON格式并提取translation字段
        if (result != null) {
            String resultStr = new String(result, StandardCharsets.UTF_8);
            try {
                JSONObject jsonObject = JSON.parseObject(resultStr);
                JSONArray translationArray = jsonObject.getJSONArray("translation");
                if (translationArray != null) {
                    return String.join(",", translationArray.toArray(new String[0]));
                }
                return resultStr; // 如果没有translation字段，则返回原始结果
            } catch (Exception e) {
                LOG.warn("解析翻译结果失败，返回原始结果", e);
                return resultStr; // 解析失败时返回原始结果
            }
        }
        return null;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent anActionEvent) {
        // 1. 当用户触发后，获取选中内容
        Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
        if (editor == null) {
            Messages.showMessageDialog("未找到编辑器", "错误", Messages.getErrorIcon());
            return;
        }

        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText == null || selectedText.isEmpty()) {
            Messages.showMessageDialog("请先选择要翻译的文本", "提示", Messages.getInformationIcon());
            return;
        }

        // 从插件配置获取API密钥
        String appKey = PluginConfig.getInstance().getYoudaoAppKey();
        String appSecret = PluginConfig.getInstance().getYoudaoAppSecret();
        
        if (appKey == null || appKey.isEmpty() || appSecret == null || appSecret.isEmpty()) {
            Messages.showMessageDialog("请先配置有道翻译API密钥", "API密钥缺失", Messages.getErrorIcon());
            return;
        }

        // 2. 调用网易云翻译接口进行翻译
        try {
            String result = translate(createRequestParams(selectedText, "auto", "zh-CHS"), appKey, appSecret);

            // 3. 弹窗展示翻译结果
            Messages.showMessageDialog(result != null ? result : "翻译结果为空", "翻译结果", Messages.getInformationIcon());
        } catch (Exception e) {
            LOG.error("翻译失败", e);
            Messages.showMessageDialog("翻译失败: " + e.getMessage(), "错误", Messages.getErrorIcon());
        }
    }
}