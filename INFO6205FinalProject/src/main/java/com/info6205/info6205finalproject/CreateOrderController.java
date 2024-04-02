package com.info6205.info6205finalproject;

import com.info6205.algorithm.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private Stage stage;
    private Scene scene;
    private Parent root;
    private Order newOrder;
    private Admin admin;
    ObservableList<Cloth> cloths;
   @FXML
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
        colorBox.getItems().addAll("White", "Dark", "Light");
        colorBox.getSelectionModel().select("Color");

        materialBox.getItems().removeAll(colorBox.getItems());
        materialBox.getItems().addAll("Cotton", "Denim", "Wool","Polyester");
        materialBox.getSelectionModel().select("Material");
        showTable();
    }
    @FXML
    private Button backButton;
    @FXML
    protected void onBackButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
        root=loader.load();
        HomePageController controller=loader.getController();
        controller.setAdmin(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();

        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    protected void onCheckOutButtonClick(ActionEvent event) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String newID = currentTime.format(formatter);

        newOrder=new Order(newID);

        for(Cloth cloth:cloths){
            newOrder.add(cloth);
        }
        manageNewOrder(newOrder);
        System.out.println(admin.getQueue());



        FXMLLoader loader=new FXMLLoader(getClass().getResource("ManageOrder.fxml"));
        root=loader.load();
        ManageOrderController controller=loader.getController();
        controller.setAdmin(admin);
        controller.setOrderList(admin);
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        if(admin==null)
            System.out.println("Yes");
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void showTable() throws IOException {

        colorColumn.setCellValueFactory(data -> data.getValue().colorProperty());

        materialColumn.setCellValueFactory(data -> data.getValue().materialProperty());


        cartTable.setItems(cloths);
    }
    @FXML
    protected void manageNewOrder(Order order){
        //add new order to the orderlist in admin
        admin.getOrderList().add(order);
        TreeToCategorizeCloth tree=new TreeToCategorizeCloth();
        List<PendingClothGroup>list=tree.manageOrder(order);
        for(PendingClothGroup group:list){
            admin.getQueue().enqueue(group,1);
        }
    }

}
