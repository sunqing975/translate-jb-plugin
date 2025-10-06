package com.sun.config;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PluginSettingsConfigurable implements Configurable {
    
    private PluginSettingsComponent mySettingsComponent;
    
    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Translate Plugin Settings";
    }
    
    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }
    
    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new PluginSettingsComponent();
        return mySettingsComponent.getPanel();
    }
    
    @Override
    public boolean isModified() {
        PluginConfig settings = PluginConfig.getInstance();
        boolean modified = !mySettingsComponent.getYoudaoAppKey().equals(settings.getYoudaoAppKey());
        modified |= !mySettingsComponent.getYoudaoAppSecret().equals(settings.getYoudaoAppSecret());
        return modified;
    }
    
    @Override
    public void apply() throws ConfigurationException {
        PluginConfig settings = PluginConfig.getInstance();
        settings.setYoudaoAppKey(mySettingsComponent.getYoudaoAppKey());
        settings.setYoudaoAppSecret(mySettingsComponent.getYoudaoAppSecret());
    }
    
    @Override
    public void reset() {
        PluginConfig settings = PluginConfig.getInstance();
        mySettingsComponent.setYoudaoAppKey(settings.getYoudaoAppKey());
        mySettingsComponent.setYoudaoAppSecret(settings.getYoudaoAppSecret());
    }
    
    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }
}