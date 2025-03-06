package com.tipocambio.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tipocambio.api.dto.AuthRequest;
import com.tipocambio.api.dto.AuthResponse;
import com.tipocambio.api.entities.Usuario;
import com.tipocambio.api.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {


	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome") 
    public String welcome() { 
	        return "Bienvenido"; 
    } 

  
	@GetMapping("/listarUsuario")
	public List<Usuario> listarUsuarios() {
		return userService.listarUsuario();
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		try {
			return userService.login(authRequest);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}


}
