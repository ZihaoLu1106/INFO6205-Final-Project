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
    private ObservableList<PendingClothGroup> orderList;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    @FXML
    private TableView<PendingClothGroup> orderhistoryTable;
    @FXML
    private TableColumn<PendingClothGroup, String> orderIDColumn;
    @FXML
    private TableColumn<PendingClothGroup, String> clothNumColumn;
    @FXML
    private TableColumn<PendingClothGroup, String> methodColumn;



    public void setOrderList(Admin admin) {
        orderList = FXCollections.observableArrayList(admin.getQueue().getList());
    }

    @FXML
    public void initialize() throws IOException {
        showTable();
    }
    @FXML
    protected void showTable() {

        orderIDColumn.setCellValueFactory(data -> data.getValue().idProperty());
        clothNumColumn.setCellValueFactory(data -> data.getValue().numProperty());
        methodColumn.setCellValueFactory(data -> data.getValue().methodProperty());
        orderhistoryTable.setItems(orderList);
    }


    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageOrder.fxml"));
        root = loader.load();
        ManageOrderController controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
