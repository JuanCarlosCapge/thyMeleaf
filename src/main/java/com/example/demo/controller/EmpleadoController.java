package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Empleado;
import com.example.demo.service.EmpleadoService;

@Controller
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listaEmpleados",empleadoService.getAEmpleados());
		return "index";
	}
	
	@GetMapping("/guardarempleadoform")
	public String guardarEmpleado(Model model) {
		Empleado e= new Empleado();
		model.addAttribute("empleado",e);
		return "nuevo_empleado";
	}
	
	@PostMapping("/guardarempleado")
	public String guardarEmpleado(@ModelAttribute ("empleado") Empleado e) {
		empleadoService.guardarEmpleado(e);
		return "redirect:/";
	}
	
	/*@GetMapping("/guardarEmpleadoNuevo/{id}")
	public String guardarEmpleadoNuevo(@PathVariable (value="id")long id, Model model) {
		
		Empleado empleado = empleadoService.getEmpleadosById(id);
		model.addAttribute("empleado", empleado);
		return "guardarEmpleado";
		
	}*/
	@GetMapping("/borrarEmpleado/{id}")
	public String borrarEmpleado(@PathVariable (value = "id") long id) {
		
		this.empleadoService.borrarEmpleadoById(id);
		return "redirect:/";
		
	}
	
}
