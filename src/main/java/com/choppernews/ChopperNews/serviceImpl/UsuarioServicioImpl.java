package com.choppernews.ChopperNews.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choppernews.ChopperNews.entity.Usuario;
import com.choppernews.ChopperNews.repository.UsuarioRepo;
import com.choppernews.ChopperNews.service.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio{

	@Autowired
	private UsuarioRepo usuarioRepo;
	
	@Override
	public void crearUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario traerUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Usuario> traerUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
