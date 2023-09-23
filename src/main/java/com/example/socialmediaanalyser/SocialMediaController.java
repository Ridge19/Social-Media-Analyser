package com.example.socialmediaanalyser;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


public class SocialMediaController implements Initializable {
    public AnchorPane MainPage;
    public TextField EmailField;

    @FXML
    private Label LoginLabel;

    @FXML
    private AnchorPane LoginWindow;

    @FXML
    private TextField UsernameField;

    @FXML
    private TextField PasswordField;

    @FXML
    private Label WelcomeLabel;

    @FXML
    private Label AccountLabel;

    @FXML
    private Button CreateAccountButton;

    @FXML
    private Label PasswordLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private CheckBox showPassword;

    @FXML
    private Button BackButton;

    @FXML
    private Button SignOut;

    @FXML
    private Label TitleLabel;

    @FXML
    private Button SignInButton;

    public LoginModel loginModel = new LoginModel();

    Stage stage;
    public SocialMediaController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (loginModel.isDbConnected()) {
            LoginLabel.setText("Connected");
        } else {
            LoginLabel.setText("Not Connected");
        }
    }


    @FXML
    public void SignIn(ActionEvent event) throws SQLException, IOException {
        try {
            if (loginModel.isLogin(UsernameField.getText(), PasswordField.getText())) {
                WelcomeLabel.setText("Welcome!");
                System.out.println("logged in");
            } else {
                WelcomeLabel.setText("You arent logged in!");
                System.out.println("Cannot log in!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void SignOut(ActionEvent event) throws IOException {
        System.out.println("Going back");

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
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("CANCEL");
        alert.setHeaderText("You're about to cancel creating an account!");
        alert.setContentText("Are you sure you want to cancel?");

        if (alert.showAndWait().get() == ButtonType.YES) {
            Stage stage = (Stage) LoginWindow.getScene().getWindow();
            System.out.println("ACCOUNT CREATION CANCELLED");
            stage.close();
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


