package com.example.socialmediaanalyser;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.*;

public class SocialMedia extends Application {
    private ObservableList<String> Post = FXCollections.observableArrayList();


    static ArrayList<Posts> post = new ArrayList<>();
    public static void PopulateList() {
        Posts p1 = new Posts(20582, "Come and meet us at Building 14 of RMIT.", "SD2C45", 10, 24, "12/05/2023  10:10:00 AM");
        Posts p2 = new Posts(10, "Check out this epic film.", "A567VF", 1000, 1587, "01/06/2023 14:25");
        Posts p3 = new Posts(37221,	"Are we into Christmas month already?!", "3827F2", 526, 25, "15/11/2022 23:30");
        Posts p4 = new Posts(382, "What a miracle!", "38726I", 2775, 13589, "12/02/2023 18:18");
        Posts p5 = new Posts(36778, "Fantastic day today. Congratulations to all winn ers.", "1258XE", 230, 1214, "6/06/2023 21:00");

        post.add(p1);
        post.add(p2);
        post.add(p3);
        post.add(p4);
        post.add(p5);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SocialMedia.class.getResource("LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 450);
        stage.setTitle("Social Media Manager - Login");
        stage.setScene(scene);
        stage.show();

        ListView<String> listView = new ListView<>();
        ObservableList<String> PostList;
        listView.setItems(Post);

        // Add items to the list
        Post.add("Item 1");
        Post.add("Item 2");
        Post.add("Item 3");

        VBox layout = new VBox(10);
        layout.getChildren().add(listView);
    }



}
