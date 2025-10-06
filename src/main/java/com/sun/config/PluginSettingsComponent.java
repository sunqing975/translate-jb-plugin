package com.sun.config;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PluginSettingsComponent {
    
    private final JPanel myMainPanel;
    private final JBTextField myYoudaoAppKeyText = new JBTextField();
    private final JBTextField myYoudaoAppSecretText = new JBTextField();
    
    public PluginSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("有道 App Key: "), myYoudaoAppKeyText, 1, false)
                .addLabeledComponent(new JBLabel("有道 App Secret: "), myYoudaoAppSecretText, 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }
    
    public JPanel getPanel() {
        return myMainPanel;
    }
    
    public JComponent getPreferredFocusedComponent() {
        return myYoudaoAppKeyText;
    }
    
    @NotNull
    public String getYoudaoAppKey() {
        return myYoudaoAppKeyText.getText();
    }
    
    @NotNull
    public String getYoudaoAppSecret() {
        return myYoudaoAppSecretText.getText();
    }
    
    public void setYoudaoAppKey(@NotNull String newText) {
        myYoudaoAppKeyText.setText(newText);
    }
    
    public void setYoudaoAppSecret(@NotNull String newText) {
        myYoudaoAppSecretText.setText(newText);
    }
}