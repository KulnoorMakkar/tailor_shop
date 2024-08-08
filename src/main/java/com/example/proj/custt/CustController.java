package com.example.proj.custt;

//import java.net.URL;
//import java.util.ResourceBundle;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.TextField;
//import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;


public class CustController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField city;

    @FXML
    private DatePicker dob;

    @FXML
    private TextField gender;

    @FXML
    private TextField mobile;

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private ImageView pic;

    @FXML
    void doclear(ActionEvent event) {
        try {
            smt = conn.prepareStatement("delete from customer where mobile=?");
            smt.setString(2, mobile.getText());
            int count=smt.executeUpdate();
            if(count==1)
                showMsg("Record Deleted Successfully");
            else
                showMsg("Invalid mobile");
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    void showMsg(String msg)
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("Inportant Notification");
        alert.setHeaderText("Its Message");
        alert.setContentText(msg);
        alert.showAndWait();

    }
    Connection conn=null;
    PreparedStatement smt=null;

    @FXML
    void doedit(ActionEvent event) {
        try
        {
            smt=conn.prepareStatement("Select * from customer where mobile=?");
            smt.setString(2, mobile.getText());
            ResultSet record= smt.executeQuery();
            while(record.next())
            {
                String na= record.getString("name");
                String mob= record.getString("mobile");
                String gen= record.getString("gender");
                String cit= record.getString("city");
                Date db= record.getDate("dob");
                String picc= record.getString("picpath");
                System.out.println(na+"   "+mob+"    "+gen+"   "+cit+"   "+db+"   "+picc);
                name.setText(na);
                mobile.setText(mob);
                gender.setText(gen);
                city.setText(cit);
                dob.setValue(db.toLocalDate());
                if(!picc.equals("nopic.jpg"))
                {
                    filepath=picc;
                    pic.setImage(new Image(new FileInputStream(picc)));
                }
            }
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }

    }

    String filepath="C:\\Dev\\Proj\\src\\main\\resources\\com\\example\\proj\\ccust\\work.jpg";

    @FXML
    void doenroll(ActionEvent event) {
        try
        {
            smt= conn.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
            smt.setString(1, name.getText());
            smt.setString(2,mobile.getText());
            smt.setString(3,email.getText());
            smt.setString(4, gender.getText());
            smt.setString(5, city.getText());
           // LocalDate local=dob.getValue();
            //java.sql.Date dat=java.sql.Date.valueOf(local);
            smt.setDate(6, Date.valueOf(dob.getValue()));
            smt.setString(7, filepath);
            smt.executeUpdate();
            System.out.println("Record saved successfully");
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("DOne!");
            al.showAndWait();
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    @FXML
    void dofetch(ActionEvent event) {
        FileChooser chooser=new FileChooser();
        chooser.setTitle("Select customer pic:");
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

    @FXML
    void initialize() {

conn=MySqlConnectionKlass.doConnect();
if(conn==null)
    System.out.println("Connection did not established");
else
    System.out.println("Connection Doneee");


    }

}
