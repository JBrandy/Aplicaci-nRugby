package Brandy;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
        import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AnadirControlador implements Initializable {

    private Stage stage;
    private Via via = new Via();

    @FXML
    private TextField tfNombre;

    @FXML
    private Button btanadir;

    @FXML
    private ComboBox<String> cbDificultad;

    @FXML
    void anadir(ActionEvent event) {
    Logica.getInstance().getListaReservas().add(new Via(tfNombre.getText(), cbDificultad.getSelectionModel().getSelectedItem()));

    stage.close();

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    cbDificultad.setItems(via.getListaDificultad());



    }
}