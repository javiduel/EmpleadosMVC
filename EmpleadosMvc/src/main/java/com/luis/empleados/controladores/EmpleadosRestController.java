package com.luis.empleados.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luis.empleado.modelo.Empleado;
import com.luis.empleados.repositorios.RepositorioEmpleados;


@Controller
@RequestMapping(value="/empleado")//a esta clase se llama siempre /empleado
public class EmpleadosRestController {
	      
	
	@Autowired
	RepositorioEmpleados dao;
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")//crea la estructura de como quiero que lo reciba cuando pongamos /empleado/23 id valdra 23
	 public @ResponseBody Empleado empleado(@PathVariable int id){//recibimos los parametros el path variable es un parametro que viende desde la url @ResposeBody quier decir que responda con el mismo objeto que indica por ejemplo empleados
	  Empleado e=dao.get(Empleado.class, id);//
	return e;  	
		
	      }

@RequestMapping(method=RequestMethod.GET, value="/buscar/{texto}")
   public @ResponseBody List<Empleado> buscar (@PathVariable String texto){
	Map<String,Object> params=new HashMap();//una lista clave valor 
	params.put("texto","%"+texto+"%");//da igual la posicion de la palabra que ponga si buscar a luis sera todo que contenga luis
	List<Empleado> l=dao.find("empleado.buscador",params);
	return l;
   }
	
 }
                
