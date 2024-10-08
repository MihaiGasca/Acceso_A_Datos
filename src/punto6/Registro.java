package punto6;

import java.io.*;
import java.text.DateFormat;

public class Registro extends Contacto {
	
	public final static int DIM = 364;
	
	//Lectura
	public void read (RandomAccessFile file) throws IOException, java.text.ParseException {
		
		DateFormat df;
		
		setNombre(readString(file,32));
		setTelefono(readString(file,16));
		setEmail(readString(file,32));
		setDireccion(readString(file,64));
		
		df = DateFormat.getDateInstance(DateFormat.LONG);
		setNacimiento(df.parse(readString(file, 32)));
		
		setGrupo(file.readInt());
		setDeuda(file.readDouble());
	}
	
	private String readString(RandomAccessFile file, int dim) throws IOException{
		char campo[] = new char[dim];
		
		for (int i=0; i<dim; i++) {
			campo[i] = file.readChar();
		}
		return new String(campo).replace('\0', ' ');
	}
	
	//Escritura
	public void write (RandomAccessFile file) throws IOException {
		DateFormat df;
		
		writeString (file, getNombre(), 32);
		writeString (file, getTelefono(), 16);
		writeString (file, getEmail(), 32);
		writeString (file, getDireccion(), 64);
		
		df = DateFormat.getDateInstance(DateFormat.LONG);
		writeString(file, df.format(getNacimiento()),32);
		
		file.writeInt(getGrupo());
		file.writeDouble(getDeuda());
	}
	
	private void writeString(RandomAccessFile file, String str, int dim) throws IOException {
		StringBuffer buffer = new StringBuffer();
		
		if (str != null)
			buffer.append(str);
		
		buffer.setLength(dim);
		file.writeChars(buffer.toString());
	}
}
