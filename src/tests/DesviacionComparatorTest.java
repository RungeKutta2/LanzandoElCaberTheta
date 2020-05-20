package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.DesviacionComparator;
import clases.Lanzamiento;
import clases.Participante;

class DesviacionComparatorTest {

	@Test
	void pruebaParticipanteUnoMayorADostest() {
		Participante participante1 = new Participante(1);
		Participante participante2 = new Participante(2);
		DesviacionComparator comparador = new DesviacionComparator();
		
		participante1.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante1.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante1.agregarLanzamiento(new Lanzamiento(1.51,-3));
		
		participante2.agregarLanzamiento(new Lanzamiento(2.10,6));
		participante2.agregarLanzamiento(new Lanzamiento(2.00,-6));
		participante2.agregarLanzamiento(new Lanzamiento(1.00,2));
		
		participante1.calcularDesviacionTotal();
		participante2.calcularDesviacionTotal();
		
		assertTrue(comparador.compare(participante1, participante2)>0);
	}

	@Test
	void pruebaParticipanteDosMayorAUnotest() {
		Participante participante1 = new Participante(1);
		Participante participante2 = new Participante(2);
		DesviacionComparator comparador = new DesviacionComparator();
		
		participante1.agregarLanzamiento(new Lanzamiento(2.10,6));
		participante1.agregarLanzamiento(new Lanzamiento(2.00,-6));
		participante1.agregarLanzamiento(new Lanzamiento(1.00,2));
		
		participante2.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante2.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante2.agregarLanzamiento(new Lanzamiento(1.51,-3));
		
		participante1.calcularDesviacionTotal();
		participante2.calcularDesviacionTotal();
		
		assertTrue(comparador.compare(participante1, participante2)<0);
	}
	
	@Test
	void pruebaParticipanteUnoIgualADostest() {
		Participante participante1 = new Participante(1);
		Participante participante2 = new Participante(2);
		DesviacionComparator comparador = new DesviacionComparator();
		
		participante1.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante1.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante1.agregarLanzamiento(new Lanzamiento(1.51,-3));
		
		participante2.agregarLanzamiento(new Lanzamiento(1.49,5));
		participante2.agregarLanzamiento(new Lanzamiento(1.50,3));
		participante2.agregarLanzamiento(new Lanzamiento(1.51,-3));
		
		participante1.calcularDesviacionTotal();
		participante2.calcularDesviacionTotal();
		
		assertTrue(comparador.compare(participante1, participante2) == 0);
	}
	
}
