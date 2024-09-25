package punto1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prueba = new Properties();
		prueba.setProperty("Fruta1", "Manzana");
		prueba.setProperty("Fruta2", "Platano");
		
		try {OutputStream salida = new FileOutputStream("ejercicio1.txt");
		prueba.store(salida, "Frutas");
		System.out.println("Correcto");
			
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("Error");
		}
	}
}


