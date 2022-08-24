package com.choppernews.ChopperNews.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Noticia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descripcion;
	@Column(columnDefinition="MEDIUMTEXT")
	private String foto;
	private String pequeniaDescripcion;
	private String fechapublic;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getPequeniaDescripcion() {
		return pequeniaDescripcion;
	}
	public void setPequeniaDescripcion(String pequeniaDescripcion) {
		this.pequeniaDescripcion = pequeniaDescripcion;
	}
	public String getFechapublic() {
		return fechapublic;
	}
	public void setFechapublic(String fechapublic) {
		this.fechapublic = fechapublic;
	}
	
	
	
}
