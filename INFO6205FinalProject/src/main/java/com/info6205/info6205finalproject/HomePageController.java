package com.info6205.info6205finalproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {
    @FXML
    private Button backButton;
    @FXML
    private Button createOrderButton;
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
        createOrderApplication.start(window);
    }
}
