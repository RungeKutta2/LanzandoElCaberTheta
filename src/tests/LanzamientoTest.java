package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clases.Lanzamiento;

class LanzamientoTest {

	@Test
	void pruebaLanzamientoCienPorcientotest() {
		Lanzamiento lanzamiento = new Lanzamiento(2, 21);
		assertEquals(2, lanzamiento.getDistancia());
		assertTrue(lanzamiento.esValido());
	}

	@Test
	void pruebaLanzamientoOchentaPorcientotest() {
		Lanzamiento lanzamiento = new Lanzamiento(2.8 , 66.2);
		assertEquals(2.8*0.8, lanzamiento.getDistancia());
		assertTrue(lanzamiento.esValido());
	}
	
	@Test
	void pruebaLanzamientoInvalidotest() {
		Lanzamiento lanzamiento = new Lanzamiento(2.8 , -122);
		assertFalse(lanzamiento.esValido());
	}
}
