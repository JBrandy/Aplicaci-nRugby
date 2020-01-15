package brandyTemp;


import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador extends Label {

    private IntegerProperty second = new SimpleIntegerProperty(0);
    private ObjectProperty<Color> colorEncendido = new SimpleObjectProperty<>(Color.GREEN);
    private ObjectProperty<Color> colorFin = new SimpleObjectProperty<>(Color.RED);
    private StringProperty texto = new SimpleStringProperty("Fin");
    private FinCuentaAtras finCuentaAtras;

    public Temporizador(){

    }

    public Temporizador(IntegerProperty second) {
        this.second = second;
    }

    public Temporizador(String s, IntegerProperty second) {
        super(s);
        this.second = second;
    }

    public Temporizador(String s, Node node, IntegerProperty second) {
        super(s, node);
        this.second = second;
    }

    public int getSecond() {
        return second.get();
    }

    public IntegerProperty secondProperty() {
        return second;
    }

    public void setSecond(int second) {
        this.second.set(second);
        setText(Integer.toString(second));
    }

    public Color getColorEncendido() {
        return colorEncendido.get();
    }

    public ObjectProperty<Color> colorEncendidoProperty() {
        return colorEncendido;
    }

    public void setColorEncendido(Color colorEncendido) {
        this.colorEncendido.set(colorEncendido);
    }

    public Color getColorFin() {
        return colorFin.get();
    }

    public ObjectProperty<Color> colorFinProperty() {
        return colorFin;
    }

    public void setColorFin(Color colorFin) {
        this.colorFin.set(colorFin);
    }

    public String getTexto() {
        return texto.get();
    }

    public StringProperty textoProperty() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto.set(texto);
    }

    // es el set ero le cambiamos por add///
    public void addFinCuentaAtras(FinCuentaAtras finCuentaAtras) {
        this.finCuentaAtras = finCuentaAtras;
    }


   private String colorToString(Color color){
        return color.toString().substring(2);
    }

    public void startSec (){
        Timer timer = new Timer();

        setStyle("-fx-background-color:#"+String.format("%02x%02x%02x",(int)(colorEncendido.get().getRed()*255), (int)(colorEncendido.get().getGreen()*255),(int) (colorEncendido.get().getBlue()*255)));
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(second.get()>0){

                    second.set(second.get()-1);// de esta manera  actualizo la interfaz
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(second.get()));
                            if(second.get()==0){
                                setStyle("-fx-background-color:"+colorFin.get().toString().substring(2));
                               // setText(Integer.toString(second.get()));
                                setText(texto.get());
                                if(finCuentaAtras!=null)
                                    finCuentaAtras.ejecuta();


                        }

                        }
                    });
                }


                else{

                    //ara acbar la app sino esto fallaria
                    timer.cancel();
                    timer.purge();
                }

            }
        },1000,1000);
    }

}