package com.luis.empleados.repositorios;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luis.empleado.modelo.Puesto;

public class RepositorioPuesto extends Repositorio<Puesto>{
   public Map<Integer, String> getMapaOptions(){
	   List<Puesto> l=get(Puesto.class);
	   Map<Integer, String> mapa=new HashMap<Integer, String>();//creo un mapa y lo creo vacio
	   for(Puesto puesto : l){
		   mapa.put(puesto.getIdPuesto(),puesto.getNombre());//id del puesto //nombre del puesto
	   }
	    return mapa;		   
   }
}
