package AirlineReservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.awt.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class FlightsController implements Initializable {

    @FXML
    public TextArea ta;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadFlights();
    }

    private void loadFlights(){
        try {
            Connection con = ConnectionDB.getConnection();

            String source = FlyHighController.source;
            String destination = FlyHighController.destination;

            Statement st=con.createStatement();
            ta.appendText("Flights\n");
            ResultSet rs = st.executeQuery("select * from flights where flight_from='"+source+"' and fdestination='"+destination+"';");
            while (rs.next()){
                ta.appendText(rs.getString(3).toUpperCase() + "\t\t");
                ta.appendText(rs.getString(4) + "\t\t");
                ta.appendText("Rs."+rs.getString(5));
                ta.appendText("\n");
            }

        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public void sortTime(){
        try {
            ta.setText("");
            Connection con = ConnectionDB.getConnection();

            String source = FlyHighController.source;
            String destination = FlyHighController.destination;

            Statement st=con.createStatement();
            ta.appendText("Flights\n");
            ResultSet rs = st.executeQuery("select * from flights where flight_from='"+source+"' and fdestination='"+destination+"' order by time;");
            while (rs.next()){
                ta.appendText(rs.getString(3).toUpperCase() + "\t\t");
                ta.appendText(rs.getString(4) + "\t\t");
                ta.appendText("Rs."+rs.getString(5));
                ta.appendText("\n");
            }

        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public void sortPrice(){
        try {
            ta.setText("");
            Connection con = ConnectionDB.getConnection();

            String source = FlyHighController.source;
            String destination = FlyHighController.destination;

            Statement st=con.createStatement();
            ta.appendText("Flights\n");
            ResultSet rs = st.executeQuery("select * from flights where flight_from='"+source+"' and fdestination='"+destination+"' order by price;");
            while (rs.next()){
                ta.appendText(rs.getString(3).toUpperCase() + "\t\t");
                ta.appendText(rs.getString(4) + "\t");
                ta.appendText("Rs."+rs.getString(5));
                ta.appendText("\n");
            }

        }
        catch (Exception e){
            e.getMessage();
        }
    }
}

