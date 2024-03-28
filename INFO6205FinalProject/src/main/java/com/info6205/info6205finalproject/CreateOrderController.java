package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import com.info6205.algorithm.Cloth;
import com.info6205.algorithm.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderController {
    private Order newOrder;
    private Admin admin;
    ObservableList<Cloth> cloths;
    public void setAdmin(Admin admin) {
        this.admin=admin;
    }

    @FXML
    private ComboBox<String>colorBox;
    @FXML
    private ComboBox<String>materialBox;
    @FXML
    private TableView<Cloth> cartTable;
    @FXML
    private TableColumn<Cloth, String> colorColumn;

    @FXML
    private TableColumn<Cloth, String> materialColumn;
    @FXML
    private Button addButton;
    @FXML
    private Button checkOutButton;
    @FXML
    public void initialize() throws IOException {
        cloths = FXCollections.observableArrayList();

        colorBox.getItems().removeAll(colorBox.getItems());
        colorBox.getItems().addAll("White", "Deep", "Light");
        colorBox.getSelectionModel().select("Color");

        materialBox.getItems().removeAll(colorBox.getItems());
        materialBox.getItems().addAll("Cotton", "Denim", "Wool","Polyester");
        materialBox.getSelectionModel().select("Material");
        showTable();
    }
    @FXML
    private Button backButton;
    @FXML
    protected void onBackButtonClick() throws IOException {
        HomePageApplication homePageApplication=new HomePageApplication();
        Stage window=(Stage)backButton.getScene().getWindow();
        homePageApplication.start(window,admin);
    }
    @FXML
    protected void onAddButtonClick() throws IOException {
        String newColor=colorBox.getValue();
        String newMaterial=materialBox.getValue();

        Cloth newCloth=new Cloth(newColor,newMaterial);
        cloths.add(newCloth);
        showTable();

    }
    @FXML
    protected void onCheckOutButtonClick() throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");

        String newID = currentTime.format(formatter);

        newOrder=new Order(newID);

        for(Cloth cloth:cloths){
            newOrder.add(cloth);
        }

       /* System.out.println(newOrder.getOrderID());
        for(Cloth cloth:newOrder.getCloths())
            System.out.println(cloth.getColor()+" "+cloth.getMaterial());*/

    }
    @FXML
    protected void showTable() throws IOException {

        colorColumn.setCellValueFactory(data -> data.getValue().colorProperty());

        materialColumn.setCellValueFactory(data -> data.getValue().materialProperty());


        cartTable.setItems(cloths);
    }

}
