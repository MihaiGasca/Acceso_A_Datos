package punto4;

import java.io.*;
import java.util.ArrayList;

public class Punto4 {

    public static void main(String[] args) {
        
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Toyota", "Corolla", 2020));
        coches.add(new Coche("Ford", "Focus", 2018));
        coches.add(new Coche("Renault", "Clío", 2019));

       
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("coches.bin"))) {
            oos.writeObject(coches);
            System.out.println("Coches guardados correctamente en el fichero binario.");
        } catch (IOException e) {
            System.err.println("Error al guardar los coches: " + e.getMessage());
        }

        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("coches.bin"))) {
            ArrayList<Coche> cochesLeidos = (ArrayList<Coche>) in.readObject();
            System.out.println("Coches leídos del fichero:");
            for (Coche coche : cochesLeidos) {
                System.out.println(coche);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los coches: " + e.getMessage());
        }
    }
}
