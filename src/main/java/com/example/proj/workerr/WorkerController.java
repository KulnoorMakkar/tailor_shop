package com.example.proj.workerr;

import java.net.URL;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class WorkerController {

    @FXML
    private ResourceBundle resources;
/*
    @FXML
    private TextField splz1;

    @FXML
    private TextField splz11;
*/
    @FXML
    private URL location;

    @FXML
    private TextField address;

    @FXML
    private TextField mobile;

    @FXML
    private ListView<String> spec;

    @FXML
    private TextField splz;

    @FXML
    private TextField wname;

    @FXML
    void dodelete(ActionEvent event) {

    }

    String men[]={"Pent","Shirt","Coat"};
    String ladies[]={"Kurta","Suit"};
    //String shirt[]={"Shirt"};

String spl="";

    @FXML
    void dospecial(ActionEvent event) {
        spec.getItems().clear();

            spec.getItems().addAll(men);
            spec.getItems().addAll(ladies);

    }

    @FXML
    void donew(ActionEvent event) {
        spec.getItems().clear();
        splz.setText("");
        //splz1.setText("");
        //splz11.setText("");
        mobile.setText("");
        wname.setText("");
        address.setText("");
        count=0;

    }

    PreparedStatement smt;

    @FXML
    void dosave(ActionEvent event) {
        try {
            smt = conn.prepareStatement("insert into worker values(?,?,?,?)");
            smt.setString(1,wname.getText());
            smt.setString(2, address.getText());
            smt.setString(3, mobile.getText());
            smt.setString(4, splz.getText());
            smt.executeUpdate();
            System.out.println("Data Saved");
            Alert al =new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("Data Saved");
            al.showAndWait();
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }

    int count=0;
    @FXML
    void doselect(MouseEvent event) {
        if(event.getClickCount()==2)
        {

            if(count==0) {
                spl = spl.concat(spec.getSelectionModel().getSelectedItem());
                splz.setText(spl);
                count++;
            }
            else
            {
                spl = spl.concat(","+spec.getSelectionModel().getSelectedItem());
                splz.setText(spl);
                count++;
            }


        }

    }

    Connection conn;

    @FXML
    void initialize() {

        conn=MySqlConnectionKlass.doConnect();

        assert address != null : "fx:id=\"address\" was not injected: check your FXML file 'WorkerView.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'WorkerView.fxml'.";
        assert spec != null : "fx:id=\"spec\" was not injected: check your FXML file 'WorkerView.fxml'.";
        assert splz != null : "fx:id=\"splz\" was not injected: check your FXML file 'WorkerView.fxml'.";
        assert wname != null : "fx:id=\"wname\" was not injected: check your FXML file 'WorkerView.fxml'.";

    }

}
