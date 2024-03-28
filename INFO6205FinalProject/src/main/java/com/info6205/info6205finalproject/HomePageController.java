package com.info6205.info6205finalproject;
import com.info6205.algorithm.Admin;
import javafx.fxml.FXML;
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


    @FXML
    protected void onBackButtonClick() throws IOException {
        HelloApplication helloApplication=new HelloApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        helloApplication.start(window);
    }
    @FXML
    protected void onCreateNewButtonClick()throws IOException {
        CreateOrderApplication createOrderApplication=new CreateOrderApplication();
        Stage window=(Stage)createOrderButton.getScene().getWindow();
        createOrderApplication.start(window,admin);
    }
    @FXML
    protected void onManageOrderButtonClick()throws IOException {
        ManageOrderApplication manageOrderApplication=new ManageOrderApplication();
        Stage window=(Stage)manageOrderButton.getScene().getWindow();
        manageOrderApplication.start(window,admin);
    }
    @FXML
    protected void onManageWashingSlotButtonClick()throws IOException {
        ManageWashSlotApplication manageWashSlotApplication=new ManageWashSlotApplication();
        Stage window=(Stage)manageWashingSlotButton.getScene().getWindow();
        manageWashSlotApplication.start(window,admin);
    }
    @FXML
    protected void onCheckRevenueButtonClick()throws IOException {
        CheckRevenueApplication checkRevenueApplication=new CheckRevenueApplication();
        Stage window=(Stage)reviewRevenueButton.getScene().getWindow();
        checkRevenueApplication.start(window,admin);
    }

}
