package Brandy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainControlador implements Initializable {

    @FXML
    private Button btAnadir;

    @FXML
    private TableView<Via> table;

    @FXML
    private ComboBox<?> cbDifilcutad;

    @FXML
    private ComboBox<?> cbDifilcutad2;

    @FXML
    private Button btFiltrar;

    @FXML
    void anadir(ActionEvent event) {


        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("anadir.fxml"));
            Parent root = fxmlLoader.load();
            AnadirControlador pantallaConfigCorreo = (AnadirControlador) fxmlLoader.getController();
            pantallaConfigCorreo.setStage(stage);
            stage.setTitle("Correo");
            stage.setScene(new Scene(root, 600, 400));

        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.showAndWait();

    }

    @FXML
    void filtrar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Logica.getInstance().getListaReservas()!=null){
            table.setItems(Logica.getInstance().getListaReservas());

        }

    }
}