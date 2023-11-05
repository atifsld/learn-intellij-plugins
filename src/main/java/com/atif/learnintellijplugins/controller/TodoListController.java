package com.atif.learnintellijplugins.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TodoListController {

    @FXML
    private TextField textField;

    @FXML
    private TextArea todoListTextArea;

    @FXML
    private void addTodo(ActionEvent event) {
        String todoItem = textField.getText();
        if (!todoItem.isEmpty()) {
            todoListTextArea.appendText(todoItem + "\n");
            textField.clear(); // Clear the text field after adding
        }
    }
}
