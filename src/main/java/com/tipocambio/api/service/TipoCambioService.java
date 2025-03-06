package com.tipocambio.api.service;

import java.util.List;

import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;

public interface TipoCambioService {

	public TipoCambioDTO convertirTipoCambio(double monto, String monedaOrigen, String monedaDestino);

	public List<TipoCambio> listarTipoCambio();

	public TipoCambio actualizarTipoDeCambio(TipoCambioDTO tipoDeCambioDTO);
}
