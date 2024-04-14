package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import com.info6205.algorithm.Order;
import com.info6205.algorithm.Cloth;
import com.info6205.algorithm.PendingClothGroup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class OrderHistoryController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Admin admin;
    private ObservableList<Order> orderList;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @FXML
    private TableView<Order> orderhistoryTable;
    @FXML
    private TableColumn<Order, String> statusColumn;
    @FXML
    private TableColumn<Order, String> priceColumn;
    @FXML
    private TableColumn<Order, String> orderIDColumn;



    public void setOrderList(Admin admin) {
        for(Order order:admin.getOrderList()){
            order.checkStatus();
        }
        orderList = FXCollections.observableArrayList(admin.getOrderList());
    }

    @FXML
    public void initialize() throws IOException {
        showTable();
    }
    @FXML
    protected void showTable() {

        orderIDColumn.setCellValueFactory(data -> data.getValue().idProperty());
        statusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        priceColumn.setCellValueFactory(data -> data.getValue().priceProperty());
        orderhistoryTable.setItems(orderList);
    }


    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageOrder.fxml"));
        root = loader.load();
        ManageOrderController controller = loader.getController();
        controller.setAdmin(admin);
        controller.setOrderList(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
