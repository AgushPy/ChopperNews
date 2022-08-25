package com.choppernews.ChopperNews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.choppernews.ChopperNews.entity.Usuario;
import com.choppernews.ChopperNews.repository.UsuarioRepo;
import com.choppernews.ChopperNews.service.UsuarioServicio;
import com.choppernews.ChopperNews.serviceImpl.UsuarioServicioImpl;

@Controller
@RequestMapping("/")
public class PortalControlador {
	
	@Autowired
	private UsuarioRepo usuarioRepo;
	
	@GetMapping("/")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/registrar")
	public String registrar() {
		return "registrar.html";
	}
	
	@PostMapping("/registro")
	public String registro(
			@RequestParam String nombre,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String password2,
			ModelMap modelo
			) {
		UsuarioServicioImpl usuarioServicioImpl = new UsuarioServicioImpl();
		try {
			Usuario usuario = usuarioServicioImpl.registrar(nombre, password, password2, email);
			usuarioRepo.save(usuario);
			modelo.put("exito", "Usuario registrado correctamente");
			return "registrar.html";
		}catch(Exception e) {
			modelo.put("error", e.getMessage());
			modelo.put("nombre", nombre);
			modelo.put("email", email);
			modelo.put("password", password);
			modelo.put("password2", password2);
			return"registrar.html";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		return "registro.html";
	}
}
