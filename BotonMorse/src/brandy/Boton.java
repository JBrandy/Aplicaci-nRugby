package brandy;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Boton extends Button {

    private long inicio;
    private double tiempo;
    private int duracionPulsacionCorta = 200;
    private int duraciónPulsaciónLarga = 2000;
    private Evento evento;
    private char primeraPulsacion = ' ';
    private char segundaPulsacion = ' ';


    public Boton() {
        // Aqui detecto cuando pulso
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                inicio = System.currentTimeMillis();
            }
        });
        //Aqui detecto cuando suelto
        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // Insertar aquí el código a ejecutar cuando se suelte el ratón
                long fin = System.currentTimeMillis();
                tiempo = fin - inicio;
                if (tiempo < duracionPulsacionCorta && primeraPulsacion == ' ') {

                    primeraPulsacion = 'C';
                    System.out.println(primeraPulsacion);
                } else if (tiempo < duracionPulsacionCorta && segundaPulsacion == ' ' && (primeraPulsacion == 'C' || primeraPulsacion == 'L')) {

                    segundaPulsacion = 'C';
                    System.out.println(segundaPulsacion);
                } else if (tiempo > duracionPulsacionCorta && tiempo < duraciónPulsaciónLarga && primeraPulsacion == ' ') {
                    primeraPulsacion = 'L';
                    System.out.println(primeraPulsacion);

                } else if (tiempo > duracionPulsacionCorta && tiempo < duraciónPulsaciónLarga && segundaPulsacion == ' ' && (primeraPulsacion == 'C' || primeraPulsacion == 'L')) {
                    segundaPulsacion = 'L';
                    System.out.println(segundaPulsacion);

                } else if (primeraPulsacion != ' ' && segundaPulsacion != ' ') {
                   // char letra = comprobar();
                    // poner listener(pablo) ara mi accion que resaliza cuando detecta algo  codigo no se ejecuta hasta que el usuar
                    if(evento!=null)
                     evento.ejecuta(comprobar());
                } else {

                }

            }
        });
    }


    private char comprobar() {
        if (primeraPulsacion == 'C' && segundaPulsacion == 'C') {

            return 'i';
        } else if (primeraPulsacion == 'L' && segundaPulsacion == 'L') {

            return 'M';
        } else if (primeraPulsacion == 'C' && segundaPulsacion == 'L') {

            return 'A';
        } else
            primeraPulsacion = ' ';
        segundaPulsacion = ' ';
        return 'N';
    }

    public Boton(String s) {
        super(s);
    }

    public Boton(String s, Node node) {
        super(s, node);
    }


    // metodo de acceso al usuario al interfaz
  public void addEvento (Evento evento){
      this.evento = evento;
  }

}
