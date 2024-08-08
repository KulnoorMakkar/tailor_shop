package com.example.proj.measexpp;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MeasExpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField orc;

    @FXML
    private ComboBox<String> ors;

    @FXML
    private TableView<MesureBean> table;

    @FXML
    private ComboBox<String> wor;

    @FXML
    void doexport(ActionEvent event) {

    }

    @FXML
    void dofetch(ActionEvent event) {

    }

    @FXML
    void doshow(ActionEvent event) {

    }

    @FXML
    void dostatus(ActionEvent event) {
    }

    @FXML
    void doworker(ActionEvent event) {
        table.getItems().clear();
        table.setItems(getItems());
    }
ObservableList<MesureBean> getItems()
{
    ObservableList<MesureBean> ary = FXCollections.observableArrayList();
    try {
        stmt = con.prepareStatement("select * from Mesurement");
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            MesureBean mes = new MesureBean(res.getString("orderid"),res.getString("ename"),res.getString("mobile"),res.getString("dress"),res.getString("dod"),res.getInt("qty"),res.getInt("bill"),res.getString("mesurements"),res.getString("worker"),res.getInt("stat"));
            ary.add(mes);
        }

    }
    catch(Exception exp)
    {
        exp.printStackTrace();
    }
    return  ary;
}
    Connection con = null;
    PreparedStatement stmt = null;

    @FXML
    void initialize() {
        con=MySqlConnectionKlass.doConnect();
        String str[] = {"In Process","Order Recived","Delivered"};
        ors.getItems().addAll(str);
        TableColumn<MesureBean,String> Corderid = new TableColumn<>("Order ID");
        Corderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));

        TableColumn<MesureBean,String> Cname = new TableColumn<>("Name");
        Cname.setCellValueFactory(new PropertyValueFactory<>("ename"));

        TableColumn<MesureBean,String> Cmobile = new TableColumn<>("Mobile");
        Cmobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<MesureBean,String> Cdress = new TableColumn<>("Dress");
        Cdress.setCellValueFactory(new PropertyValueFactory<>("dress"));

        TableColumn<MesureBean,String> Cdod = new TableColumn<>("Date of Delivery");
        Cdod.setCellValueFactory(new PropertyValueFactory<>("dod"));

        TableColumn<MesureBean,String> Cqty = new TableColumn<>("Quantity");
        Cqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        TableColumn<MesureBean,String> Cbill = new TableColumn<>("Bill");
        Cbill.setCellValueFactory(new PropertyValueFactory<>("bill"));

        TableColumn<MesureBean,String> Cworker = new TableColumn<>("Worker");
        Cworker.setCellValueFactory(new PropertyValueFactory<>("worker"));


        table.getColumns().addAll(Corderid,Cname,Cmobile,Cdress,Cdod,Cqty,Cbill);


    }

}
