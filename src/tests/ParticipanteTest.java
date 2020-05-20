package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Lanzamiento;
import clases.Participante;

class ParticipanteTest {

	@Test
	void pruebaDistanciaTotalUnTiroNoValidotest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante.agregarLanzamiento(new Lanzamiento(1.51,-92));
		
		participante.calcularDistanciaTotal();
		
		assertEquals(2.99, participante.getDistanciaTotal());
	}
	
	@Test
	void pruebaDistanciaTotalTirosValidostest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante.agregarLanzamiento(new Lanzamiento(1.51,2));
		
		participante.calcularDistanciaTotal();
		
		assertEquals(4.50, participante.getDistanciaTotal());
	}
	
	@Test
	void pruebaDistanciaTotalTiroAlOchentatest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1,35));
		participante.agregarLanzamiento(new Lanzamiento(1,22));
		participante.agregarLanzamiento(new Lanzamiento(1,22));
		
		participante.calcularDistanciaTotal();
		
		assertEquals(2.8, participante.getDistanciaTotal());
	}
	
	@Test
	void pruebaDistanciaTotalDosTirosNoValidostest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1.49,92));
		participante.agregarLanzamiento(new Lanzamiento(1.50,-95));
		participante.agregarLanzamiento(new Lanzamiento(1.51,0));
		
		participante.calcularDistanciaTotal();
		
		assertFalse(participante.getEsValido());
	}
	
	@Test
	void pruebaDistanciaTotalNingunTiroValidotest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1.49,92));
		participante.agregarLanzamiento(new Lanzamiento(1.50,-95));
		participante.agregarLanzamiento(new Lanzamiento(1.51,-92));
		
		participante.calcularDistanciaTotal();
		
		assertFalse(participante.getEsValido());
		assertEquals(0,participante.getDistanciaTotal());
	}
	
	@Test
	void pruebaDesviacionTotaltest() {
		Participante participante = new Participante(1);
		
		participante.agregarLanzamiento(new Lanzamiento(1.49,92));
		participante.agregarLanzamiento(new Lanzamiento(1.50,-95));
		participante.agregarLanzamiento(new Lanzamiento(1.51,-92));
		
		participante.calcularDesviacionTotal();
		
		assertEquals(0.57,participante.getDesviacionTotal(),0.1);
	}

}
