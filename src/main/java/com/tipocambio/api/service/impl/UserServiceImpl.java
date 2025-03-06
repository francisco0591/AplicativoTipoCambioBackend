package com.tipocambio.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tipocambio.api.dto.AuthRequest;
import com.tipocambio.api.dto.AuthResponse;
import com.tipocambio.api.entities.Usuario;
import com.tipocambio.api.repository.UsuarioRepository;
import com.tipocambio.api.security.jwt.JWTUtil;
import com.tipocambio.api.security.jwt.PBKDF2Encoder;
import com.tipocambio.api.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PBKDF2Encoder passwordEncoder;

	@Override
	public ResponseEntity<AuthResponse> login(AuthRequest authRequest) {
	    Usuario u = usuarioRepository.findByUsuario("admin");
		if (u != null) {
			System.out.println("clave:" + passwordEncoder.encode(authRequest.getPassword()));
			if (passwordEncoder.encode(authRequest.getPassword()).equals(u.getPassword())) {
				return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(u)));
			} else {
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@Override
	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}
}
