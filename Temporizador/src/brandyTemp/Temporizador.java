package brandyTemp;


import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador extends Label {

private int second;
private FinCuentaAtras finCuentaAtras;

    public Temporizador(){

    }

    public Temporizador(int second) {
        this.second = second;
    }

    public Temporizador(String s, int second) {
        super(s);
        this.second = second;
    }

    public Temporizador(String s, Node node, int second) {
        super(s, node);
        this.second = second;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        setText(Integer.toString(this.second));
    }
    // es el set ero le cambiamos por add
    public void addFinCuentaAtras(FinCuentaAtras finCuentaAtras) {
        this.finCuentaAtras = finCuentaAtras;
    }

    public void startSec (){
        Timer timer = new Timer();
        setStyle("-fx-background-color:POWDERBLUE");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(second>0){

                    second--;
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            setText(Integer.toString(second));
                            if(second==0){
                                setStyle("-fx-background-color:RED");
                                if(finCuentaAtras!=null)
                                    finCuentaAtras.ejecuta();

                            }
                            setText(Integer.toString(second));
                        }
                    });
                }


                else{

                    cancel();
                }

            }
        },1000,1000);
    }

}