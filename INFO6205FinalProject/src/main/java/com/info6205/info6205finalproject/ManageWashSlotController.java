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

public class ManageWashSlotController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Admin admin;
    @FXML
    private Button washingSlot1,washingSlot2,washingSlot3,washingSlot4,washingSlot5,washingSlot6,washingSlot7,washingSlot8;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setColor(){
        Button[] buttons = {washingSlot1,washingSlot2,washingSlot3,washingSlot4,washingSlot5,washingSlot6,washingSlot7,washingSlot8};
        for(int i=0;i<=7;i++){
            WorkingSlot slot=admin.getBst().getWorkingSlot(i+1);
            if(slot.isEmpty()){
                buttons[i].setStyle("-fx-background-color: green;");
            }else if(slot.getStatus().equals("Processing")){
                buttons[i].setStyle("-fx-background-color: red;");
            }else if(slot.getStatus().equals("Finished")){
                buttons[i].setStyle("-fx-background-color: blue;");
            }
        }
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

        Button clickedButton = (Button) event.getSource();
        String buttonText = clickedButton.getText();
        int slotIndex=Integer.parseInt(buttonText);
        System.out.println(slotIndex);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageSlot.fxml"));
        root = loader.load();
        ManageSlot controller = loader.getController();
        controller.setAdmin(admin);
        controller.setSlot(admin.getBst().getWorkingSlot(slotIndex));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void nextDayAction(ActionEvent event)throws IOException{

    }

}
