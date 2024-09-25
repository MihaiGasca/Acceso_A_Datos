package punto4;

import java.io.Serializable;

public class Coche implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marca;
    private String modelo;
    private int anio;

    public Coche(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Coche [Marca=" + marca + ", Modelo=" + modelo + ", Año=" + anio + "]";
    }
}