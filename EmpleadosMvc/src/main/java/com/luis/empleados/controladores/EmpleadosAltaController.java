package com.luis.empleados.controladores;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.luis.empleado.modelo.Departamento;
import com.luis.empleado.modelo.Empleado;
import com.luis.empleado.modelo.Puesto;
import com.luis.empleado.modelo.viewforms.EmpleadoViewForm;
import com.luis.empleados.repositorios.RepositorioDepartamento;
import com.luis.empleados.repositorios.RepositorioEmpleados;
import com.luis.empleados.repositorios.RepositorioIdiomas;
import com.luis.empleados.repositorios.RepositorioPuesto;


@Controller
@RequestMapping(value="altaEmpleado.html")
public class EmpleadosAltaController{
      @Autowired//inyecta el repositorio en la clase
      RepositorioEmpleados dao;
      @Autowired//inyecta el repositorio en la clase
      RepositorioPuesto daoPuesto;
      @Autowired//inyecta el repositorio en la clase
      RepositorioDepartamento daoDepartamento;
      @Autowired//inyecta el repositorio en la clase
      RepositorioIdiomas daoIdiomas;
     
      
      
      @RequestMapping(method=RequestMethod.GET)
      public String alta(ModelMap modelo){
    	 EmpleadoViewForm empleado=new EmpleadoViewForm();//esto va a ser el empleado que el usuario crea en el formulario
    	 modelo.addAttribute("empleado", empleado);//se lo añadimos al modelo y mando a alta 
    	 Map<Integer,String> lp=daoPuesto.getMapaOptions();//recibe la información de los repositorios puesto
    	 Map<Integer,String> ld=daoDepartamento.getMapaOptions();//recibe la información de los repositorios departamentos
    	 Map<Integer,String> li=daoIdiomas.getMapaOptions();
    	 modelo.addAttribute("puestos", lp);
    	 modelo.addAttribute("departamentos", ld);
    	 modelo.addAttribute("idiomas", li);
    	 return "alta";
      }
      @RequestMapping(method=RequestMethod.POST) 
      public String doAlta(@ModelAttribute("empleado")EmpleadoViewForm empleado, BindingResult resultado, HttpServletRequest request ){
    	  if(resultado.hasErrors()){
    		  Map<Integer,String> lp=daoPuesto.getMapaOptions();//recibe la información de los repositorios puesto
    	      Map<Integer,String> ld=daoDepartamento.getMapaOptions();//r  
    	      Map<Integer,String> li=daoIdiomas.getMapaOptions();
    	      request.setAttribute("puestos", lp);
    	      request.setAttribute("departamentos", ld);
    	      request.setAttribute("Idiomas", li);
    	      return "alta";
    	      }
          Empleado emple=empleado.getEmpleado();
    	  emple.setFechaAlta(new Date());
          dao.add(emple);
    	  
    	  
    	  return "redirect:/listado.html";
      }

}
