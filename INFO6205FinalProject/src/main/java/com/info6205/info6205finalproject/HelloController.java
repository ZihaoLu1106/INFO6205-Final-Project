package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Window;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label title;

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {

        Admin admin=Admin.getInstance();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePageController controller=loader.getController();
        controller.setAdmin(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}