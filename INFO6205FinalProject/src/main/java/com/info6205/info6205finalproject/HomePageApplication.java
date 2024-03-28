package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class HomePageApplication{
    public void start(Stage stage,Admin admin) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HomePageApplication.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("HomePage!");

        HomePageController controller=new HomePageController();
        controller.setAdmin(admin);
        stage.setScene(scene);
        stage.show();
    }

}
