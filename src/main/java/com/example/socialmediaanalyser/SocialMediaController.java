package com.example.socialmediaanalyser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;


public class SocialMediaController implements Initializable {
    public AnchorPane MainPage;

    public TextField EmailField;

    @FXML
    public Label LoginLabel;

    @FXML
    public Label DBLabel;

    @FXML
    public Label UserLabel;

    @FXML
    public AnchorPane LoginWindow;

    @FXML
    public TextField UsernameField;

    @FXML
    public TextField PasswordField;

    @FXML
    public Label StatusLabel;

    @FXML
    public Label AccountLabel;

    @FXML
    public Button CreateAccountButton;

    @FXML
    public Label PasswordLabel;

    @FXML
    public Label usernameLabel;

    @FXML
    public Button BackButton;

    @FXML
    public Button SignOut;

    @FXML
    public Label TitleLabel;

    @FXML
    public Button SignInButton;

    public LoginModel loginModel = new LoginModel();

    Stage stage;
    public SocialMediaController() throws SQLException {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Database connected");
    }

//    @FXML
//    public void GetUserName(String UserName) {
//        UserLabel.setText("Welcome " + UserName + "!");
//    }

    @FXML
    public void SignIn(ActionEvent event) throws SQLException, IOException {
        try {
            if (loginModel.isLogin(UsernameField.getText(), PasswordField.getText())) {
                StatusLabel.setText("Username and password is correct!");
                System.out.println("logged in");

                System.out.println("Welcome " + UsernameField.getText());

//                UserLabel.setText("Welcome " + UserLabel.getText());
                ((Node)event.getSource()).getScene().getWindow().hide();
                Stage PrimaryStage = new Stage();
                Pane root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Main-Page.fxml")));
                Scene scene = new Scene(root);
                PrimaryStage.setScene(scene);
                PrimaryStage.show();



            } else {
                StatusLabel.setText("username and password is not correct!");
                System.out.println("Cannot log in!");
            }

        } catch (SQLException e) {
            StatusLabel.setText("Fields cannot be empty! enter a username and password!");
            e.printStackTrace();
        }
    }
    @FXML
    public void SignOut(ActionEvent event) throws IOException {
        System.out.println("Going back");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));


        Scene scene1 = new Scene(root);
        Stage Stage = new Stage();
        Stage.setTitle("Social Media Manager");
        Stage.setScene(scene1);

        Stage.initModality(Modality.APPLICATION_MODAL);
        Stage.show();

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("SIGN OUT");
        alert.setHeaderText("You're about to sign out of your account!");
        alert.setContentText("Are you sure you want to sign out?");

        if (alert.showAndWait().get() == ButtonType.YES) {
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage = (Stage) LoginWindow.getScene().getWindow();
            System.out.println("ACCOUNT SIGNED OUT");
            stage.close();
        }
    }

    @FXML
    public void CreateAccount(ActionEvent event) throws IOException {
        System.out.println("Creating account");

        Parent rootOut = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountPage.fxml")));
        Scene SceneOut = new Scene(rootOut);
        ((Node)event.getSource()).getScene().getWindow().hide();
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
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LoginPage.fxml")));

        Scene scene1 = new Scene(root);
        ((Node)event.getSource()).getScene().getWindow().hide();
        Stage Stage = new Stage();
        Stage.setTitle("Social Media Manager");
        Stage.setScene(scene1);

        Stage.initModality(Modality.APPLICATION_MODAL);
        Stage.show();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CANCEL");
        alert.setHeaderText("You're about to cancel creating an account!");
        alert.setContentText("Are you sure you want to cancel?");

        if (alert.showAndWait().get() == ButtonType.YES) {
            Stage stage = (Stage) LoginWindow.getScene().getWindow();
            System.out.println("ACCOUNT CREATION CANCELLED");
            stage.close();
        } else if (alert.showAndWait().get() == ButtonType.CANCEL) {
            stage.show();
        }
    }

    @FXML
    public void Quit(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.WARNING);
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


