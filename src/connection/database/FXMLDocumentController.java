/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.database;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.sql.*;

/**
 *
 * @author tzlat
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        connect();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connect();
    }

    private void connect() {
        try {
//step1 load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");

//step2 create  the connection object  
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:st61059:@fei-sql1.upceucebny.cz:1521:IDAS", "st61059", "11558822");

//step3 create the statement object  
            Statement stmt = con.createStatement();

//step4 execute query  
            ResultSet rs = stmt.executeQuery("select * from adopce");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }

//step5 close the connection object  
            con.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}

