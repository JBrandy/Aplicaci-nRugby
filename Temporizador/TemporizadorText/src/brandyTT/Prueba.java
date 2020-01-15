package brandyTT;

import brandyTemp.FinCuentaAtras;
import brandyTemp.Temporizador;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;


public class Prueba extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        Temporizador componente = new Temporizador();
        componente.setFont(new Font(48));
        componente.setSecond(5);
        componente.setColorEncendido(Color.BLACK);
        componente.setColorFin(Color.RED);
        componente.setTexto("adios");
        componente.addFinCuentaAtras(new FinCuentaAtras() {
            @Override
            public void ejecuta() {
                System.out.println("fin cuenta atras");

            }




        });
       // TextField textField = new TextField();
        //Button button = new Button();


        vBox.getChildren().addAll(componente);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        componente.startSec();

    }

    public static void main(String[] args){
        launch(args);
    }
}
