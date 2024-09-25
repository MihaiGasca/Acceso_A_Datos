package punto1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class Libros {

	public static void main(String[] args) {
		List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("Cien anos de soledad", "Gabriel Garcia Marquez"));
        libros.add(new Libro("1984", "George Orwell"));

    
        Properties prueba = new Properties();

        for (int i = 0; i < libros.size(); i++) {
            prueba.setProperty("Libro" + (i + 1), libros.get(i).toString());
        }

        try (FileOutputStream salida = new FileOutputStream("libros.txt")) {
            prueba.store(salida, "Lista de Libros");
            System.out.println("Libros guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los libros: ");
        }

      
       
	}
}
