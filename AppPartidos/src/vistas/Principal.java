//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package vistas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logica.Logica;
import models.Partido;


public class Principal extends Application {
    public Principal() {
    }

    public static void main(String[] args)  {
    	
    	  

        leerFichero();
        launch(args);
        cargarFichero();

    }

	public static void cargarFichero() {
		FileOutputStream fos = null;
    	 ObjectOutputStream oos = null;
    	 try {
			 fos= new FileOutputStream("src\\bbdd.dat", true);
			 oos = new ObjectOutputStream(fos);
			 
			  oos.writeObject(Logica.getInstance().listapartidosTotal());
		       oos.flush();
			 
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		     
            
            try{                    
               if( null != fos ){   
                  fos.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }
	}

	public static void leerFichero() {
		FileInputStream fis = null;
    	 ObjectInputStream ois = null;
    

          try {
           
        	  fis = new FileInputStream("src\\bbdd.dat");
        	  ois = new ObjectInputStream(fis);
        
        	  List<Partido> partidos1 =(List<Partido>) ois.readObject(); //
              Logica.getInstance().listapartidosTotal().addAll(partidos1);
              Logica.getInstance().getListapartidos().addAll(partidos1);
        	 
        	
          }
          catch(Exception e){
             e.printStackTrace();
          }finally{
     
             
             try{                    
                if( null != fis ){   
                   fis.close();     
                }                  
             }catch (Exception e2){ 
                e2.printStackTrace();
             }
          }
	}

    public void start(Stage primaryStage) throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Aplicacion de Rugby");
        Button bt_anadir = new Button("A�adir");

        bt_anadir.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage newStage = new DialogoPartidos();
                newStage.show();
            }
        });
        Button bt_ver = new Button("visualizar lista");
        bt_ver.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage newStage = new Visualizar();
                newStage.show();
            }
        });
        
        Button bt_delate = new Button(" Borrar ");
        bt_delate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Stage newStage = new Borrar();
                newStage.show();
            }
        }); 
        
        ImageView imageView = new ImageView(getClass().getResource("/img.jpg").toExternalForm());
        imageView.setPreserveRatio(true);
       imageView.setFitHeight(100);
        
        Scene scene = new Scene(new VBox(new Node[]{bt_anadir, bt_ver, bt_delate, imageView}), 300.0D, 300.0D);


        stage.setScene(scene);
        stage.show();
    }
}