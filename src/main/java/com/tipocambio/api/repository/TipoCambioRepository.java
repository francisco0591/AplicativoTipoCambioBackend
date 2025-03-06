package com.tipocambio.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tipocambio.api.entities.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {
	TipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}
