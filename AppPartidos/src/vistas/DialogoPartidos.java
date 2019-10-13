//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package vistas;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.sun.javafx.scene.control.skin.Utils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.Logica;
import models.Division;
import models.Partido;

public class DialogoPartidos extends Stage {

	private TextField tfLocal;
	private TextField tfvisitante;
	private TextField tfrLocal;
	private TextField tfrVisitante;
	private ComboBox<Division> comboBox;
	private DatePicker datep;
	private Date date;
	private Button baceptar;
	private Button bcancelar;

	
	
	
	public DialogoPartidos() {
		inicializaVista();
	}

	
	
	public DialogoPartidos(int indice, Partido partido) {

		inicializaVista();
		tfLocal.setText(partido.getEquipo_Local());
		tfvisitante.setText(partido.getEquipo_Visitante());
		tfrLocal.setText(String.valueOf(partido.getResultado_Lo()));
		tfrVisitante.setText(String.valueOf(partido.getResultado_Vi()));
		comboBox.getSelectionModel().select(partido.getDivision());

		baceptar.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {

				String equipo_Local = tfLocal.getText();
				String equipo_Visitante = tfvisitante.getText();

				int resultado_Lo = Integer.parseInt(tfrLocal.getText());
				int resultado_Vi = Integer.parseInt(tfrVisitante.getText());
				Division division = (Division) comboBox.getSelectionModel()
						.getSelectedItem();
				String sA = String.valueOf(resultado_Lo);
				String sB = String.valueOf(resultado_Vi);
				String resultado = sA + "-" + sB;
				datep = new DatePicker();
				datep.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						LocalDate localDate = (LocalDate) datep.getValue();
						Date date = Date.from(localDate.atStartOfDay(
								ZoneId.systemDefault()).toInstant());
					}
				});
				Partido p = new Partido(equipo_Local, equipo_Visitante,
						resultado_Lo, resultado_Vi, division, resultado, date);
				Logica.getInstance().modificarPartido(p, indice);

				close();

			}
		});

	}

	public void inicializaVista() {
		VBox vbox = new VBox();
		Label lb_e_local = new Label("inserta el equipo local");
		tfLocal = new TextField();
		Label lb_e_visitante = new Label("inserta el equipo visitante");
		tfvisitante = new TextField();
		Label lb_r_local = new Label(
				"inserta el resultado equipo local y visitante");
		tfrLocal = new TextField();
		HBox hboxresultado = new HBox();
		Label guion = new Label("    -    ");
		tfrVisitante = new TextField();
		hboxresultado.getChildren().add(tfrLocal);
		hboxresultado.getChildren().add(guion);
		hboxresultado.getChildren().add(tfrVisitante);
		new Label("inserta la division");
		ObservableList<Division> listadivision = FXCollections
				.observableArrayList();
		listadivision.add(Division.PRIMERA);
		listadivision.add(Division.SEGUNDA);
		listadivision.add(Division.TERCERA);
		comboBox = new ComboBox(listadivision);
		Label lb_date = new Label("inserta la fecha del partido");
		datep = new DatePicker();
		datep.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				LocalDate localDate = (LocalDate) datep.getValue();
				Date date = Date.from(localDate.atStartOfDay(
						ZoneId.systemDefault()).toInstant());
			}
		});
		HBox hbox = new HBox();
		baceptar = new Button("aceptar");
		bcancelar = new Button("cancelar");
		hbox.getChildren().add(baceptar);
		hbox.getChildren().add(bcancelar);
		hbox.setSpacing(15.0D);
		Label lb = new Label();
		baceptar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				String equipo_Local = tfLocal.getText();
				String equipo_Visitante = tfvisitante.getText();
				int resultado_Lo = Integer.parseInt(tfrLocal.getText());
				int resultado_Vi = Integer.parseInt(tfrVisitante.getText());
				Division division = (Division) comboBox.getSelectionModel()
						.getSelectedItem();
				LocalDate localDate = (LocalDate) datep.getValue();
				Date date = Date.from(localDate.atStartOfDay(
						ZoneId.systemDefault()).toInstant());
				String sA = String.valueOf(resultado_Lo);
				String sB = String.valueOf(resultado_Vi);
				String resultado = sA + "-" + sB;
				Partido p = new Partido(equipo_Local, equipo_Visitante,
						resultado_Lo, resultado_Vi, division, resultado, date);
				Logica.getInstance().addPartida(p);
				DialogoPartidos.this.close();

			}
		});
		bcancelar.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				DialogoPartidos.this.close();
			}
		});
		vbox.getChildren().add(lb_e_local);
		vbox.getChildren().add(tfLocal);
		vbox.getChildren().add(lb_e_visitante);
		vbox.getChildren().add(tfvisitante);
		vbox.getChildren().add(lb_r_local);
		vbox.getChildren().add(hboxresultado);
		vbox.getChildren().add(lb_date);
		vbox.getChildren().add(datep);
		vbox.getChildren().add(comboBox);
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(lb);

		Scene scene = new Scene(vbox, 500.0D, 500.0D);
		this.setScene(scene);
		this.setTitle("Añadir Partido");
		this.show();
	}

	/*
	 * hay que meter dos contrustores hay que meter uno al que pasaremos un
	 * partido para modificar en el constructor
	 */

}