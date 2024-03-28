package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckRevenueController {
    private Admin admin;
    public void setAdmin(Admin admin) {
        this.admin=admin;
    }
    @FXML
    private Button backButton;
    @FXML
    protected void onBackButtonClick() throws IOException {
        HomePageApplication homePageApplication=new HomePageApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        homePageApplication.start(window,admin);
    }
}
