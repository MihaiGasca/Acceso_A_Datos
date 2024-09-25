package punto5;

import java.io.*;
import java.util.ArrayList;

public class Punto5 {

    public static void main(String[] args) {
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Toyota", "Corolla", 2020));
        coches.add(new Coche("Ford", "Focus", 2018));
        coches.add(new Coche("Renault", "Clío", 2019));

        guardar(coches);
        ArrayList<Coche> cochesCargados = cargar();
        for (Coche coche : cochesCargados) {
            System.out.println(coche);
        }
    }

    public static void guardar(ArrayList<Coche> coches) {
        ObjectOutputStream salida = null;

        try {
            salida = new ObjectOutputStream(new FileOutputStream("ejercicio5_2.txt"));
            for (Coche coche : coches) {
                salida.writeObject(coche);
            }
        } catch (IOException x) {
            System.err.print("Error");
        } finally {
            if (salida != null) {
                try {
                    salida.close();
                } catch (IOException e) {
                    System.out.println("IOExceptional cerrar: " + e.getMessage());
                }
            }
        }
    }

    public static ArrayList<Coche> cargar() {
        ArrayList<Coche> coches = new ArrayList<>();
        ObjectInputStream entrada = null;

        try {
            entrada = new ObjectInputStream(new FileInputStream("ejercicio5_2.txt"));
            while (true) {
                try {
                    Coche coche = (Coche) entrada.readObject();
                    coches.add(coche);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.print("Error al cargar: " + e.getMessage());
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    System.out.println("IOException al cerrar: " + e.getMessage());
                }
            }
        }
        return coches;
    }
}
