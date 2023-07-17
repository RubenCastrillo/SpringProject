package com.bolsaideas.springboot.web.app.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoperfil;
	//nombre de la vista que queremos mostrar o cargar
	//@RequestMapping(value="/index",method =RequestMethod.GET) //si no se indica nada es GET
	
//	@GetMapping({"/index","/","/home"})
//	public String index(Model model) {
//		model.addAttribute("titulo","hola Spring Framework");
//		return "index";
//	
	@GetMapping({"/index","/","/home"})
	public String index(Map<String,Object> map) {
		map.put("titulo",textoIndex);
		return "index";
	}
	
	
	@GetMapping("/perfil")
	public String usuario(Model model) {
		Usuario usuario = new Usuario("Ruben","Castrillo");
		usuario.setEmail("prueba@email.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoperfil);
		return "perfil";
	}
	
	@GetMapping("/listar")  
	public String listar(Model model) {
	
		model.addAttribute("titulo", "Listado de usuarios: ");
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		Usuario usuario1 = new Usuario("Ruben","Castrillo");
		usuario1.setEmail("ruben@email.com");
		
		Usuario usuario2 = new Usuario("Pedro","Martinez");
		usuario2.setEmail("pedro@email.com");
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario2);
		usuarios.add(usuario1);
		return usuarios;
	}
		
}
