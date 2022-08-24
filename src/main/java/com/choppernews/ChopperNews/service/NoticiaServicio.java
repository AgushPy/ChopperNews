package com.choppernews.ChopperNews.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.choppernews.ChopperNews.entity.Noticia;

@Service
public interface NoticiaServicio {
	public void crearNoticia();
	public Noticia traerNoticia();
	public void borrarNoticia();
	public void actualizarNoticia();
	public List<Noticia> traerNoticias();
}
