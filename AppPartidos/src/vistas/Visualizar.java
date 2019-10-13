//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package vistas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.Logica;
import models.Division;
import models.Partido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Visualizar extends VistaTabla {
	static ComboBox<Division> comboBox;

	public Visualizar() {

		super();

		HBox hbox = new HBox();
		ObservableList<Division> listadivision = FXCollections
				.observableArrayList();
		listadivision.add(Division.PRIMERA);
		listadivision.add(Division.SEGUNDA);
		listadivision.add(Division.TERCERA);
		comboBox = new ComboBox(listadivision);
		Button modificar = new Button("modificar");

		
		hbox.getChildren().add(tableViewPartidos);
		Division division = (Division) comboBox.getSelectionModel()
				.getSelectedItem();
		// if(division == )

		Button listar = new Button("Filtrar");
		listar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				filtrar();
			}

		});
		Button vertodo = new Button("todos los registros");
		vertodo.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Logica.getInstance().getListapartidos().clear();
				Logica.getInstance().getListapartidos()
						.addAll(Logica.getInstance().listapartidosTotal());
			}
		});

		Button bt_modificar = new Button(" modificar ");
		bt_modificar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				int selec = tableViewPartidos.getSelectionModel()
						.getSelectedIndex();
				Partido p_se = (Partido) Logica.getInstance()
						.getListapartidos().get(selec);
				Stage dialogo_partido = new DialogoPartidos(selec, p_se);
				dialogo_partido.show();
			}
		});

		VBox vbox = new VBox();
		vbox.getChildren().add(hbox);
		HBox hbox2 = new HBox();
		hbox2.getChildren().add(comboBox);
		hbox2.getChildren().add(listar);
		hbox2.getChildren().add(vertodo);
		hbox2.getChildren().add(bt_modificar);
		vbox.getChildren().add(hbox2);
		hbox2.setSpacing(35.0D);
		Scene scene = new Scene(vbox);
		this.setScene(scene);
		this.show();
	}

	private void filtrar() {
		Division divi = comboBox.getSelectionModel().getSelectedItem();
		List lista2 = new ArrayList<>();
		for (Partido p : Logica.getInstance().getListapartidos()) {
			if (p.getDivision().equals(divi)) {
				lista2.add(p);
			}
		}
		Logica.getInstance().getListapartidos().clear();
		Logica.getInstance().getListapartidos().addAll(lista2);
	}
}