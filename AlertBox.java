package AirlineReservation;
import javafx.scene.control.Alert;

public class AlertBox {

    static void error(String str)
    {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(str);
        alert.show();
    }
}
