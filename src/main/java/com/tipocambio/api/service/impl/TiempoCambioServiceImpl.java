package com.tipocambio.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;
import com.tipocambio.api.exception.TipoCambioException;
import com.tipocambio.api.repository.TipoCambioRepository;
import com.tipocambio.api.service.TipoCambioService;

@Service
public class TiempoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@Override
	public List<TipoCambio> listarTipoCambio() {
		return tipoCambioRepository.findAll();
	}

	@Override
	public TipoCambioDTO convertirTipoCambio(double monto, String monedaOrigen, String monedaDestino) {
		TipoCambio tipoDeCambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino);

		if (tipoDeCambio == null) {
			throw new TipoCambioException("No se encontró el tipo de cambio para las monedas especificadas");
		}
		double montoConvertido = monto * tipoDeCambio.getTipoCambio();

		return new TipoCambioDTO(monto, tipoDeCambio.getTipoCambio(), monedaOrigen, monedaDestino, montoConvertido);
	}

	@Override
	public TipoCambio actualizarTipoDeCambio(TipoCambioDTO tipoDeCambioDTO) {
		TipoCambio tipoDeCambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(
				tipoDeCambioDTO.getMonedaOrigen(), tipoDeCambioDTO.getMonedaDestino());

		if (tipoDeCambio == null) {
			throw new TipoCambioException("El tipo de cambio para las monedas especificadas no existe");
		}

		tipoDeCambio.setTipoCambio(tipoDeCambioDTO.getTipoDeCambio());
		tipoCambioRepository.save(tipoDeCambio);
		return tipoDeCambio;
	}

}
