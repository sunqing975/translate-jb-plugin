package com.sun.config;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
    name = "TranslatePluginConfig",
    storages = @Storage("translate-plugin.xml")
)
public class PluginConfig implements PersistentStateComponent<PluginConfig.State> {
    
    public static class State {
        public String youdaoAppKey = "";
        public String youdaoAppSecret = "";
    }
    
    private State myState = new State();
    
    public static PluginConfig getInstance() {
        return ApplicationManager.getApplication().getService(PluginConfig.class);
    }
    
    @Nullable
    @Override
    public State getState() {
        return myState;
    }
    
    @Override
    public void loadState(@NotNull State state) {
        myState = state;
    }
    
    public String getYoudaoAppKey() {
        return myState.youdaoAppKey;
    }
    
    public void setYoudaoAppKey(String youdaoAppKey) {
        myState.youdaoAppKey = youdaoAppKey;
    }
    
    public String getYoudaoAppSecret() {
        return myState.youdaoAppSecret;
    }
    
    public void setYoudaoAppSecret(String youdaoAppSecret) {
        myState.youdaoAppSecret = youdaoAppSecret;
    }
}