package com.pablo.test;

import static org.junit.jupiter.api.Assertions.*;

import com.pablo.modelo.Electrodomestico.MalFormatoException;
import com.pablo.modelo.Lavadora;
import org.junit.jupiter.api.Test;

class TestLavadora {

	@Test
	void deberiaInstanciarseCorrectamente() throws MalFormatoException {
		Lavadora lavadora = new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		);

		assertEquals("Super Marca", lavadora.getMarca());
		assertEquals("Model S", lavadora.getModelo());
		assertEquals(499.99, lavadora.getPrecioBase());
		assertEquals('B', lavadora.getConsumoEnergetico());
		assertEquals(1.30, lavadora.getAltura());
		assertEquals(1.20, lavadora.getAnchura());
		assertEquals(75, lavadora.getPeso());
		assertEquals(Lavadora.TipoCarga.FRONTAL, lavadora.getTipoCarga());
		assertEquals(50, lavadora.getVelocidadCentrifugado());
		assertEquals(true, lavadora.esSecadora());
	}

	@Test
	void deberiaLanzarUnaExcepcionSiLeDasDatosInvalidos() throws MalFormatoException {
		Throwable excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("La marca no puede estar vacía.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("El modelo no puede estar vacío.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				-1.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("El precio no puede ser negativo.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'W',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("El consumo energético debe ser una letra entre la A y la F.",
					 excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				-1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("La altura no puede ser negativa.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				-1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("La anchura no puede ser negativa.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				-75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		));

		assertEquals("El peso no puede ser negativo.", excepcion.getMessage());

		excepcion = assertThrows(MalFormatoException.class, () -> new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				-50,
				true
		));

		assertEquals("La velocidad de centrifugado no puede ser negativa",
					 excepcion.getMessage());

	}

	@Test
	void deberiaCalcularLosPreciosCorrectamente() throws MalFormatoException {

		Lavadora lavadora = new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		);

		double precioBruto = lavadora.calcularPrecioBruto();
		double transporte = lavadora.calcularPrecioTransporte();
		double pvp = lavadora.calcularPvp();

		assertEquals(499.99 + 80, precioBruto);
		assertEquals(80, transporte);
		assertEquals(499.99 + 80 + 80, pvp);

		Lavadora otraLavadora = new Lavadora(
				"Super Marca",
				"Model S",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				Lavadora.TipoCarga.FRONTAL,
				50,
				true
		);

		assertEquals(pvp * 2, Lavadora.ingresoTotalLavadoras(lavadora, otraLavadora));

	}

}
