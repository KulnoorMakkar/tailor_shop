package com.example.proj.readyy;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import com.example.proj.custt.MySqlConnectionKlass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class ReadyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> date;

    @FXML
    private ListView<String> dress;

    @FXML
    private ListView<String> order;

    @FXML
    private ComboBox<String> wname;

    @FXML
    void doreceive(MouseEvent event) {
        if(event.getClickCount()==2)
        {
            final int or=order.getSelectionModel().getSelectedIndex();
            dress.getSelectionModel().select(order.getSelectionModel().getSelectedIndex());
            date.getSelectionModel().select(order.getSelectionModel().getSelectedIndex());
            order.getItems().remove(or);

        }


    }

    @FXML
    void dotext(ActionEvent event) {
        order.getItems().clear();
        dress.getItems().clear();
        date.getItems().clear();

        if(wname.getSelectionModel().getSelectedIndex()==1)
        {
            order.getItems().addAll(ord1);
            dress.getItems().addAll(dress1);
            date.getItems().addAll(deli1);
        }
        else if(wname.getSelectionModel().getSelectedIndex()==2)
        {
            order.getItems().addAll(ord2);
            dress.getItems().addAll(dress2);
            date.getItems().addAll(deli2);
        }
        else
            if(wname.getSelectionModel().getSelectedIndex()==3)
            {
                order.getItems().addAll(ord3);
                dress.getItems().addAll(dress3);
                date.getItems().addAll(deli3);
            }
            else
            {
                order.getItems().clear();
                dress.getItems().clear();
                date.getItems().clear();
            }


    }

    String ord1[]= {"465","469","473","477"};
    String dress1[]= {"pent","shirt","shirt","shirt"};
    String deli1[]= {"22/07/2024","22/07/2024","23/07/2024","29/07/2024"};

    String ord2[]= {"481","482","485","488"};
    String dress2[]= {"kurta","skirt","kurta","skirt"};
    String deli2[]= {"21/07/2024","22/07/2024","24/07/2024","29/07/2024"};

    String ord3[]= {"425","429","431","437"};
    String dress3[]= {"coat","coat","coat","coat"};
    String deli3[]= {"20/07/2024","22/07/2024","23/07/2024","30/07/2024"};

    @FXML
    void received(ActionEvent event) {
        order.getItems().clear();
        dress.getItems().clear();
        date.getItems().clear();

    }

    Connection conn=null;
    PreparedStatement smt=null;

    @FXML
    void initialize() {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'ReadyView.fxml'.";
        assert dress != null : "fx:id=\"dress\" was not injected: check your FXML file 'ReadyView.fxml'.";
        assert order != null : "fx:id=\"order\" was not injected: check your FXML file 'ReadyView.fxml'.";
        assert wname != null : "fx:id=\"wname\" was not injected: check your FXML file 'ReadyView.fxml'.";

        String worker[]={"Select","aman","raman","chaman"};
        wname.getItems().addAll(worker);
        wname.getSelectionModel().select(0);

        conn= MySqlConnectionKlass.doConnect();
        if(conn==null)
            System.out.println("Connection did not established");
        else
            System.out.println("Connection Doneee");

    }

}
