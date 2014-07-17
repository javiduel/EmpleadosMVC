package com.luis.empleados.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.empleado.modelo.Empleado;
import com.luis.empleados.repositorios.RepositorioEmpleados;



@Controller
public class EmpleadosController {

	@Autowired //conectado automaticamente y vamos al xml y busca repositorio empleados y esta indicado que es el daoempleado
	RepositorioEmpleados daoEmpleado;
	
	@RequestMapping(value="/listado.html")
     public String Listado(Model modelo){
    	
		List<Empleado> l=daoEmpleado.get(Empleado.class);//vas a crear una lista utiliando los datos del getl
		modelo.addAttribute("empleados", l);//objeto del spring para mantener los datos en la memoria coje datos desde la vista al controlador y del controlador a la vista
		
		return "listado";
     }

@RequestMapping(value="detalle.html", method=RequestMethod.GET)
public String detalle(Model modelo, HttpServletRequest request){
	int id=Integer.parseInt(request.getParameter("id"));
	Empleado e=daoEmpleado.get(Empleado.class, id);
    modelo.addAttribute("empleado", e);
	
	return "detalle";
}



}


