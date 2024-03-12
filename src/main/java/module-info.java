module com.example.hbv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.xerial.sqlitejdbc;


    opens com.example.hbv to javafx.fxml;
    exports com.example.hbv;
    exports com.example.hbv.tour;
    opens com.example.hbv.tour to javafx.fxml;
    exports com.example.hbv.user;
    opens com.example.hbv.user to javafx.fxml;
}