package com.tipocambio.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tipocambio.api.entities.Usuario; 

@Repository
public interface  UsuarioRepository  extends JpaRepository<Usuario, Integer>{
	@Query ("select u from Usuario u where u.usuario=?1")
	Usuario findByUsuario(String usuario);
	
	
}
