package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Empleado;
import com.example.demo.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImplent implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> getAEmpleados() {

		
		return empleadoRepository.findAll();
	}
	

	public void guardarEmpleado(Empleado e) {
	empleadoRepository.save(e);
	}


	/*@Override
	public Empleado guardarEmpleadoById(long id) {
		Optional<Empleado> optional = empleadoRepository.findById(id);
		if(optional.isPresent()) {
			Empleado = optional.get();
		}else {
			throw new RuntimeException("Empleado no funciona por id::"+ id);
		}
		
		return Empleado;
	}*/

	@Override
	public void borrarEmpleadoById(long id) {
		this.empleadoRepository.deleteById(id);
		
	}


	

}
