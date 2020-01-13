package Brandy;

import brandy.Componente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Prueba extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();

        Componente componente = new Componente();
        TextField textField = new TextField();
        Button button = new Button();
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    componente.setNombre(textField.getText());
                    componente.saludar();
                }
            });

        vBox.getChildren().addAll(textField,button,componente);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
