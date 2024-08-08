package com.example.proj.measexpp;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnectionKlass// extends Application
{
    public static Connection doConnect()
    {
    //@Override
    //public void start(Stage primaryStage){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/java2024", "root", "#Kush3010");
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
