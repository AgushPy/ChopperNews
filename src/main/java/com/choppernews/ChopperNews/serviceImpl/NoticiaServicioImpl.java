package com.choppernews.ChopperNews.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.choppernews.ChopperNews.entity.Noticia;
import com.choppernews.ChopperNews.repository.NoticiaRepo;
import com.choppernews.ChopperNews.service.NoticiaServicio;

public class NoticiaServicioImpl implements NoticiaServicio{

	@Autowired
	private NoticiaRepo noticiaRepo;
	
	
	@Override
	public void crearNoticia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Noticia traerNoticia() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarNoticia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarNoticia() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Noticia> traerNoticias() {
		// TODO Auto-generated method stub
		return null;
	}

}
