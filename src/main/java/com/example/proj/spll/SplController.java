package com.example.proj.spll;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.example.proj.measexpp.MesureBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SplController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> spes;

    @FXML
    private TableView<SplBean> table;

    @FXML
    private ComboBox<String> worker;

    PreparedStatement stmt;

    @FXML
    void dospec(ActionEvent event) {
        if(spes.getSelectionModel().getSelectedIndex()==1)
        {
            worker.getItems().clear();
            worker.getItems().addAll(name1);
            worker.getSelectionModel().select(0);
        }
        else
            if(spes.getSelectionModel().getSelectedIndex()==2)
            {
                worker.getItems().clear();
                worker.getItems().addAll(name2);
                worker.getSelectionModel().select(0);
            }
            else
                if(spes.getSelectionModel().getSelectedIndex()==3)
                {
                    worker.getItems().clear();
                    worker.getItems().addAll(name3);
                    worker.getSelectionModel().select(0);
                }
                else
                {
                    worker.getItems().clear();
                }


    }

    @FXML
    void dowork(ActionEvent event) {
        table.getItems().clear();
        table.setItems(getItems());
    }
    ObservableList<SplBean> getItems()
    {
        ObservableList<SplBean> ary = FXCollections.observableArrayList();
        try {
            stmt = con.prepareStatement("select * from Mesurement");
            ResultSet res = stmt.executeQuery();
            while (res.next()) {
                SplBean mes = new SplBean(res.getString("orderid"),res.getString("ename"),res.getString("mobile"),res.getString("dress"),res.getString("dod"),res.getInt("qty"),res.getInt("bill"),res.getString("mesurements"),res.getString("worker"),res.getInt("stat"));
                ary.add(mes);
            }

        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
        return  ary;

    }

    PreparedStatement smt=null;
    Connection con;

    String name1[]={"select","madhu","rood"};
    String name2[]={"select","sohan","mohan"};
    String name3[]={"select","raman","chaman"};

    @FXML
    void initialize() {

        String specz[]={"select","coat","pent","shirt"};
        spes.getItems().addAll(specz);
        spes.getSelectionModel().select(0);
        String def[]={"select"};
        worker.getItems().addAll(def);
        worker.getSelectionModel().select(0);

        con=MySqlConnectionKlass.doConnect();
        if(con==null)
            System.out.println("Connection did not established");
        else
            System.out.println("Connection Established");

        TableColumn<SplBean,String> Corderid = new TableColumn<>("Order ID");
        Corderid.setCellValueFactory(new PropertyValueFactory<>("orderid"));

        TableColumn<SplBean,String> Cname = new TableColumn<>("Name");
        Cname.setCellValueFactory(new PropertyValueFactory<>("ename"));

        TableColumn<SplBean,String> Cmobile = new TableColumn<>("Mobile");
        Cmobile.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<SplBean,String> Cdress = new TableColumn<>("Dress");
        Cdress.setCellValueFactory(new PropertyValueFactory<>("dress"));

        TableColumn<SplBean,String> Cdod = new TableColumn<>("Date of Delivery");
        Cdod.setCellValueFactory(new PropertyValueFactory<>("dod"));

        TableColumn<SplBean,String> Cqty = new TableColumn<>("Quantity");
        Cqty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        TableColumn<SplBean,String> Cbill = new TableColumn<>("Bill");
        Cbill.setCellValueFactory(new PropertyValueFactory<>("bill"));

        TableColumn<SplBean,String> Cworker = new TableColumn<>("Worker");
        Cworker.setCellValueFactory(new PropertyValueFactory<>("worker"));


        table.getColumns().addAll(Corderid,Cname,Cmobile,Cdress,Cdod,Cqty,Cbill);



        assert spes != null : "fx:id=\"spes\" was not injected: check your FXML file 'SplView.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'SplView.fxml'.";
        assert worker != null : "fx:id=\"worker\" was not injected: check your FXML file 'SplView.fxml'.";

    }

}
