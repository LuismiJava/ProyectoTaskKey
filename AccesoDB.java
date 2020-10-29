/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatask2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FP Mañana A
 */
public class AccesoDB {

  private static  String ruta="C:\\Users\\FP Mañana A\\Desktop\\rutas_eclipse\\contactos.csv";
  private static  String separador=",";
  
 static ArrayList<Contacto> recuperarContactos(String nombre_buscado) {
    ArrayList<Contacto> lista_contactos=new ArrayList<Contacto>();
		try {
			FileReader fr=new FileReader(ruta);
			BufferedReader br=new BufferedReader(fr);
			String linea=br.readLine();
			while(linea!=null)
			{
				String[] datos=linea.split(separador);
				String nombre=datos[0];
				String email=datos[1];
				String telefono=datos[2];
				Contacto c=new Contacto (nombre, email, telefono);
                         if(nombre.toUpperCase().contains(nombre_buscado.toUpperCase())){
                         
                             System.out.println("Añadido: "+c);
                             lista_contactos.add(c);
                         }
                                    
				
				linea=br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista_contactos;
	}

  
    
    
    
}
