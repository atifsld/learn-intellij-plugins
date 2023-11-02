package com.atif.learnintellijplugins.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class TodoExtensionSettingsPage implements Configurable {
    private JTextField nameField;
    private JPanel settingsPanel;

    @Nls
    @Override
    public String getDisplayName() {
        return "Todo Extension Settings";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (settingsPanel == null) {
            settingsPanel = new JPanel();
            nameField = new JTextField();
            settingsPanel.add(nameField);
        }
        return settingsPanel;
    }

    @Override
    public boolean isModified() {
        // Check if the settings have been modified.
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        // Save the settings when the user clicks "OK."
        // You can access the "Name" value using nameField.getText()
        String name = nameField.getText();
        // Save the name or your settings to your extension.
    }

    @Override
    public void reset() {
        // Reset the settings when the user clicks "Cancel" or "Reset."
        // You can load the settings from your extension and update the nameField.
        String name = ""; // Load the name from your extension settings.
        nameField.setText(name);
    }

    @Override
    public void disposeUIResources() {
        // Clean up any resources when the settings dialog is closed.
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null; // Help topic if you have documentation.
    }
}
