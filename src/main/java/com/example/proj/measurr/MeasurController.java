package com.example.proj.measurr;

import java.io.File;
import java.lang.String;
import java.lang.Integer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;

import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.ResourceBundle;

import com.example.proj.custt.MySqlConnectionKlass;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.scene.image.ImageView;

import javax.swing.*;

import static javafx.scene.image.Image.*;

public class MeasurController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView pic;

    @FXML
    private TextField bill;

    @FXML
    private DatePicker delivery;

    @FXML
    private ComboBox<String> dress;

    @FXML
    private TextField email;

    @FXML
    private ListView<String> meas;

    @FXML
    private TextField mobile;

    @FXML
    private TextField prc;

    @FXML
    private ComboBox<String> qty;

    @FXML
    private ListView<String> siz;

    @FXML
    void dobill(ActionEvent event) {
        //String qt=(qty.toString());
        //String pc=(prc.toString());

        //bill= .getEditor()(prc);
    }

    @FXML
    void doclose(ActionEvent event) {

    }

    //dress = FXCollections.observableArrayList(arrayList);

    @FXML
    void donew(ActionEvent event) {
        mobile.setText("");
        dress.getItems().clear();

        delivery.setValue(LocalDate.parse("dd/mm/year"));
        email.setText("");
        qty.getItems().clear();
        prc.setText("");
        //pic.setImage(filepath);


    }

    String filepath="C:\\Dev\\Proj\\src\\main\\resources\\com\\example\\proj\\mmeasur\\productive.jpg";


    @FXML
    void dosave(ActionEvent event) {
        try
        {
            smt= conn.prepareStatement("insert into measure values(?,?,?,?,?,?)");
            smt.setString(1, mobile.getText());
            smt.setInt(2, Integer.parseInt(dress.getSelectionModel().getSelectedItem()));
            smt.setDate(3, Date.valueOf(delivery.getValue()));

            smt.setString(4, email.getText());
            smt.setInt(5,Integer.parseInt(qty.getSelectionModel().getSelectedItem()));
            // LocalDate local=dob.getValue();
            //java.sql.Date dat=java.sql.Date.valueOf(local);
            smt.setString(6,prc.getText());
            smt.setString(7,bill.getText());
            smt.setString(8, filepath);
            smt.executeUpdate();
            System.out.println("Record saved successfully");
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("Doneeeee !");
            al.showAndWait();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }


    }

    @FXML
    void doupdate(ActionEvent event) {

    }

    @FXML
    void doupload(ActionEvent event)
    {
        FileChooser chooser=new FileChooser();
        chooser.setTitle("Select measure pic:");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png"),
                new FileChooser.ExtensionFilter("*.*","*.*")
        );
        File file=chooser.showOpenDialog(null);

        if(file!=null)
        {
            filepath = String.valueOf(file.getAbsoluteFile());
        }
        if(file==null)
        {

            filepath="C:\\Dev\\Proj\\src\\main\\resources\\com\\example\\proj\\ccust\\work.jpg";

        }
        try
        {
            if (file != null) {
                pic.setImage(new Image(new FileInputStream(file)));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    Connection conn=null;
    PreparedStatement smt=null;

    @FXML
    void initialize() {
        assert bill != null : "fx:id=\"bill\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert delivery != null : "fx:id=\"delivery\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert dress != null : "fx:id=\"dress\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert meas != null : "fx:id=\"meas\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert prc != null : "fx:id=\"prc\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert qty != null : "fx:id=\"qty\" was not injected: check your FXML file 'MeasurView.fxml'.";
        assert siz != null : "fx:id=\"siz\" was not injected: check your FXML file 'MeasurView.fxml'.";

        conn= MySqlConnectionKlass.doConnect();
        if(conn==null)
            System.out.println("Connection did not established");
        else
            System.out.println("Connection Doneee");
    }

}
