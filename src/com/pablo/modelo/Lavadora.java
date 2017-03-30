package com.pablo.modelo;

public class Lavadora extends Electrodomestico {

	private TipoCarga tipoCarga;
	private double velocidadCentrifugado;
	private boolean esSecadora;

	public TipoCarga getTipoCarga() {
		return tipoCarga;
	}

	public Lavadora setTipoCarga(TipoCarga tipoCarga) {
		this.tipoCarga = tipoCarga;
		return this;
	}

	public double getVelocidadCentrifugado() {
		return velocidadCentrifugado;
	}

	public Lavadora setVelocidadCentrifugado(double velocidadCentrifugado)
			throws MalFormatoException {

		if (velocidadCentrifugado < 0) {
			throw new MalFormatoException("La velocidad de centrifugado no puede ser negativa");
		}

		this.velocidadCentrifugado = velocidadCentrifugado;
		return this;
	}

	public boolean esSecadora() {
		return esSecadora;
	}

	public Lavadora setEsSecadora(boolean esSecadora) {
		this.esSecadora = esSecadora;
		return this;
	}

	public enum TipoCarga {
		FRONTAL,
		SUPERIOR
	}

	public Lavadora() {
		super();
	}

	public Lavadora(
			String marca,
			String modelo,
			double precioBase,
			char consumoEnergetico,
			double altura,
			double anchura,
			double peso,
			TipoCarga tipoCarga,
			double velocidadCentrifugado,
			boolean esSecadora
	) throws MalFormatoException {

		super(marca, modelo, precioBase, consumoEnergetico, altura, anchura, peso);

		this
			.setTipoCarga(tipoCarga)
			.setVelocidadCentrifugado(velocidadCentrifugado)
			.setEsSecadora(esSecadora);
	}

	@Override
	public String toString() {
		return "Lavadora{" +
				"tipoCarga=" + tipoCarga +
				", velocidadCentrifugado=" + velocidadCentrifugado +
				", esSecadora=" + esSecadora +
				"} " + super.toString();
	}

	/**
	 * Calcula la suma de los precios totales de todos las lavadoras dadas.
	 *
	 * @param lavadoras Un conjunto de frigoríficos
	 * @return La suma de los precios totales
	 */
	public static double ingresoTotalLavadoras(Lavadora... lavadoras) {
		return Electrodomestico.ingresoTotal(lavadoras);
	}
}
