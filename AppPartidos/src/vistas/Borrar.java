package vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logica.Logica;

public class Borrar extends VistaTabla {

	public Borrar() {
		super();

		HBox hbox = new HBox();

		Button bt = new Button("borrar");
		bt.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				tableViewPartidos.getSelectionModel().getSelectedIndices();

				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Esta a punto de borrar un registro");
				alert.setHeaderText("En caso de que borro este registro no se recuperara");
				alert.setContentText("¿Seguro que quiere borrar el registro?");

				alert.showAndWait();
				if ((alert.getResult() == ButtonType.OK)) {

					Logica.getInstance()
							.getListapartidos()
							.remove(tableViewPartidos.getSelectionModel()
									.getSelectedIndex());
				}

				else {
				}

			}

		});

		hbox.getChildren().add(bt);

		Scene scene = new Scene(
				new VBox(new Node[] { tableViewPartidos, hbox }), 600.0D,
				400.0D);
		this.setScene(scene);
		this.show();

	}

}
