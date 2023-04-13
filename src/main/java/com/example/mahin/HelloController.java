package com.example.mahin;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.sql.SQLException;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.ResultSet;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private AnchorPane Mypane;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label warningLabel;



    @FXML
    protected void onHelloButtonClick() throws IOException {


        try{

            String userName = usernameField.getText();
            String password = passwordField.getText();

            if(userName.length() == 0 || password.length() == 0){
                return;
            }

            logsDB.getInstance();

            try {
                logsDB.getInstance().getStatement().execute("use notepadnext");

                ResultSet result = logsDB.getInstance().getStatement().executeQuery("select * from Users");
                boolean userFound = false;
                while (result.next()) {
                    String name = result.getString("username");
                    String pass = result.getString("password");
                    System.out.println(name + " " + pass);
                    if(name.equals(userName) && pass.equals(password)){
                        NotePad notepad=new NotePad();
                        notepad.load();
                        userFound = true;
                        break;
                    }
                }
                if(!userFound){
                     warningLabel.setText("Incorrect");
                }
                else{
                    warningLabel.setText("");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }



//
//        NotePad notePad = new NotePad();
    }

}