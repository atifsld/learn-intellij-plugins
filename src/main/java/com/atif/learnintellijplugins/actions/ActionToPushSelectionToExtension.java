package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Objects;

public class ActionToPushSelectionToExtension extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        // Get the project from the event
        Project project = e.getProject();

        // Get the editor from the event
        Editor editor = e.getDataContext().getData(com.intellij.openapi.actionSystem.CommonDataKeys.EDITOR);
        if (editor != null) {
            // Get the selected text from the editor
            String selectedText = editor.getSelectionModel().getSelectedText();

            if (selectedText != null && !selectedText.isEmpty()) {
                // Get a reference to the extension ny using the ID defined in plugin.xml
                ToolWindow toolWindow = ToolWindowManager.getInstance(Objects.requireNonNull(project)).getToolWindow("Your Friendly Tool");

                // Get the ToolWindow's ContentManager
                ContentManager contentManager = Objects.requireNonNull(toolWindow).getContentManager();

                // Currently I am unable to append sections to existing content, so I settle for removing existing content and attaching the updates
                // We should try to change existing content at index from ContentManager instead
                contentManager.removeAllContents(true);

                replaceContentWithSelectedText(selectedText, contentManager);
            } else {
                // TO-DO: Handling when no text is selected
            }
        } else {
            // TO-DO: Handling when editor not found
        }
    }

    private static void replaceContentWithSelectedText(String selectedText, ContentManager contentManager) {
        // Create a JPanel to hold the selected text
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JBLabel label = new JBLabel(selectedText);
        panel.add(label);

        // Create a content object to hold the JPanel
        SimpleToolWindowPanel contentPanel = new SimpleToolWindowPanel(true, true);
        contentPanel.setContent(panel);
        Content content = contentManager.getFactory().createContent(contentPanel, "", false);

        // Finally, give the content to the ContentManager
        contentManager.addContent(content);
    }
}