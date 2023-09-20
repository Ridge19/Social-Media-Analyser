package com.example.socialmediaanalyser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

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
    public void SignIn(ActionEvent event) throws IOException {
        System.out.println("Test");

        FXMLLoader fxmlLoader = new FXMLLoader(SocialMedia.class.getResource("Main-Page.fxml"));

        Parent main = FXMLLoader.load(getClass().getResource("Main-Page.fxml"));

        Stage scene = new Stage();

        scene.setTitle("Social Media Manager");

        scene.setScene(scene.getScene());
        scene.show();
    }

    public void Back(ActionEvent event) throws IOException {
        System.out.println("Going back");

        FXMLLoader fxmlLoader = new FXMLLoader(SocialMedia.class.getResource("LoginPage.fxml"));

        Parent main = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));

        Stage scene = new Stage();

        scene.setTitle("Social Media Manager - Login");

        scene.setScene(scene.getScene());
        scene.show();
    }

    @FXML
    void CreateAccount(ActionEvent event) {
        System.out.println("Creating account");
    }

    @FXML
    void Quit(ActionEvent event) {
        System.out.println("Quitting");
        Platform.exit();
    }


}


