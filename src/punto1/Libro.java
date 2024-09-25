package punto1;

public class Libro {
	String titulo;
	String autor;
	public Libro(String titulo, String autor) {
		this.autor=autor;		
		this.titulo=titulo;
		// TODO Auto-generated constructor stub
	}
	public String getAutor() {
		return autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  titulo + ";" + autor;
	}
	public static Libro fromString(String str) {
        String[] partes = str.split(";");
        return new Libro(partes[0], partes[1]);
    }

}
