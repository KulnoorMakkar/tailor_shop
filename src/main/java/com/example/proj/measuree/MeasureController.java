package com.example.proj.measuree;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
//import javamail.default.address.map;
import javax.mail.Session;

public class MeasureController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField bill;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<String> dress;

    @FXML
    private TextField email;

    @FXML
    private TextArea mesr;

    @FXML
    private TextField mobile;

    @FXML
    private TextField order;

    @FXML
    private ImageView pic;

    @FXML
    private TextField price;

    @FXML
    private ComboBox<String> quantity;

    @FXML
    private ComboBox<String> worker;

    @FXML
    void doclose(ActionEvent event) {

    }

    @FXML
    void dodress(ActionEvent event) {

    }

    @FXML
    void doexisting(ActionEvent event) {

    }

    @FXML
    void domail(ActionEvent event) {
        //SendMail("omsharangupt@gmail.com","mail","java","Hello Programmer");


    }

    @FXML
    void donew(ActionEvent event) {
        

    }

    //int ord=1;
    /*
    public static void SendMail(String to, String cname, String Subj, String emailBody) {
        String from = "omsharanaggarwal@gmail.com"; // sender's email
        final String username = "omsharanaggarwal@gmail.com"; // your Gmail address
        final String password = "liwu bojs dmnk duaz"; // your app password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(Subj);
            message.setText(emailBody);
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    */
    @FXML
    void doorder(ActionEvent event)
    {
        //SendMail("omsharangupt@gmail.com","mail","java","Hello Programmer");
        //System.out.println("Mail Send Successfully");
    }

    PreparedStatement smt;

    @FXML
    void dosave(ActionEvent event) {
        try
        {
            smt=conn.prepareStatement("insert into Mesurement values(?,?,?,?,?,?,?,?,?,?,?) ");
            smt.setString(1, mobile.getText());
            smt.setString(2,dress.getSelectionModel().getSelectedItem());
            LocalDate loca=date.getValue();
            java.sql.Date dat=java.sql.Date.valueOf(loca);
            smt.setDate(3,dat);
            smt.setString(4,email.getText());
            smt.setInt(5,Integer.parseInt(quantity.getSelectionModel().getSelectedItem()));
            smt.setString(6,filepath);
            smt.setInt(7,Integer.parseInt(price.getText()));
            smt.setInt(8,Integer.parseInt(bill.getText()));
            smt.setString(9,mesr.getText());
            smt.setString(10,worker.getSelectionModel().getSelectedItem());
            smt.setInt(11,Integer.parseInt(order.getText()));
            smt.executeUpdate();
            System.out.println("Record Saved Successfully");
        }
        catch(Exception exp)
        {
            exp.printStackTrace();
        }

    }

    @FXML
    void dosend(ActionEvent event) {
        SendMail.SendMail(email.getText(),"mail","Order","Order id for stitching is "+order.getText());


    }

    @FXML
    void doupdate(ActionEvent event) {

    }

    String filepath="C:\\Dev\\Proj\\src\\main\\resources\\com\\example\\proj\\mmeasure\\design.jpg";


    @FXML
    void doupload(ActionEvent event)
    {
        FileChooser chooser=new FileChooser();
        chooser.setTitle("Select Measurement pic:");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png"),
                new FileChooser.ExtensionFilter("*.*","*.*")
        );
        File file=chooser.showOpenDialog(null);
        filepath=file.getAbsolutePath();
        try {
            pic.setImage(new Image(new FileInputStream(file)));

        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }

    }

    Connection conn;
    Connection mael;

    @FXML
    void initialize() {

        conn=MySqlConnectionKlass.doConnect();
        if(conn==null)
            System.out.println("Connection Did Not Established");
        else
            System.out.println("Connection Established");


        assert bill != null : "fx:id=\"bill\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert dress != null : "fx:id=\"dress\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert email != null : "fx:id=\"email\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert mesr != null : "fx:id=\"mesr\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert mobile != null : "fx:id=\"mobile\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert order != null : "fx:id=\"order\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert pic != null : "fx:id=\"pic\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert price != null : "fx:id=\"price\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert quantity != null : "fx:id=\"quantity\" was not injected: check your FXML file 'MeasureView.fxml'.";
        assert worker != null : "fx:id=\"worker\" was not injected: check your FXML file 'MeasureView.fxml'.";

    }

}