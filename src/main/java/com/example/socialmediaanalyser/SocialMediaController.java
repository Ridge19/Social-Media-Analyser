package com.example.socialmediaanalyser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

//public class HelloController {
//    @FXML
//    private Label welcomeText;
//
//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }
//}

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SocialMediaController {

    @FXML
    private Label AccountLabel;

    @FXML
    private Button CreateAccountButton;

    @FXML
    private Label LoginLabel;

    @FXML
    private AnchorPane LoginWindow;

    @FXML
    private TextField PasswordField;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Button SignInButton;

    @FXML
    private TextField UsernameField;

    @FXML
    private Label usernameLabel;

    @FXML
    private CheckBox showPassword;


    @FXML
    void SignIn(ActionEvent event) {
        System.out.println("Test");
    }

}


