package punto3;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GuardarCochesCSV {
    public static void main(String[] args) {
        ArrayList<Coche> coches = new ArrayList<>();
        coches.add(new Coche("Toyota", "Corolla", 2020));
        coches.add(new Coche("Ford", "Focus", 2018));
        coches.add(new Coche("Renault", "Clío", 2019));

        guardarCochesEnCSV(coches, "coches.csv");
    }

    public static void guardarCochesEnCSV(ArrayList<Coche> coches, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
           
            writer.println("Marca,Modelo,Año");

            
            for (Coche coche : coches) {
              
                String modelo = coche.getModelo();
                if (modelo.contains(",")) {
                    modelo = "\"" + modelo + "\"";
                }
                writer.println(coche.getMarca() + "," + modelo + "," + coche.getAnio());
            }

            System.out.println("Coches guardados en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
