package com.tipocambio.api.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.tipocambio.api.dto.AuthRequest;
import com.tipocambio.api.dto.AuthResponse;
import com.tipocambio.api.entities.Usuario;


public interface UserService {

	ResponseEntity<AuthResponse> login(AuthRequest authRequest);
	List<Usuario> listarUsuario();
}
