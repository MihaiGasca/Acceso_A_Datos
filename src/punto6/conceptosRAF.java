package punto6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class conceptosRAF {

	public static void main(String[] args) {
		
		ArrayList<Integer> numeros = new ArrayList<>(20);
		
		String nombreFichero = "datos.bin";
		
		File fichero = new File (nombreFichero);
		
		if(fichero.exists()) {			//Si encontramos el fichero
			System.out.println("El archivo " + nombreFichero + " existe. Leyendo datos...");
			
			try(DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
				while(numeros.size() < 20 && dis.available() > 0) {
					int numero = dis.readInt();
					numeros.add(numero);
				}
				System.out.println("Datos leidos.");
			}catch (IOException e) { 
				e.printStackTrace();
				System.out.println("Error al leer el archivo.");
			}
		}else {
			System.out.println("El archivo " + nombreFichero + " no existe. Creando archivo con 20 ceros");
			
			try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))){
				for(int i=0; i<20 ;i++) {
					dos.writeInt(0);
					numeros.add(0);
				}
				System.out.println("Archivo creado e iniciado");
			}catch (IOException e) {
				e.printStackTrace();
				System.out.println("Error al crear el archivo");
			}
		}
		
		//Abrimos el fichero en modo aleatorio
		try (RandomAccessFile raf = new RandomAccessFile (fichero, "rwd")){
			System.out.println("Abriendo archivo en modo acceso aleatorio");
			Scanner sc = new Scanner(System.in);
			
			int pos = 0;
			
			do {
				mostrarEstructura(numeros);
				
				try {
					System.out.println("Ingresar una posicion (de 0 a 19) o numero negativo para salir: ");
					pos = sc.nextInt();
					
					if (pos>=0 && pos < 20 ) {
						System.out.println("Ingresa el nuevo valor para la posicion seleccionada: ");
						int nuevoValor = sc.nextInt();
						
						numeros.set(pos, nuevoValor);
						
						raf.seek(pos * 4);
						raf.writeInt(nuevoValor);
						
						System.out.println("Valor actualizado en la posicion " + pos);
					}
				}catch (InputMismatchException e) {
					System.out.println("Error: ingrese un numero valido.");
					sc.next();
					pos=0;			//Lo dejamos al valor que estaba antes
				}
			}while(pos>=0);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void mostrarEstructura(ArrayList<Integer> numeros) {
        System.out.println("Contenido de la estructura:");
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println("Posición " + i + ": " + numeros.get(i));
        }
    }

}
