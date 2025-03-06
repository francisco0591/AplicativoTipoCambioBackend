package com.tipocambio.api.dto;

import java.io.Serializable;

public class TipoCambioDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double monto;
	private double montoConvertido;
	private String monedaOrigen;
	private String monedaDestino;
	private double tipoDeCambio;

	public TipoCambioDTO() {

	}

	public TipoCambioDTO(double monto, double tipoDeCambio, String monedaOrigen, String monedaDestino,
			double montoConvertido) {
		this.monto = monto;
		this.montoConvertido = montoConvertido;
		this.monedaOrigen = monedaOrigen;
		this.monedaDestino = monedaDestino;
		this.tipoDeCambio = tipoDeCambio;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public double getMontoConvertido() {
		return montoConvertido;
	}

	public void setMontoConvertido(double montoConvertido) {
		this.montoConvertido = montoConvertido;
	}

	public String getMonedaOrigen() {
		return monedaOrigen;
	}

	public void setMonedaOrigen(String monedaOrigen) {
		this.monedaOrigen = monedaOrigen;
	}

	public String getMonedaDestino() {
		return monedaDestino;
	}

	public void setMonedaDestino(String monedaDestino) {
		this.monedaDestino = monedaDestino;
	}

	public double getTipoDeCambio() {
		return tipoDeCambio;
	}

	public void setTipoDeCambio(double tipoDeCambio) {
		this.tipoDeCambio = tipoDeCambio;
	}

}
