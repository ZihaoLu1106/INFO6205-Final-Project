package com.info6205.info6205finalproject;

import com.info6205.algorithm.Admin;
import com.info6205.algorithm.Cloth;
import com.info6205.algorithm.PendingClothGroup;
import com.info6205.algorithm.WorkingSlot;
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
import java.util.List;

public class ManageOrderController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Admin admin;

    private int slotIndex;

    private ObservableList<PendingClothGroup> orderList;
    @FXML
    private Label slotNumber;

    @FXML
    private TableView<PendingClothGroup> orderTable;
    @FXML
    private TableColumn<PendingClothGroup, String> orderIDColumn;
    @FXML
    private TableColumn<PendingClothGroup, String> clothNumColumn;
    @FXML
    private TableColumn<PendingClothGroup, String> methodColumn;
    @FXML
    private TableColumn<PendingClothGroup, String> duariongColumn;

    @FXML
    private TableColumn<Cloth, String> materialColumn;

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setOrderList(Admin admin) {
        orderList = FXCollections.observableArrayList(admin.getQueue().getList());
    }

    @FXML
    private Button backButton;

    @FXML
    public void initialize() throws IOException {
        showTable();
    }

    @FXML
    protected void showTable() {

        orderIDColumn.setCellValueFactory(data -> data.getValue().idProperty());

        clothNumColumn.setCellValueFactory(data -> data.getValue().numProperty());
        methodColumn.setCellValueFactory(data -> data.getValue().methodProperty());

        duariongColumn.setCellValueFactory(data -> data.getValue().durationProperty());


        orderTable.setItems(orderList);
    }

    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root = loader.load();
        HomePageController controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    protected void findEmptyWashingSlot() throws IOException {
        WorkingSlot emptySlot = admin.getBst().findEmptySlot();

        this.slotIndex = emptySlot.getId();
        slotNumber.setText(String.valueOf(slotIndex));
    }

    @FXML
    protected void checkOutProcess(ActionEvent event) throws IOException {
        PendingClothGroup removedGroup = admin.getQueue().dequeue();
        WorkingSlot currentslot = admin.getBst().getWorkingSlot(this.slotIndex);

        currentslot.setGroup(removedGroup);
        admin.getBst().useSlot(this.slotIndex);
        currentslot.setRemainTime(removedGroup.getDuration());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ManageSlot.fxml"));
        root = loader.load();
        ManageSlot controller = loader.getController();
        controller.setAdmin(admin);

        controller.setSlot(admin.getBst().getWorkingSlot(this.slotIndex));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void onOrderHistoryButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderHistory.fxml"));
        root = loader.load();
        OrderHistoryController controller = loader.getController();
        controller.setAdmin(admin);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
