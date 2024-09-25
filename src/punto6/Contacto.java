package punto6;

import java.util.Date;

public class Contacto {
	private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private Date nacimiento;
    private int grupo;
    private double deuda;

    // Constantes simbólicas
    public static final int TRABAJO = 1;
    public static final int FAMILIA = 2;
    public static final int AMIGOS = 3;

    // Constructor
    public Contacto(String nombre) {
        this.nombre = nombre;
    }
    
    public Contacto() {
      
    }

    // Métodos set & get (puedes implementarlos aquí)
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String teléfono) {
		this.telefono = teléfono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

	public double getDeuda() {
		return deuda;
	}

	public void setDeuda(double deuda) {
		this.deuda = deuda;
	}
    
    
    // Salida estándar
    public String toString() {
        return nombre + " (" + email + ")\n" +
               "Teléfono: " + telefono + "\n" +
               "Cumpleaños: " + nacimiento + "\n" +
               "Deuda: " + deuda + "€";
    }

}
