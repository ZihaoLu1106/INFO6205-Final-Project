package com.info6205.info6205finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException {
        HomePageApplication homepage=new HomePageApplication();
        Stage window=(Stage)welcomeText.getScene().getWindow();
        homepage.start(window);
    }
}