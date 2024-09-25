package punto6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class dimensionesBMP {

	public static void main(String[] args) {
		
		String rutaBMP = "logo.bmp";
		File archivoBMP = new File(rutaBMP);
		
		if (!archivoBMP.exists()) {
			System.out.println("Error. Archivo no existente.");
			return;
		}
		
		try (RandomAccessFile raf = new RandomAccessFile (archivoBMP, "rw")) {
			raf.seek(18);
			int ancho = Integer.reverseBytes(raf.readInt());
			
			raf.seek(22);
			int alto = Integer.reverseBytes(raf.readInt());
			
			System.out.println("Valores originales: ");
			System.out.println("Altura: " + alto + " pixeles.");
			System.out.println("Anchura: " + ancho + " pixeles.");
			
			int modAncho = ancho * 2;
			int modAltura = alto * 2;
			
			raf.seek(18);
			raf.writeInt(Integer.reverseBytes(modAncho));
			raf.seek(22);
			raf.writeInt(Integer.reverseBytes(modAltura));
			
			System.out.println("nuevos valores: ");
			System.out.println("Altura: " + modAltura + " pixeles.");
			System.out.println("Anchura: " + modAncho + " pixeles.");
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
