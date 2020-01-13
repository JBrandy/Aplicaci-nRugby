package Brandy;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logica {


    private static Logica INSTANCE = null;





    private ObservableList<Via> listaReservas;



    private Logica() {
        listaReservas = FXCollections.observableArrayList();
    }


    public static Logica getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logica();
        }
        return INSTANCE;
    }


    public ObservableList<Via> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ObservableList<Via> listaReservas) {
        this.listaReservas = listaReservas;
    }


    public void finalizar() {
        INSTANCE = null;
    }



}
