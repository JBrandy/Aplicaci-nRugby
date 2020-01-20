package prueba;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import textFieldSpi.TextFieldSpy;

public class Prueba extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        TextFieldSpy componente = new TextFieldSpy("escriba aqui");
        componente.setFicheroLog("src\\pruueba.txt");
        componente.anadirPalabra("hola");
        componente.anadirPalabra("adios");

        vBox.getChildren().addAll(componente);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args){
        launch(args);
    }
}
