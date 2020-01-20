package textFieldSpi;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

import java.io.*;

import java.util.*;

public class TextFieldSpy extends TextField {

    private String ficheroLog ;
    private List <String> lista = new ArrayList<>();
    private Date fecha;
    private Evento evento;

    public TextFieldSpy() {

        textProperty().addListener((observable, oldValue, newValue) -> {
            for (String nombre : lista) {
                if(getText().contains(nombre)){
                    //if(nombre.equalsIgnoreCase(getText()))
                    writeFich(nombre);
                    if(evento!=null){
                        evento.ejecuta();
                    }
                }
            }

        });

    }
    public TextFieldSpy(String s) {
        super(s);

    }

    public String getFicheroLog() {
        return ficheroLog;
    }

    public void setFicheroLog(String ficheroLog) {
        this.ficheroLog = ficheroLog;
    }

    public void anadirPalabra(String texto){
        lista.add(texto);
    }

    private void writeFich(String nombre) {
        FileWriter fw;
        PrintWriter pw = null;
        fecha = new Date();
        try {
            fw = new FileWriter(ficheroLog, true);
            pw = new PrintWriter(fw);
            pw.println(nombre + fecha.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        pw.close();
    }
    public void addEvento (Evento evento){
        this.evento = evento;
    }
}
