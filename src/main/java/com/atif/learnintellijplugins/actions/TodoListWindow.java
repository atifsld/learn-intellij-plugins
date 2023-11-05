package com.atif.learnintellijplugins.actions;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.SimpleToolWindowPanel;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentManager;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class TodoListWindow implements com.intellij.openapi.wm.ToolWindowFactory {
    public TodoListWindow() {
        // Constructor logic
        int x = 1 + 2;
        return;
    }
    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        JFXPanel jfxPanel = new JFXPanel();
        try {
            // Load the JavaFX UI from the FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/todolist.fxml"));
            Parent root = loader.load();

            // Create a Scene and set it in the JFXPanel
            Scene scene = new Scene(root);
            jfxPanel.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Create a content object
        SimpleToolWindowPanel contentPanel = new SimpleToolWindowPanel(true, true);
        contentPanel.setContent(jfxPanel);

        // Add the content panel to the tool window
        ContentManager contentManager = toolWindow.getContentManager();
        Content content = contentManager.getFactory().createContent(contentPanel, "", false);
        contentManager.addContent(content);
    }

    @Override
    public void init(ToolWindow window) {
        // Here we could set and access the settings and make changes accordingly

        // @Nullable @NonNls String settingValue = PropertiesComponent.getInstance().getValue("todoList.settingKey");
        // PropertiesComponent.getInstance().setValue("todoList.settingKey", "Atif");
    }
}
