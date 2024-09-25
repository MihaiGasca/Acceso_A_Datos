package punto1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Elercicio1_2_2 {

 
    public static void guardarPropiedades(String nombreArchivo) {
        Properties propiedades = new Properties();
        propiedades.setProperty("Fruta1", "Manzana");
        propiedades.setProperty("Fruta2", "Plátano");

        try (FileOutputStream salida = new FileOutputStream(nombreArchivo)) {
            propiedades.store(salida, "Lista de Frutas");
            System.out.println("Propiedades guardadas correctamente en " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar las propiedades: " + e.getMessage());
        }
    }

   
    public static Properties cargarPropiedades(String nombreArchivo) {
        Properties propiedades = new Properties();
        
        try (FileInputStream entrada = new FileInputStream(nombreArchivo)) {
            propiedades.load(entrada);
            System.out.println("Propiedades cargadas correctamente desde " + nombreArchivo);
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

    public static void main(String[] args) {
        String nombreArchivo = "Ejercicio1.txt";
        String palabraClave = "Fruta"; 
        
        
        guardarPropiedades(nombreArchivo);
        
       
        Properties propiedadesCargadas = cargarPropiedades(nombreArchivo);
        
       
        mostrarPropiedades(propiedadesCargadas, palabraClave, 2); 
    }
}
