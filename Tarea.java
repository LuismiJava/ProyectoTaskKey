/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatask2;

import java.util.ArrayList;
import javafx.concurrent.Task;

/**
 *
 * @author FP Mañana A
 */
public class Tarea extends Task <ArrayList<Contacto>>{
    
 String nombre_buscado;

    public Tarea(String nombre_buscado) {
        this.nombre_buscado = nombre_buscado;
    }

  
  
    @Override
    
    protected ArrayList<Contacto> call() throws Exception {
    ArrayList<Contacto> lista=AccesoDB.recuperarContactos(nombre_buscado);
 
      for (int i = 0; i <= 100; i++)
       
        {
            
            Thread.sleep(10);
            System.out.println("Actualizado al "+i+" %");
            updateMessage("Actulizado al "+i+" %");
            updateProgress(i, 100);
            
  
        }
    
      updateMessage("Contacto: "+lista);
    
    
    
   return lista;
}
}