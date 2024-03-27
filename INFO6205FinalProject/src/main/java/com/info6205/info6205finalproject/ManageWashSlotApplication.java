package com.info6205.info6205finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageWashSlotApplication {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ManageWashSlotApplication.class.getResource("ManageWashSlot.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Manage Washing Slot!");
        stage.setScene(scene);
        stage.show();
    }
}
