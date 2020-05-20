package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.DistanciaComparator;
import clases.Lanzamiento;
import clases.Participante;
import clases.Podio;

class PodioTest {

	Podio p;
	static Participante participante;
	static Participante participante2;
	static Participante participante3;
	static Participante participante4;
	static Participante participante5;

	@BeforeAll
	static void generalSetup() {
		participante = new Participante(1);
		participante.agregarLanzamiento(new Lanzamiento(1, 0));
		participante.agregarLanzamiento(new Lanzamiento(1, 0));
		participante.agregarLanzamiento(new Lanzamiento(1, 0));
		participante.calcularDistanciaTotal();

		participante2 = new Participante(2);
		participante2.agregarLanzamiento(new Lanzamiento(2, 0));
		participante2.agregarLanzamiento(new Lanzamiento(2, 0));
		participante2.agregarLanzamiento(new Lanzamiento(2, 0));
		participante2.calcularDistanciaTotal();

		participante3 = new Participante(3);
		participante3.agregarLanzamiento(new Lanzamiento(3, 0));
		participante3.agregarLanzamiento(new Lanzamiento(3, 0));
		participante3.agregarLanzamiento(new Lanzamiento(3, 0));
		participante3.calcularDistanciaTotal();

		participante4 = new Participante(4);
		participante4.agregarLanzamiento(new Lanzamiento(4, 0));
		participante4.agregarLanzamiento(new Lanzamiento(4, 0));
		participante4.agregarLanzamiento(new Lanzamiento(4, 0));
		participante4.calcularDistanciaTotal();

		participante5 = new Participante(5);
		participante5.agregarLanzamiento(new Lanzamiento(5, 0));
		participante5.agregarLanzamiento(new Lanzamiento(5, 0));
		participante5.agregarLanzamiento(new Lanzamiento(5, 0));
		participante5.calcularDistanciaTotal();
	}

	@BeforeEach
	void individualSetup() {
		p = new Podio(new DistanciaComparator());
	}

	@Test
	void agregaParticipanteAListaVaciaTest() {
		p.add(participante);
		assertEquals(1, p.size());
	}

	@Test
	void agregaTresParticipantesAListaVaciaTest() {
		p.add(participante);
		p.add(participante2);
		p.add(participante3);
		assertEquals(3, p.size());
	}

	@Test
	void noAgregaMasDeTresParticipantesALaLista() {

		p.add(participante);
		p.add(participante2);
		p.add(participante3);
		p.add(participante4);
		p.add(participante5);
		assertEquals(3, p.size());
	}

	@Test
	void pruebaFormatoCorrectoConDosParticipantes() {
		p.add(participante);
		p.add(participante2);
		p.add(participante3);
		assertEquals("3 2 1 ", p.toString());
	}

	@Test
	void pruebaFormatoCorrectoConTresParticipantes() {
		p.add(participante);
		p.add(participante2);
		assertEquals("2 1 ", p.toString());
	}

}
