package com.luis.empleados.repositorios;

import org.hibernate.Hibernate;

import com.luis.empleado.modelo.Empleado;


public class RepositorioEmpleados extends Repositorio<Empleado> {

	@Override
	public Empleado get(Class<Empleado> tipo, int id) {
		// TODO Auto-generated method stub
		Empleado e= super.get(tipo, id);//vamos acceder al get perteneciente al padre

		Hibernate.initialize(e.getDepartamento());//inicializar la sesion para conseguir el departamento
		Hibernate.initialize(e.getPuesto());//inicializar la sesion para conseguir el puesto
        Hibernate.initialize(e.getIdiomas());
		return e;
	}
}