package com.pablo.test;

import static org.junit.jupiter.api.Assertions.*;

import com.pablo.modelo.Electrodomestico.MalFormatoException;
import com.pablo.modelo.Frigorifico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestFrigorifico {

	@Test
	void deberiaInstanciarseCorrectamente() throws MalFormatoException {

		ArrayList<String> caracteristicas = new ArrayList<String>();
		caracteristicas.add("Refrigera muy bien");

		Frigorifico frigorifico = new Frigorifico(
				"Super Marca",
				"Model X",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				110,
				40,
				caracteristicas
		);

	}

	@Test
	void deberiaPermitirManipularLaListaDeCaracteristicas() throws MalFormatoException {

		ArrayList<String> caracteristicas = new ArrayList<String>();
		caracteristicas.add("Refrigera muy bien");

		Frigorifico frigorifico = new Frigorifico(
				"Super Marca",
				"Model X",
				499.99,
				'B',
				1.30,
				1.20,
				75,
				110,
				40,
				caracteristicas
		);

		frigorifico.annadirCaracteristica("Economiza la energía");

		assertEquals("Refrigera muy bien", frigorifico.getCaracteristicas()[0]);
		assertEquals("Economiza la energía", frigorifico.getCaracteristicas()[1]);

		frigorifico.borrarCaracteristica("Refrigera muy bien");

		assertEquals("Economiza la energía", frigorifico.getCaracteristicas()[0]);

		frigorifico.borrarTodasLasCaracteristicas();

		assertEquals(0, frigorifico.getCaracteristicas().length);
	}

}
