package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HelloController {
    private Admin admin;
    @FXML
    private Label welcomeText;
    public void setAdmin(Admin admin) {
        this.admin=admin;
    }
    @FXML
    protected void onHelloButtonClick() throws IOException {
        HomePageApplication homepage=new HomePageApplication();
        Stage window=(Stage)welcomeText.getScene().getWindow();
        homepage.start(window,admin);
    }
}