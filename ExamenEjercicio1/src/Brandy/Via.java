package Brandy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Via {

    private String nombre;

    private String dificultad;
    private ObservableList<String> listaDificultad = FXCollections.observableArrayList();

    public Via(){

    }

    public Via(String nombre, String dificultad) {
        this.nombre = nombre;
        this.dificultad = dificultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public ObservableList<String> getListaDificultad() {
        listaDificultad.add("6a");
        listaDificultad.add("6b");
        listaDificultad.add("6c");
        listaDificultad.add("7a");
        listaDificultad.add("7b");
        listaDificultad.add("7c");
        return listaDificultad;
    }

    public void setListaDificultad(ObservableList<String> listaDificultad) {
        this.listaDificultad = listaDificultad;
    }

    @Override
    public String toString() {
        return "Via{" +
                "nombre='" + nombre + '\'' +
                ", dificultad='" + dificultad + '\'' +
                '}';
    }
}
