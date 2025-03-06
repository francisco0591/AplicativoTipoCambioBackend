package com.tipocambio.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tipocambio.api.dto.TipoCambioDTO;
import com.tipocambio.api.entities.TipoCambio;
import com.tipocambio.api.exception.TipoCambioException;
import com.tipocambio.api.service.TipoCambioService;

@RestController
@RequestMapping("api/tipocambio")
public class TipoCambioController {

	@Autowired
	private TipoCambioService tipoCambioService;

	@GetMapping("conversion")
	public ResponseEntity<?> getCambioTipoCambio(@RequestParam double monto, @RequestParam String monedaOrigen,
			@RequestParam String monedaDestino) {
		try {
			TipoCambioDTO tipoCambioDTO = tipoCambioService.convertirTipoCambio(monto, monedaOrigen, monedaDestino);
			return new ResponseEntity<>(tipoCambioDTO, HttpStatus.OK);
		} catch (TipoCambioException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<>("Ocurrió un error interno: " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/listarTipoCambio")
	public List<TipoCambio> listarTipoCambio() {
		List<TipoCambio> lstTipoCambio = new ArrayList<TipoCambio>();
		System.out.println("lista:" + tipoCambioService.listarTipoCambio().size());
		tipoCambioService.listarTipoCambio().forEach(tipocambio1 -> lstTipoCambio.add(tipocambio1));
		return lstTipoCambio;
	}

	@PatchMapping("/actualizar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> actualizarTipoDeCambio(@RequestBody TipoCambioDTO tipoDeCambioDTO) {
		try {
			return new ResponseEntity<>(tipoCambioService.actualizarTipoDeCambio(tipoDeCambioDTO), HttpStatus.OK);
		} catch (TipoCambioException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<>("Ocurrió un error interno: " + ex.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
