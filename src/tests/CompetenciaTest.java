package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import clases.Competencia;
import clases.EntradaSalida;

class CompetenciaTest {

	@Test
	void ejemploDeLaConsignaTest(){
		compararArchivos("./archivos/ejemploDeLaConsigna.in", "./archivos/ejemploDeLaConsigna_esperado.out", "./archivos/ejemploDeLaConsigna_obtenida.out");	
	}
	
	@Test
	void pruebaMasDeTresPosiblesGanadoresTest(){
		compararArchivos("./archivos/masDeTresPosiblesGanadores.in", 
				"./archivos/masDeTresPosiblesGanadores_esperado.out", "./archivos/masDeTresPosiblesGanadores_obtenida.out");	
	}
	
	@Test
	void pruebaSinGanadoresConsistenciaTest(){
		compararArchivos("./archivos/sinGanadoresConsistencia.in", 
				"./archivos/sinGanadoresConsistencia_esperado.out", "./archivos/sinGanadoresConsistencia_obtenida.out");	
	}
	
	@Test
	void pruebaSinGanadoresDistanciaTest(){
		compararArchivos("./archivos/sinGanadoresDistancia.in", 
				"./archivos/sinGanadoresDistancia_esperado.out", "./archivos/sinGanadoresDistancia_obtenida.out");	
	}
	
	@Test
	void pruebaExplosionTest(){
		compararArchivos("./archivos/explosion.in", 
				"./archivos/explosion_esperado.out", "./archivos/explosion_obtenida.out");	
	}
	
	private void compararArchivos(String archivoEntrada,String archivoSalidaEsperada,String archivoSalidaObtenida) {
	    EntradaSalida es = new EntradaSalida();
		Competencia competencia = es.leerDeArchivo(archivoEntrada);
	    competencia.obtenerGanadores();
	    es.escribirEnArchivo(archivoSalidaObtenida, competencia);
	    Scanner scannerEsperado = null;
	    Scanner scannerObtenido = null;
	    try {
	        scannerEsperado = new Scanner (new FileReader(archivoSalidaEsperada));
	        scannerObtenido = new Scanner (new FileReader(archivoSalidaObtenida));
	        while(scannerEsperado.hasNext() || scannerObtenido.hasNext()) {
	            assertEquals(scannerEsperado.nextInt(), scannerObtenido.nextInt());              
	        }
	    } catch (IOException e) {
	        System.err.println(e.getMessage());
	    }
	    finally {
	    	if(scannerEsperado!=null) {
	    		scannerEsperado.close();
	    	}
	    	if(scannerObtenido!=null) {
	    		scannerObtenido.close();
	    	}
	    }
	}

}

