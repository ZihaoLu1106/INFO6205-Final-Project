package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageWashSlotController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @FXML
    private Button backButton;

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root = loader.load();
        HomePageController controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void MgnSlotButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageSlot.fxml"));
        root = loader.load();
        ManageSlot controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
