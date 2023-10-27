package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;

public class HelloWorldAction extends AnAction {
    public void actionPerformed(@NotNull AnActionEvent e) {
        // Get the editor from the event
        Editor editor = e.getDataContext().getData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR);

        if (editor != null) {
            // Get the selected text from the editor
            String selectedText = editor.getSelectionModel().getSelectedText();

            if (selectedText != null && !selectedText.isEmpty()) {
                // Display the selected text
                Messages.showInfoMessage("Selected Text: " + selectedText, "Selected Text Info");
            } else {
                Messages.showInfoMessage("No text selected.", "Info");
            }
        } else {
            Messages.showInfoMessage("No editor found.", "Info");
        }
    }
}
