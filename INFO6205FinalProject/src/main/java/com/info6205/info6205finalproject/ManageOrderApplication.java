package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageOrderApplication {
    public void start(Stage stage, Admin admin) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ManageOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        ManageOrderController controller=new ManageOrderController();
        controller.setAdmin(admin);
        stage.setTitle("Manage Orders!");
        stage.setScene(scene);
        stage.show();
    }
}
