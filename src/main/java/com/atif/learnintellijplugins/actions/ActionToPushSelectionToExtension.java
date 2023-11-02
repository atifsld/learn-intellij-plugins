package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.ui.components.JBScrollPane;
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
                addSelectionToExtensionView(project, selectedText);
            } else {
                // TO-DO: Handling when no text is selected
            }
        } else {
            // TO-DO: Handling when editor not found
        }
    }

    private static void addSelectionToExtensionView(Project project, String selectedText) {
        // Get a reference to the extension ny using the ID defined in plugin.xml
        ToolWindow toolWindow = ToolWindowManager.getInstance(Objects.requireNonNull(project)).getToolWindow("Your Friendly Tool");

        // Get the ToolWindow's ContentManager
        ContentManager contentManager = Objects.requireNonNull(toolWindow).getContentManager();

        Content content = contentManager.getContent(0);

        SimpleToolWindowPanel panel = (SimpleToolWindowPanel) Objects.requireNonNull(content).getComponent();
        System.out.println("SimpleToolWindowPanel:\n" + panel);

        JPanel jPanel = (JPanel) panel.getComponent(0);
        System.out.println("JPanel:\n" + jPanel);

        JBScrollPane jbScrollPane = (JBScrollPane) jPanel.getComponent(2);
        System.out.println("JBScrollPane:\n" + jbScrollPane);

        JTextArea todoListTextArea = (JTextArea) jbScrollPane.getViewport().getView();
        System.out.println("JTextArea:\n" + todoListTextArea);

        todoListTextArea.append(selectedText + "\n");
    }
}