package com.info6205.info6205finalproject;
import com.info6205.algorithm.Admin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    private Admin admin;
    public void setAdmin(Admin admin) {
        this.admin=admin;
    }
    @FXML
    private Button backButton;
    @FXML
    private Button createOrderButton;
    @FXML
    private Button manageOrderButton;
    @FXML
    private Button manageWashingSlotButton;
    @FXML
    private Button reviewRevenueButton;
    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    protected void onBackButtonClick() throws IOException {
        HelloApplication helloApplication=new HelloApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        helloApplication.start(window);
    }
    @FXML
    protected void onCreateNewButtonClick(ActionEvent event)throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("CreateOrder.fxml"));
        root=loader.load();
        CreateOrderController controller=loader.getController();
        controller.setAdmin(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        if(admin==null)
            System.out.println("Yes");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onManageOrderButtonClick(ActionEvent event)throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageOrder.fxml"));
        root=loader.load();
        ManageOrderController controller=loader.getController();
        controller.setAdmin(admin);
        controller.setOrderList(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        if(admin==null)
            System.out.println("Yes");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onManageWashingSlotButtonClick(ActionEvent event)throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageWashSlot.fxml"));
        root=loader.load();
        ManageWashSlotController controller=loader.getController();
        controller.setAdmin(admin);
        controller.setColor();
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        if(admin==null)
            System.out.println("Yes");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void onCheckRevenueButtonClick(ActionEvent event)throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("CheckRevenue.fxml"));
        root=loader.load();
        CheckRevenueController controller=loader.getController();
        controller.setAdmin(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        if(admin==null)
            System.out.println("Yes");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
