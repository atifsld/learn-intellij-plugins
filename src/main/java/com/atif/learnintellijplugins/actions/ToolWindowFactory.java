package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolWindowFactory implements com.intellij.openapi.wm.ToolWindowFactory {

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        // Create a Swing component to display a label
        JBLabel label = new JBLabel("Hi. If you're having trouble coding, talk to me and I'll make your feel better!");

        // Create a button
        JButton button = new JButton("Why not!");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Display a message when the button is clicked
                JOptionPane.showMessageDialog(null, "You are not bored anymore!\nYou can continue coding!\nCongratulations!", "Button Clicked", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Create a JPanel to hold the label and button
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(label);
        panel.add(button);

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
