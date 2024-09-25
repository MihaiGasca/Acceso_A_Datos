package punto1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Ejercicio1_2 {
	 public static void main(String[] args) {
	        String nombreArchivo = "ejercicio1toXml.xml";
	        
	      
	        guardarPropiedades(nombreArchivo);
	        
	      
	        cargarPropiedades(nombreArchivo);
	    }
   
    public static void guardarPropiedades(String nombreArchivo) {
        Properties prueba = new Properties();
        prueba.setProperty("Fruta1", "Manzana");
        prueba.setProperty("Fruta2", "Plátano");

        try {
            OutputStream salida = new FileOutputStream(nombreArchivo);
            prueba.store(salida, "Frutas");
            salida.close();
            System.out.println("Propiedades guardadas correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar las propiedades en el archivo XML.");
        }
    }

   
    public static void cargarPropiedades(String nombreArchivo) {
        Properties prueba = new Properties();

        try {
            FileInputStream entrada = new FileInputStream(nombreArchivo);
            prueba.loadFromXML(entrada);
            entrada.close();

           
            System.out.println("Propiedades cargadas desde " + nombreArchivo);
            System.out.println("Fruta1: " + prueba.getProperty("Fruta1"));
            System.out.println("Fruta2: " + prueba.getProperty("Fruta2"));
        } catch (IOException e) {
            System.out.println("Error al cargar las propiedades del archivo XML.");
        }
    }

   
}

