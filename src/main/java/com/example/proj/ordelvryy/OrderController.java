package com.example.proj.ordelvryy;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class OrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea bil;

    @FXML
    private TextArea drs;

    @FXML
    private TextField mobile;

    @FXML
    private TextArea ord;

    @FXML
    private TextArea sts;

    @FXML
    private TextField total;

    @FXML
    void dodeliver(ActionEvent event) {

    }

    PreparedStatement smt;

    @FXML
    void dosearch(ActionEvent event) {
        try {
            smt = conn.prepareStatement("select * from measure where mobile=?");
            //smt.setString();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    Connection conn;

    @FXML
    void initialize() {

        conn = MySqlConnectionKlass.doConnect();
        if(conn==null)
            System.out.println("Connection did not established");
        else
            System.out.println("Connection Established");
        /*
        assert bil != null : "fx:id=\"bil\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert drs != null : "fx:id=\"drs\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert ord != null : "fx:id=\"ord\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert sts != null : "fx:id=\"sts\" was not injected: check your FXML file 'OrderView.fxml'.";
        assert total != null : "fx:id=\"total\" was not injected: check your FXML file 'OrderView.fxml'.";
         */
    }

}
