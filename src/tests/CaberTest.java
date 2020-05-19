package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import clases.Competencia;
import clases.EntradaSalida;

class CaberTest {

	@Test
	//caso de ejemplo del Ejercicio
	void prueba1Test(){
		EntradaSalida es = new EntradaSalida();
		Competencia competencia = es.leerDeArchivo("archivo.in");
		String salida1 = new String("1 2 ");
		String salida2 = new String("2 1 3 ");
		competencia.obtenerGanadores();
		assertEquals(competencia.getGanadoresConsistencia().toString(), salida1);
		assertEquals(competencia.getGanadoresDistancia().toString(), salida2);	
	}
	
	@Test
	//Mas de 3 ganadores x podio 
	void prueba2Test(){
		EntradaSalida es = new EntradaSalida();
		Competencia competencia = es.leerDeArchivo("archivo2.in");
		String salida1 = new String("1 4 2 ");
		String salida2 = new String("2 1 4 ");
		competencia.obtenerGanadores();

		assertEquals(competencia.getGanadoresConsistencia().toString(), salida1);
		assertEquals(competencia.getGanadoresDistancia().toString(), salida2);	
	}
	
	

}
