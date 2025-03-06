package com.tipocambio.api.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AuthResponse implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String token;

	public AuthResponse() {
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public AuthResponse(String token) {
		super();
		this.token = token;
	}

}
