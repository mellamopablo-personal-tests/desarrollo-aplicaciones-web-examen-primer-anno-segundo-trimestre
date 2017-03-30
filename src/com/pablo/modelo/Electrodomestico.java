package com.pablo.modelo;

import java.util.Arrays;

public abstract class Electrodomestico {

	private String marca;
	private String modelo;
	private double precioBase;
	private char consumoEnergetico;
	private double altura;
	private double anchura;
	private double peso;

	public String getMarca() {
		return marca;
	}

	public Electrodomestico setMarca(String marca) throws MalFormatoException {
		if (marca.equals("")) {
			throw new MalFormatoException("La marca no puede estar vacía.");
		}

		this.marca = marca;
		return this;
	}

	public String getModelo() {
		return modelo;
	}

	public Electrodomestico setModelo(String modelo) throws MalFormatoException {
		if (modelo.equals("")) {
			throw new MalFormatoException("El modelo no puede estar vacío.");
		}

		this.modelo = modelo;
		return this;
	}

	public double getPrecioBase() {
		return precioBase;
	}

	public Electrodomestico setPrecioBase(double precioBase) throws MalFormatoException {
		if (precioBase < 0) {
			throw new MalFormatoException("El precio no puede ser negativo.");
		}

		this.precioBase = precioBase;
		return this;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public Electrodomestico setConsumoEnergetico(char consumoEnergetico)
			throws MalFormatoException {
		// Convertir el char a mayúsculas. El + "" convierte el char a string
		consumoEnergetico = (consumoEnergetico + "").toUpperCase().charAt(0);

		if (!"ABCDEF".contains(consumoEnergetico + "")) {
			throw new MalFormatoException("El consumo energético debe ser una letra entre la A y " +
												  "la F.");
		}

		this.consumoEnergetico = consumoEnergetico;
		return this;
	}

	public double getAltura() {
		return altura;
	}

	public Electrodomestico setAltura(double altura) throws MalFormatoException {
		if (altura < 0) {
			throw new MalFormatoException("La altura no puede ser negativa.");
		}

		this.altura = altura;
		return this;
	}

	public double getAnchura() {
		return anchura;
	}

	public Electrodomestico setAnchura(double anchura) throws MalFormatoException {
		if (anchura < 0) {
			throw new MalFormatoException("La anchura no puede ser negativa.");
		}

		this.anchura = anchura;
		return this;
	}

	public double getPeso() {
		return peso;
	}

	public Electrodomestico setPeso(double peso) throws MalFormatoException {
		if (peso < 0) {
			throw new MalFormatoException("El peso no puede ser negativo.");
		}

		this.peso = peso;
		return this;
	}

	public Electrodomestico() {}

	public Electrodomestico(
			String marca,
			String modelo,
			double precioBase,
			char consumoEnergetico,
			double altura,
			double anchura,
			double peso
	) throws MalFormatoException {
		this
			.setMarca(marca)
			.setModelo(modelo)
			.setPrecioBase(precioBase)
			.setConsumoEnergetico(consumoEnergetico)
			.setAltura(altura)
			.setAnchura(anchura)
			.setPeso(peso);
	}

	/**
	 * Caclucla el precio bruto del electrodoméstico, que es la suma del precio base más un plus
	 * añadido que depende del consumo energético.
	 * @return El precio bruto.
	 */
	public double calcularPrecioBruto() {
		double resultado = this.getPrecioBase();

		switch (this.getConsumoEnergetico()) {

			case 'A': return resultado + 100;
			case 'B': return resultado +  80;
			case 'C': return resultado +  60;
			case 'D': return resultado +  50;
			case 'E': return resultado +  30;
			case 'F': return resultado +  10;

			// No debería pasar pero si no se pone java se queja.
			default: return resultado;

		}
	}

	/**
	 * Calcula el precio de transporte del electrodoméstico.
	 * @return El precio de transporte.
	 */
	public double calcularPrecioTransporte() {
		double peso = this.getPeso();

		if (peso < 20) {
			return 10;
		} else if (peso < 50) {
			return 50;
		} else if (peso < 80) {
			return 80;
		} else {
			return 100;
		}
	}

	/**
	 * Caclula el precio final del artículo, que es la suma del precio bruto y el precio
	 * del transporte.
	 * @return El precio final
	 */
	public double calcularPvp() {
		return this.calcularPrecioBruto() + this.calcularPrecioTransporte();
	}

	@Override
	public String toString() {
		return "Electrodomestico{" +
				"marca='" + marca + '\'' +
				", modelo='" + modelo + '\'' +
				", precioBase=" + precioBase +
				", consumoEnergetico=" + consumoEnergetico +
				", altura=" + altura +
				", anchura=" + anchura +
				", peso=" + peso +
				'}';
	}

	/**
	 * Calcula la suma de los precios totales de todos los electrodomesticos dados.
	 *
	 * @param electrodomesticos Un conjunto de electrodomesticos
	 * @return La suma de los precios totales
	 */
	protected static double ingresoTotal(Electrodomestico... electrodomesticos) {
		if (electrodomesticos.length == 0) {
			return 0;
		}

		return Arrays.stream(electrodomesticos)
				.map(Electrodomestico::calcularPvp)
				.reduce(Double::sum)
				.get();
	}

	public class MalFormatoException extends Exception {
		public MalFormatoException() {}

		public MalFormatoException(String message) {
			super(message);
		}
	}
}
