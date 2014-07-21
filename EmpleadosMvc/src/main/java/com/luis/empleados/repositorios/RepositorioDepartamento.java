package com.luis.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.empleado.modelo.Departamento;
import com.luis.empleado.modelo.Puesto;

public class RepositorioDepartamento extends Repositorio <Departamento>{
	 public Map<Integer, String> getMapaOptions(){
		   List<Departamento> l=get(Departamento.class);
		   Map<Integer, String> mapa=new HashMap<Integer, String>();//creo un mapa y lo creo vacio
		   for(Departamento departamento: l){
			   mapa.put(departamento.getIdDepartamento(),departamento.getNombre());//id del departamento //nombre del departamento
		   }
		    return mapa;		   
	   }
}
