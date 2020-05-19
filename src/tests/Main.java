package tests;

import clases.Competencia;
import clases.EntradaSalida;

public class Main {
	public static void main(String[] args) {
		EntradaSalida es = new EntradaSalida();
		Competencia competencia = es.leerDeArchivo("archivo.in");
	
		competencia.obtenerGanadores();
		
		es.escribirEnArchivo("archivo.out", competencia);
		System.out.println("corrió");
	}
}
