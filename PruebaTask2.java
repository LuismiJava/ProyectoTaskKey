/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatask2;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class PruebaTask2 extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
       
        HBox h=new HBox(20);
        TextField campo=new TextField();
        Label label=new Label();   
        ProgressBar barra_progreso=new ProgressBar(0);
        
            EventHandler<KeyEvent> oyente_teclas=new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
           
           Tarea tarea=new Tarea(campo.getText());
           barra_progreso.progressProperty().bind(tarea.progressProperty());
          label.textProperty().bind(tarea.messageProperty());
            Thread hilo=new Thread(tarea);

            hilo.setDaemon(false);
            hilo.start();
             
             tarea.setOnSucceeded(new EventHandler() {
                 @Override
                 public void handle(Event t) {
                  ArrayList<Contacto>lista_contactos=(ArrayList<Contacto>)tarea.getValue();
                
                    
                         
                        
                       
               
                     
                     
                
                 }
             });
                
            }
        };
        
       
        
        campo.setOnKeyReleased(oyente_teclas);
        
        
        h.getChildren().addAll(campo,label,barra_progreso);
        Scene escena=new Scene(h,200,200);
        stage.setScene(escena);
        stage.show();
        
    }
 
    
           

    
    
    
    
}
