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
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageSlot {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Admin admin;
    @FXML
    private Label slotIndex;
    @FXML
    private Pane showColor;

    private WorkingSlot slot;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setSlot(WorkingSlot slot){
        this.slot=slot;
        this.slotIndex.setText(String.valueOf(slot.getId()));
        if(slot.getStatus().equals("Processing")) {
            BackgroundFill backgroundFill = new BackgroundFill(Color.RED, null, null);
            Background background = new Background(backgroundFill);
            showColor.setBackground(background);
        }else if(slot.isEmpty()){
            BackgroundFill backgroundFill = new BackgroundFill(Color.GREEN, null, null);
            Background background = new Background(backgroundFill);
            showColor.setBackground(background);
        }

    }

    @FXML
    private Button backButton;

    @FXML
    protected void onBackButtonClickWashing(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageWashSlot.fxml"));
        root = loader.load();
        ManageWashSlotController controller = loader.getController();
        controller.setAdmin(admin);
        controller.setColor();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
