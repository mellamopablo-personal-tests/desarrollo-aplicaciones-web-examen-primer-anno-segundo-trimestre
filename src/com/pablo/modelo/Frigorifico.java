package com.pablo.modelo;

import java.util.ArrayList;

public class Frigorifico extends Electrodomestico {

	private double capacidadTotal;
	private double capacidadCongelador;
	private ArrayList<String> listaCaracteristicas = new ArrayList<String>();

	public double getCapacidadTotal() {
		return capacidadTotal;
	}

	public Frigorifico setCapacidadTotal(double capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
		return this;
	}

	public double getCapacidadCongelador() {
		return capacidadCongelador;
	}

	public Frigorifico setCapacidadCongelador(double capacidadCongelador) {
		this.capacidadCongelador = capacidadCongelador;
		return this;
	}

	public String[] getCaracteristicas() {
		return listaCaracteristicas.toArray(new String[listaCaracteristicas.size()]);
	}

	public Frigorifico annadirCaracteristica(String caracteristica) {
		this.listaCaracteristicas.add(caracteristica);
		return this;
	}

	public Frigorifico borrarCaracteristica(String caracteristica) {
		this.listaCaracteristicas.remove(caracteristica);
		return this;
	}

	public Frigorifico borrarCaracteristica(int posicion) {
		this.listaCaracteristicas.remove(posicion);
		return this;
	}

	public Frigorifico borrarTodasLasCaracteristicas() {
		this.listaCaracteristicas = new ArrayList<String>();
		return this;
	}

	public Frigorifico() {
		super();
	}

	public Frigorifico(
			String marca,
			String modelo,
			double precioBase,
			char consumoEnergetico,
			double altura,
			double anchura,
			double peso,
			double capacidadTotal,
			double capacidadCongelador,
			ArrayList<String> listaCaracteristicas
	) throws MalFormatoException {

		super(marca, modelo, precioBase, consumoEnergetico, altura, anchura, peso);

		this
			.setCapacidadTotal(capacidadTotal)
			.setCapacidadCongelador(capacidadCongelador);

		this.listaCaracteristicas = listaCaracteristicas;
	}

	@Override
	public String toString() {
		return "Frigorifico{" +
				"capacidadTotal=" + capacidadTotal +
				", capacidadCongelador=" + capacidadCongelador +
				", listaCaracteristicas=" + listaCaracteristicas +
				"} " + super.toString();
	}

	/**
	 * Calcula la suma de los precios totales de todos los frigoríficos dados.
	 *
	 * @param frigorificos Un conjunto de frigoríficos
	 * @return La suma de los precios totales
	 */
	public static double ingresoTotalFrigorificos(Frigorifico... frigorificos) {
		return Electrodomestico.ingresoTotal(frigorificos);
	}
}
