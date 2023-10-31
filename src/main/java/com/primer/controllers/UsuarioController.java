package com.primer.controllers;
//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.primer.dao.UsuarioDao;
import com.primer.modelo.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@SpringBootApplication
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
/*	@RequestMapping(value="mensaje")
	public String mensaje() {

		return "hola";
	}
	@RequestMapping(value="persona")
	public List<String> listarPersonas(){
		return List.of("Diego","Juan","Jose");
		
	}
	@RequestMapping(value="usuarios")
	public Usuario listarUsuarios() {
		Usuario usuario = new Usuario();
		usuario.setNombre("Martina");
		usuario.setApellido("Zambrano");
		usuario.setEmail("martisoy@hotmail.com");
		usuario.setTelefono("4273668");
		
		return usuario;
	}
	
	@RequestMapping(value="usuario/{id}")
	public Usuario getUsuario(@PathVariable Long id) {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNombre("Martina");
		usuario.setApellido("Zambrano");
		usuario.setEmail("martisoy@hotmail.com");
		usuario.setTelefono("4273668");
		
		return usuario;
	}	
	
	@RequestMapping(value="usuario/lista_user")
	public List<Usuario> listar_variosUsuarios() {
		
		List<Usuario> usuarios = new ArrayList<>();
		
		Usuario usuario1 = new Usuario();
		usuario1.setId(3L);
		usuario1.setNombre("Martina");
		usuario1.setApellido("Zambrano");
		usuario1.setEmail("martisoy@hotmail.com");
		usuario1.setTelefono("4273668");
		
		Usuario usuario2 = new Usuario();
		usuario2.setId(4L);
		usuario2.setNombre("Marina");
		usuario2.setApellido("Orellano");
		usuario2.setEmail("marin@hotmail.com");
		usuario2.setTelefono("155785668");
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		return usuarios;		
	}	*/
	
	@RequestMapping(value="api/usuarios")
	public List<Usuario> getUsuario(){
		List<Usuario> user=usuarioDao.getUsuarios();
		return user;
	}
	
	@RequestMapping(value="api/usuarios/{id}", method=RequestMethod.DELETE)
	public void eliminar(@PathVariable Long id) {
		usuarioDao.eliminar(id);
	}
	
	@RequestMapping(value="api/usuarios",method=RequestMethod.POST)
	public void registrarUsuario(@RequestBody Usuario usuario) {
		//		return usuarioDao.registrar()
				Argon2 argon2= Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);		
				String pass_hasheado=argon2.hash(1, 1024, 1, usuario.getPassword());
				usuario.setPassword(pass_hasheado);
				usuarioDao.registrar(usuario);
	}
	
	
}







