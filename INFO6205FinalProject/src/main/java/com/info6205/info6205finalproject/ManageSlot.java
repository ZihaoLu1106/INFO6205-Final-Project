package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import com.info6205.algorithm.WorkingSlot;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageSlot {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Admin admin;

    private WorkingSlot slot;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setSlot(WorkingSlot slot){
        this.slot=slot;
    }
    @FXML
    private Button backButton;

    @FXML
    protected void onBackButtonClickWashing(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageWashSlot.fxml"));
        root = loader.load();
        ManageWashSlotController controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
