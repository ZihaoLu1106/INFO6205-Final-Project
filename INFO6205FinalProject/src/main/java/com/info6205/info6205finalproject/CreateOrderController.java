package com.info6205.info6205finalproject;

import com.info6205.algorithm.Order;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateOrderController {
    private Order newOrder;

    @FXML
    private ComboBox<String>colorBox;
    @FXML
    private ComboBox<String>materialBox;
    @FXML
    private TableView cartTable;
    @FXML
    private Button addButton;
    @FXML
    private Button checkPutButton;
    @FXML
    public void initialize() {
        newOrder=new Order();


        colorBox.getItems().removeAll(colorBox.getItems());
        colorBox.getItems().addAll("White", "Deep", "Light");
        colorBox.getSelectionModel().select("Color");

        materialBox.getItems().removeAll(colorBox.getItems());
        materialBox.getItems().addAll("Cotton", "Denim", "Wool","Polyester");
        materialBox.getSelectionModel().select("Material");
    }
    @FXML
    private Button backButton;
    @FXML
    protected void onBackButtonClick() throws IOException {
        HomePageApplication homePageApplication=new HomePageApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        homePageApplication.start(window);
    }
    @FXML
    protected void onAddButtonClick() throws IOException {
        HomePageApplication homePageApplication=new HomePageApplication();
        Stage window=(Stage)addButton.getScene().getWindow();
        homePageApplication.start(window);
    }
    @FXML
    protected void onCheckOutButtonClick() throws IOException {
        HomePageApplication homePageApplication=new HomePageApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        homePageApplication.start(window);
    }
    @FXML
    protected void showTable() throws IOException {

    }

}
