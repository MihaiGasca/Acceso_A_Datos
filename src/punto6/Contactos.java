package punto6;

import java.io.*;

public class Contactos {

    // Fichero de acceso aleatorio
    private RandomAccessFile file;

    // Apertura del fichero
    public void abrir() throws IOException {
        file = new RandomAccessFile("clientes.dat", "rw");
    }

    // Cierre del fichero
    public void cerrar() throws IOException {
        if (file != null) {
            file.close();
        }
    }

    // Escribir un registro en la posición actual del cursor
    public void escribir(Registro registro) throws IOException {
        if (file != null) {
            registro.write(file);
        }
    }

    // Escribir un registro en una posición específica
    public void escribir(Registro registro, int pos) throws IOException {
        if (file != null) {
            file.seek((pos - 1) * Registro.DIM);
            escribir(registro);
        }
    }

    // Leer el registro que está en la posición actual del cursor
    public Registro leer() {
        Registro registro = null;
        if (file != null) {
            try {
                registro = new Registro();
                registro.read(file);
            } catch (Exception e) {
                registro = null;
            }
        }
        return registro;
    }

    // Leer un registro de una posición específica
    public Registro leer(int pos) throws IOException {
        if (file != null) {
            file.seek((pos - 1) * Registro.DIM);
        }
        return leer();
    }
}
