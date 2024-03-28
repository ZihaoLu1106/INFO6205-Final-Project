package com.info6205.info6205finalproject;
import com.info6205.algorithm.Admin;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class CreateOrderApplication {
    public void start(Stage stage, Admin admin ) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreateOrderApplication.class.getResource("CreateOrder.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        CreateOrderController controller=new CreateOrderController();
        controller.setAdmin(admin);
        stage.setTitle("Create New Order!");
        stage.setScene(scene);
        stage.show();
    }
}
