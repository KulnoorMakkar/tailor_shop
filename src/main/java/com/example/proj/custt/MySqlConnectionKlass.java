package com.example.proj.custt;

import javafx.application.Application;
import javafx.stage.Stage;

import java.net.SocketOption;
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.DriverManager;
import java.sql.Connection;

public class MySqlConnectionKlass// extends Application
{
    public static Connection doConnect()
    {
    //@Override
    //public void start(Stage primaryStage){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/java24", "root", "noornanu");
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return conn;
    }
    //}
    public static void main(String[] args)
    {
        if(doConnect()==null)
            System.out.println("Sorry");
        else
            System.out.println("Badahaiiii");
        //launch(args);
    }

}
