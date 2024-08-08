module com.example.proj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires com.dlsc.formsfx;
    requires java.desktop;
    requires java.mail;
    requires activation;

    opens com.example.proj to javafx.fxml;
    exports com.example.proj;

    exports com.example.proj.custt;
    opens com.example.proj.custt to javafx.fxml;

    exports com.example.proj.workerr;
    opens com.example.proj.workerr to javafx.fxml;

    exports com.example.proj.measurr;
    opens com.example.proj.measurr to javafx.fxml;

    exports com.example.proj.readyy;
    opens com.example.proj.readyy to javafx.fxml;

    exports com.example.proj.spll;
    opens com.example.proj.spll to javafx.fxml;

    exports com.example.proj.measexpp;
    opens com.example.proj.measexpp to javafx.fxml;

    exports com.example.proj.emails;
    opens com.example.proj.emails to javafx.fxml;

    exports com.example.proj.measuree;
    opens com.example.proj.measuree to javafx.fxml;

    exports com.example.proj.ordelvryy;
    opens com.example.proj.ordelvryy;

    exports com.example.proj.adminpanell;
    opens com.example.proj.adminpanell;

}