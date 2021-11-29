package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Empleado;

public interface EmpleadoService {

	List<Empleado> getAEmpleados();
	void guardarEmpleado(Empleado e);
	//Empleado guardarEmpleadoById(long id);
	void borrarEmpleadoById (long id);
}
