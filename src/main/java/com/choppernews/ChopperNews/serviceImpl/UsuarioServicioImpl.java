package com.choppernews.ChopperNews.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.choppernews.ChopperNews.entity.Usuario;
import com.choppernews.ChopperNews.enumeraciones.Rol;
import com.choppernews.ChopperNews.exceptions.MyException;
import com.choppernews.ChopperNews.repository.UsuarioRepo;
import com.choppernews.ChopperNews.service.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio,UserDetailsService{

	@Autowired
	private UsuarioRepo usuarioRepo;
	
	

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
	
	@Transactional
	public Usuario registrar(String nombre, String password,String password2,String email) throws Exception {
		validar(nombre, email, password, password2);
		Usuario usuario =  new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setEmail(email);
		usuario.setPassword(new BCryptPasswordEncoder().encode(password));
		usuario.setRole(Rol.USER);
		
		return usuario;
	}
	
	private void validar(String nombre, String email,String password,String password2) throws MyException {
		if(nombre.isEmpty() || nombre == null) {
			throw new MyException("El nombre es un campo requerido");
		}
		if(email.isEmpty() || email == null) {
			throw new MyException("El email es un campo requerido");
		}
		if(password.isEmpty() || password== null) {
			throw new MyException("La password es un campo requerido");
		}
		
		if(!password.equals(password2)) {
			throw new MyException("Las contraseñas no coinciden");
		}
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepo.buscarPorEmail(email);
		
		if(usuario !=null) {
			
			List<GrantedAuthority> permisos = new ArrayList<>();
			
			GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+Rol.USER);
			permisos.add(p);
			User user =  new User(usuario.getEmail(),usuario.getPassword(),permisos);
			return user;
		}else {		
			return null;
		}
		
	}

	@Override
	public void crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepo.save(usuario);
	}


}
