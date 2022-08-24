package com.choppernews.ChopperNews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.choppernews.ChopperNews.entity.Usuario;

@Service
public interface UsuarioServicio {
	public void crearUsuario();
	public Usuario traerUsuario();
	public void borrarUsuario();
	public void actualizarUsuario();
	public List<Usuario> traerUsuarios();
}
