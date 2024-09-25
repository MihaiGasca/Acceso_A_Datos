package punto1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Ejercicio1_3 {
	   public static void main(String[] args) {
	        String nombreArchivo = "Ejercicio1.txt";
	        String palabraClave = "Fruta";
	        
	       
	        Properties propiedadesCargadas = cargarPropiedades(nombreArchivo);
	        
	      
	        mostrarPropiedades(propiedadesCargadas, palabraClave, 2); 
	    }

   
    public static Properties cargarPropiedades(String nombreArchivo) {
        Properties propiedades = new Properties();
        
       
        try (FileInputStream entrada = new FileInputStream(new File(nombreArchivo))) {
            propiedades.load(entrada);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al cargar el archivo de propiedades: " + e.getMessage());
        }
        
        return propiedades; 
    }

    
    public static void mostrarPropiedades(Properties propiedades, String palabraClave, int cantidad) {
        for (int i = 1; i <= cantidad; i++) {
            String clave = palabraClave + i; 
            String valor = propiedades.getProperty(clave);
            
            if (valor != null) {
                System.out.println(clave + ": " + valor);
            } else {
                System.out.println("La clave '" + clave + "' no está presente en el archivo de propiedades.");
            }
        }
    }

 
}

