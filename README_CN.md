# IntelliJ IDEA 翻译插件 (Translate GBK)

[English Version](README_EN.md)
![Plugin Version](https://img.shields.io/badge/version-1.0--SNAPSHOT-blue)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-232%2B-orange)
![License](https://img.shields.io/badge/license-Apache%202.0-green)

一个为 IntelliJ IDEA 开发的翻译插件，支持将选中的文本翻译为简体中文，特别适用于在开发过程中快速翻译文档、注释等内容，提升国际化开发体验。

## 功能特性

- 🌍 文本翻译：支持将选中的任意语言文本翻译为简体中文
- 🔧 易于使用：在编辑器中选中文本，右键选择"翻译"即可
- ⚙️ 可配置：支持配置有道翻译 API 密钥
- 🔒 安全：通过有道云 API 进行翻译，数据安全有保障

## 安装方式

### 方法一：通过 IntelliJ IDEA 插件市场安装（推荐）
1. 打开 IntelliJ IDEA
2. 进入 `Preferences` > `Plugins`
3. 在 Marketplace 中搜索 "Translate GBK"
4. 点击安装并重启 IDEA

### 方法二：手动安装
1. 下载插件的 `.jar` 文件
2. 打开 IntelliJ IDEA
3. 进入 `Preferences` > `Plugins`
4. 点击右上角的齿轮图标，选择 `Install Plugin from Disk...`
5. 选择下载的 `.jar` 文件并安装
6. 重启 IntelliJ IDEA

## 使用方法

1. 在 IntelliJ IDEA 中打开任意文件
2. 选中需要翻译的文本
3. 右键点击选中的文本，在上下文菜单中选择"翻译"
4. 翻译结果将通过弹窗展示

## 配置说明

在使用插件前，需要配置有道翻译 API 密钥：

1. 访问 [有道智云](https://ai.youdao.com/) 注册账号并创建应用
2. 获取应用的 `App Key` 和 `App Secret`
3. 在 IntelliJ IDEA 中进入 `Preferences` > `Tools` > `Translate Plugin Settings`
4. 输入获取到的 `App Key` 和 `App Secret`
5. 点击 `OK` 保存配置

**注意**：安装插件后，使用前必须在 `Settings` > `Tools` > `Translate Plugin Settings` 中配置有道密钥。

## 技术架构

- **开发语言**：Java/Kotlin
- **构建工具**：Gradle
- **依赖库**：
  - [OkHttp3](https://square.github.io/okhttp/)：用于 HTTP 请求
  - [FastJSON2](https://github.com/alibaba/fastjson2)：用于 JSON 解析
- **API**：[有道翻译 API](https://ai.youdao.com/product-fanyi-text.s)

## 开发指南

### 环境要求

- JDK 17+
- IntelliJ IDEA 2023.2+

### 构建项目

```bash
# 克隆项目
git clone https://github.com/sunqing975/translate-jb-plugin.git

# 进入项目目录
cd translate-jb-plugin

# 构建插件
./gradlew buildPlugin
```

构建完成后，插件文件将位于 `build/libs/` 目录中。

### 运行调试

```bash
# 运行调试环境
./gradlew runIde
```

## 项目结构

```
src/
├── main/
│   ├── java/com/sun/
│   │   ├── action/              # 动作处理
│   │   ├── config/              # 配置管理
│   │   └── utils/               # 工具类
│   └── resources/
│       └── META-INF/
│           └── plugin.xml       # 插件配置文件
```

## 贡献

欢迎提交 Issue 和 Pull Request 来改进这个插件。

## 许可证

本项目采用 Apache License 2.0 许可证。详情请见 [LICENSE](LICENSE) 文件。