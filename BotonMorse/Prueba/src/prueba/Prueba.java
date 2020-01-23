package prueba;

import brandy.Boton;
import brandy.Evento;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




public class Prueba extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        Boton componente = new Boton();



          componente.addEvento(new Evento() {
              @Override
              public void ejecuta(char letra) {
                  Label etiqueta = new Label("hey");
                  System.out.println(letra);
                  vBox.getChildren().add(etiqueta);
              }

        });



        vBox.getChildren().addAll(componente);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args){
        launch(args);
    }
}