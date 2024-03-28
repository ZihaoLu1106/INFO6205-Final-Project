package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckRevenueApplication {
    public void start(Stage stage, Admin admin) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CheckRevenueApplication.class.getResource("CheckRevenue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        CheckRevenueController controller=new CheckRevenueController();
        controller.setAdmin(admin);
        stage.setTitle("Check Revenue!");
        stage.setScene(scene);
        stage.show();
    }
}
