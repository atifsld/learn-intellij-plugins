package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class ToolWindowFactory implements com.intellij.openapi.wm.ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // Create a Swing component to display a label
        JBLabel label = new JBLabel("To-Do List");

        // Create a JPanel with a BorderLayout to hold the label, text field, and button
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(label, BorderLayout.NORTH);

        // Create a JPanel for the text field and button
        JPanel inputPanel = new JPanel();

        // Create a text field for entering to-do items
        JTextField textField = new JTextField(20); // Reduce the width
        inputPanel.add(textField);

        // Create a button to save to-do items
        JButton addButton = new JButton("Add To-Do");
        inputPanel.add(addButton);

        // Add the inputPanel to the bottom (SOUTH) of the panel
        panel.add(inputPanel, BorderLayout.SOUTH);

        // Create a JTextArea to display the to-do list
        JTextArea todoListTextArea = new JTextArea(10, 30);
        todoListTextArea.setEditable(false); // Make it read-only
        JBScrollPane scrollPane = new JBScrollPane(todoListTextArea);

        // Add the scrollPane to the center of the panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Action listener for the "Add To-Do" button
        addButton.addActionListener(e -> {
            String todoItem = textField.getText();
            if (!todoItem.isEmpty()) {
                todoListTextArea.append(todoItem + "\n");
                textField.setText(""); // Clear the text field after adding
            }
        });

        // Create a content object
        SimpleToolWindowPanel contentPanel = new SimpleToolWindowPanel(true, true);
        contentPanel.setContent(panel);

        // Add the content panel to the tool window
        ContentManager contentManager = toolWindow.getContentManager();
        Content content = contentManager.getFactory().createContent(contentPanel, "", false);
        contentManager.addContent(content);
    }

    @Override
    public void init(ToolWindow window) {
        // Initialization code for your tool window.
    }
}
