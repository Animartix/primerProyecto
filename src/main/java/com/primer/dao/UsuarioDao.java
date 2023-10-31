package com.primer.dao;

import java.util.List;

import com.primer.modelo.Usuario;

import jakarta.transaction.Transactional;

@Transactional
public interface UsuarioDao {
	List<Usuario> getUsuarios();
	void eliminar(Long id);
	void registrar(Usuario usuario);
	boolean verificarCredenciales(Usuario usuario);
}
