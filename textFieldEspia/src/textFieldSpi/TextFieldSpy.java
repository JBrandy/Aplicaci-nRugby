package textFieldSpi;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.*;

public class TextFieldSpy extends TextField {

    private StringProperty palabra = new SimpleStringProperty();
    private String ficheroLog ;
    private List <String> lista = new ArrayList<>();
    private SimpleTimeZone fecha;

    public TextFieldSpy() {
        textProperty().addListener((observable, oldValue, newValue) -> {
            for (String nombre : lista) {
                if(nombre.equalsIgnoreCase(palabra.get())){
                    writeFich(nombre);
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
        PrintWriter fw = null;
        try {
            fw = new PrintWriter(ficheroLog));
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(nombre);
            bw.newLine();
            bw.write(fecha.toString());
        } catch (IOException e) {
            e.printStackTrace();
            fw.close();
        }
    }
}
