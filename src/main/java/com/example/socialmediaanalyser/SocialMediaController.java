package com.example.socialmediaanalyser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.Objects;

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
    private Button BackButton;

    Stage stage;


    @FXML
    public void SignIn(ActionEvent event) throws IOException {
        System.out.println("Logging in");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-Page.fxml")));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Social Media Manager");
        primaryStage.setScene(scene);

        primaryStage.initModality(Modality.APPLICATION_MODAL);
        primaryStage.show();
    }


    public void SignOut(ActionEvent event) throws IOException {
        System.out.println("Going back");

        Parent rootOut = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));
        Scene SceneOut = new Scene(rootOut);
        Stage SecondaryStage = new Stage();

        SecondaryStage.setTitle("Social Media Manager - Login");
        SecondaryStage.setScene(SceneOut);
        SecondaryStage.initModality(Modality.WINDOW_MODAL);
        SecondaryStage.show();

        if (SecondaryStage.isShowing()) {
            System.out.println("Second Stage is showing");
        } else {
            System.out.println("Second Stage is not showing");
        }
    }

    @FXML
    public void CreateAccount(ActionEvent event) throws IOException {
        System.out.println("Creating account");

        Parent rootOut = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountPage.fxml")));
        Scene SceneOut = new Scene(rootOut);
        Stage ThirdStage = new Stage();

        ThirdStage.setTitle("Social Media Manager - Create Account");
        ThirdStage.setScene(SceneOut);
        ThirdStage.initModality(Modality.WINDOW_MODAL);
        ThirdStage.show();

        if (ThirdStage.isShowing()) {
            System.out.println("Second Stage is showing");
        } else {
            System.out.println("Second Stage is not showing");
        }
    }

    @FXML
    public void Back(ActionEvent event) throws IOException{
        Parent root3 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MainPage.fxml")));
        Scene BackScene = new Scene(root3);
        Stage FourhtStage = new Stage();

        FourhtStage.setTitle("Social Media Manager - Main Page");
        FourhtStage.setScene(BackScene);
        FourhtStage.initModality(Modality.WINDOW_MODAL);
        FourhtStage.show();

        if (FourhtStage.isShowing()) {
            System.out.println("Second Stage is showing");
        } else {
            System.out.println("Second Stage is not showing");
        }
    }

    @FXML
    public void Quit(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quit");
        alert.setHeaderText("You're about to close the application!");
        alert.setContentText("Are you sure you want to close the application?");

        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) LoginWindow.getScene().getWindow();
            System.out.println("you successfully logged out!");
            stage.close();
        }
        javafx.application.Platform.exit();
    }


}


