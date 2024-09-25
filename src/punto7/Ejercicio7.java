package punto7;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio7 {

    
    private static final int TAMANO_REGISTRO = 22;

    public static void main(String[] args) {
        String nombreArchivo = "frutas.txt";
        String[] frutas = { "Manzana", "Platano", "Cereza", "Durazno", "Uva" };
        
       
        guardarFrutas(nombreArchivo, frutas);

       
        System.out.println("\nFrutas antes de modificar:");
        leerFrutas(nombreArchivo, frutas.length);

        
        modificarFruta(nombreArchivo, 3, "Fresa");

        
        System.out.println("\nFrutas después de modificar:");
        leerFrutas(nombreArchivo, frutas.length);
    }
    public static void guardarFrutas(String nombreArchivo, String[] frutas) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            for (String fruta : frutas) {
                
                String frutaConEspacios = String.format("%-20s", fruta);
                archivo.writeBytes(frutaConEspacios + "\n"); 
            }
            System.out.println("Frutas guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar frutas: " + e.getMessage());
        }
    }

   
    public static void leerFrutas(String nombreArchivo, int cantidad) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "r")) {
            for (int i = 0; i < cantidad; i++) {
                archivo.seek(i * TAMANO_REGISTRO); 
                String fruta = archivo.readLine().trim(); 
                System.out.println("Fruta " + (i + 1) + ": " + fruta);
            }
        } catch (IOException e) {
            System.out.println("Error al leer frutas: " + e.getMessage());
        }
    }

    
    public static void modificarFruta(String nombreArchivo, int posicion, String nuevaFruta) {
        try (RandomAccessFile archivo = new RandomAccessFile(nombreArchivo, "rw")) {
            archivo.seek((posicion - 1) * TAMANO_REGISTRO); 
            String frutaConEspacios = String.format("%-20s", nuevaFruta); 
            archivo.writeBytes(frutaConEspacios + "\n"); 
            System.out.println("Fruta en la posición " + posicion + " modificada a: " + nuevaFruta);
        } catch (IOException e) {
            System.out.println("Error al modificar la fruta: " + e.getMessage());
        }
    }

   
}
