package com.bolsaideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

	
	
	@GetMapping("/")
	public String index(@RequestParam(name="texto",required=false) String texto, Model model){
		model.addAttribute("resultado"," El texto es " + texto);
		return "params/index";
	}
	
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto",required=false) String texto, Model model){
		model.addAttribute("resultado"," El texto es " + texto);
		return "params/ver";
	}
	
	
	@GetMapping("/mix-params")
	public String params(@RequestParam String texto, @RequestParam Integer numero,Model model){
		model.addAttribute("resultado"," El texto es " + texto + " y el numero es " + numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model){
		String texto = request.getParameter("texto");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e) {
			numero =0;
		}
		
		model.addAttribute("resultado"," El texto es " + texto + " y el numero es " + numero);
		return "params/ver";
	}
}
