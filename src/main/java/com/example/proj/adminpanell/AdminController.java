package com.example.proj.adminpanell;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.proj.HelloApplication;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.chart.PieChart;

public class AdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button about;

    @FXML
    private Button cust;

    @FXML
    private Button list;

    @FXML
    private Button meas;

    @FXML
    private Button mesexp;

    @FXML
    private Button ords;

    @FXML
    private PieChart pie;

    @FXML
    private PasswordField pass;

    @FXML
    private Button read;

    @FXML
    private Button work;

    @FXML
    void dodelivery(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("oordelvry/OrderView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Order Delivery");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    @FXML
    void doenroll(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ccust/CustView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Do Enrollment");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    @FXML
    void domeasure(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mmeasure/MeasureView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Do Measure");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }


    String ts="pass";

    @FXML
    void dounlock(ActionEvent event) {
        String ms=pass.getText();

        if(!Objects.equals(ms, ts))
        {
            System.out.println("Password does not match");
            cust.setDisable(true);
            meas.setDisable(true);
            mesexp.setDisable(true);
            work.setDisable(true);
            list.setDisable(true);
            read.setDisable(true);
            ords.setDisable(true);
            about.setDisable(true);
        }
        if(Objects.equals(ms,ts))
        {
            System.out.println("Password match");
            cust.setDisable(false);
            meas.setDisable(false);
            mesexp.setDisable(false);
            work.setDisable(false);
            list.setDisable(false);
            read.setDisable(false);
            ords.setDisable(false);
            about.setDisable(false);
        }

    }

    @FXML
    void doabout(ActionEvent event) {

    }

    @FXML
    void getexplorer(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mmeasexp/MeasExpView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Measurement");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    @FXML
    void getlist(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sspl/SplView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Do Enrollment");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    @FXML
    void getready(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rready/ReadyView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Do Enrollment");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    @FXML
    void getworker(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wworker/WorkerView.fxml"));

            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Do Enrollment");
            stage.setScene(scene);
            stage.show();
        }catch(Exception exp)
        {
            exp.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert pass != null : "fx:id=\"pass\" was not injected: check your FXML file 'AdminView.fxml'.";
        assert pie != null : "fx:id=\"pie\" was not injected: check your FXML file 'AdminView.fxml'.";
        ObservableList<PieChart.Data> data = FXCollections.observableArrayList(new PieChart.Data("In Process",3),new PieChart.Data("Delivered",5),new PieChart.Data("Received",4));
        pie.setData(data);
    }

}
