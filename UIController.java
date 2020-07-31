package AirlineReservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;

public class UIController implements Initializable {

    @FXML
    public TextField Username;

    @FXML
    private PasswordField Password;

    @FXML
    public Label error;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void logIn() throws Exception
    {
        if(Username.getText().equals("") || Password.getText().equals(""))
        {
            AlertBox.error("Some Field is Empty");
            return;
        }
        if(check_username_password(Username.getText(),Password.getText()))
        {
            openFlyHigh();
        }
        else
        {
            AlertBox.error("Username or Password is incorrect");
        }

    }
    public void openFlyHigh()throws Exception{

        Stage admin=new Stage();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("FlyHigh.fxml"));
        AnchorPane pane=loader.load();

        Scene scene=new Scene(pane);

        admin.setTitle("FlyHigh");
        admin.setScene(scene);
        admin.show();

    }

    private boolean check_username_password(String username,String password) throws Exception
    {
        Connection con=ConnectionDB.getConnection();
        Statement st=con.createStatement();
        String q="select * from login where email = '" + username +"';";
        ResultSet rs=st.executeQuery(q);

        while (rs.next()) {
            if(password.compareTo(rs.getString("password"))==0) {
                return true;
            }
        }
        return false;
    }

    public void closeAll(){
        System.exit(0);
    }

    public void resetPassword() throws Exception {
        Stage Reset=new Stage();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("resetPassword.fxml"));
        AnchorPane pane=loader.load();

        Scene scene=new Scene(pane);

        Reset.setTitle(" Reset Password");
        Reset.setScene(scene);
        Reset.show();
    }
}
