package com.bolsaideas.springboot.web.app.controllers;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsaideas.springboot.web.app.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {

	//nombre de la vista que queremos mostrar o cargar
	//@RequestMapping(value="/index",method =RequestMethod.GET) //si no se indica nada es GET
	
//	@GetMapping({"/index","/","/home"})
//	public String index(Model model) {
//		model.addAttribute("titulo","hola Spring Framework");
//		return "index";
//	
	@GetMapping({"/index","/","/home"})
	public String index(Map<String,Object> map) {
		map.put("titulo","hola Spring Framework");
		return "index";
	}
	
	
	@GetMapping("/perfil")
	public String usuario(Model model) {
		Usuario usuario = new Usuario("Ruben","Castrillo");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil de usuario ");
		return "perfil";
	}
		
}
