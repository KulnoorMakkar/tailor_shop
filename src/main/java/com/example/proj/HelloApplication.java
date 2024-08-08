package com.example.proj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
    //      FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ccust/CustView.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mmeasexp/MeasExpView.fxml"));
     //   FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mmeasure/MeasureView.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mmeasur/MeasurView.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rready/ReadyView.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("sspl/SplView.fxml"));
    //    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wworker/WorkerView.fxml"));
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("aadminpanel/AdminView.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Admin Panel");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}