package com.choppernews.ChopperNews.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.MultipartFilter;

import com.choppernews.ChopperNews.entity.Noticia;
import com.choppernews.ChopperNews.repository.NoticiaRepo;
import com.choppernews.ChopperNews.serviceImpl.ImagenSerivicio;

import net.iharder.Base64;

@Controller
@RequestMapping("/noticia")
//@CrossOrigin(origins = "http://localhost:8080")
public class NoticiaController {
	
	@Autowired
	private NoticiaRepo noticiaRepo;
	
	
	@GetMapping("/crear")
	public String welcome() {
		return "formcrearnoticia.html";
	}
	
	@GetMapping("/home")
	public String home(ModelMap model) {
		List<Noticia> noticias = noticiaRepo.findAll();
		model.addAttribute("noticias",noticias);
		return "home.html";
	}
	
	@GetMapping("/{id}")
	public String mostrar(ModelMap model,@PathVariable Long id){
		Noticia noticia = noticiaRepo.getById(id);
		model.addAttribute("noticia",noticia);
		return "vistanoticia.html";
	}
	
	@RequestMapping(value="/cargarNoticia" ,consumes = "multipart/form-data",method=RequestMethod.POST)
	public String cargarNoticia(@RequestParam(name= "titulo") String titulo, @RequestParam(name="cuerpo") String cuerpo,
			@RequestParam(name="file") MultipartFile imagen,
			@RequestParam String pequeniaDescripcion) throws Exception {
		
		
		if(!imagen.isEmpty()) {
			//Path directorioImagenes = Paths.get("src//main//resources//static/images");
			//String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
			ImagenSerivicio imagenSerivicio = new ImagenSerivicio();
			try {
				Noticia noticia = new Noticia();
				//byte[] bytesImg = imagen.getBytes();
				//String valueImg = imagenSerivicio.encode(imagen);
				//String valueImgsave = imagenSerivicio.decode(valueImg);
				//Path rutaCompleta = Paths.get(rutaAbsoluta+"//"+imagen.getOriginalFilename());
				//Files.write(rutaCompleta, valueImgsave);
				String image = Base64.encodeBytes(imagen.getBytes()); 
				
				noticia.setFoto(image);
				noticia.setTitulo(titulo);
				noticia.setDescripcion(cuerpo);
				noticia.setPequeniaDescripcion(pequeniaDescripcion);
				Date fecha = new Date();
				int anio = 1900 + fecha.getYear();
				int mes = 1 +fecha.getMonth();
				String fechapub = fecha.getDate()+"-"+mes+"-"+anio;
				noticia.setFechapublic(fechapub);
				noticiaRepo.save(noticia);
				return "formcrearnoticia.html";
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		
		return "formcrearnoticia.html";
		
	}
	
	
}
