package brandy;

import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class Componente extends Label {

    private StringProperty nombre;

    public Componente() {
    }

    public Componente(String s) {
        super(s);
    }

    public Componente(String s, Node node) {
        super(s, node);
    }

    public String getNombre() {
        return nombre.get();
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    /**
     * este metodo saludo utilizando el nombre que tiene como ropiedad
     */
    public void saludar (){
        if(getNombre()==null )
            throw new RuntimeException("el nombre esta vacio");// cuando entra al thro sale
        setText("Hello World "+ nombre );
    }
}
