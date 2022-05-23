package com.example.mahin;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to my Application!");
        welcomeText.setText("Here the window is empty because, i'm going to set a login page before you click the click Buttion");
        NotePad notePad = new NotePad();
    }
}