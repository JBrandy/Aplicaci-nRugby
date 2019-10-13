package vistas;

import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import logica.Logica;
import models.Division;
import models.Partido;

public abstract class VistaTabla extends Stage {

	protected TableView tableViewPartidos;
	
	public VistaTabla(){
		visualizar();
	}

	private void visualizar() {
		tableViewPartidos = new TableView((ObservableList) Logica.getInstance().getListapartidos());
		TableColumn<String, Partido> column1 = new TableColumn("Nombre visitante");
		column1.setCellValueFactory(new PropertyValueFactory("equipo_Local"));
		TableColumn<String, Partido> column2 = new TableColumn("vlocal");
		column2.setCellValueFactory(new PropertyValueFactory("equipo_Visitante"));
		TableColumn<Integer, Partido> column3 = new TableColumn("r local");
		column3.setCellValueFactory(new PropertyValueFactory("resultado_Lo"));
		TableColumn<Integer, Partido> column4 = new TableColumn("r visitante");
		column4.setCellValueFactory(new PropertyValueFactory("resultado_Vi"));
		TableColumn<Division, Partido> column5 = new TableColumn("Division");
		column5.setCellValueFactory(new PropertyValueFactory("division"));
		TableColumn<String, Partido> column6 = new TableColumn("fecha");
		column6.setCellValueFactory(new PropertyValueFactory("date"));
		tableViewPartidos.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		tableViewPartidos.getColumns().addAll(new Object[]{column1, column2, column3, column4, column5, column6});
	}
}
