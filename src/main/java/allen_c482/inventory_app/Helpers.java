
package allen_c482.inventory_app;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

/**
 * Class of various helper functions
 */
public class Helpers {

    /**
     * General Change Scene helper for re-usability
     * @params file, width, height, title,event
     */
    public void changeScene(String file,int width, int height,String title, ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource(file));
        Scene scene = new Scene(fxmlLoader.load(),width,height);

        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    };

    /**
     * Validates if any inputs are empty
     * @params ...inputs
     */
    public boolean isAnyEmpty(String...inputs) {
        for (String input : inputs) {
            if (input.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Shows window alert
     * @params title, message
     */
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
        return;
    }
}
