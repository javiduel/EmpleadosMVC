package com.luis.empleados.repositorios;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class Repositorio<T> extends HibernateDaoSupport implements IRepositorio<T> {
	Session sesion=null;
	@Override
	public List<T> get(Class<T> tipo) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
		Query q=sesion.createQuery("from " +tipo.getName());//sacamos la lista que queremos
		List<T> l=(List <T>)q.list();
		return l;
	}

	@Override
	public T get(Class<T> tipo, int id) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
	    T obj=(T) sesion.get(tipo, id);//obtenemos el objeto que le estoy pasando con el indicador id
		return obj;
	}

	@Override
	public void add(T objeto) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
	    sesion.save(objeto);
	  
	    
		
		
	}

	@Override
	public void delete(T objeto) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
	    sesion.delete(objeto);
		
	}

	@Override
	public void update(T objeto) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
	    sesion.update(objeto);
	}

	@Override
	public List<T> find(String consulta, Map<String, Object> params) {
		if(sesion==null || !sesion.isOpen())
		sesion=getSessionFactory().getCurrentSession();//obtenemos la sesion actual
		Query q=sesion.getNamedQuery(consulta);//recuperamos una consulta con nombre
		for (String param : params.keySet()){
			 q.setParameter(param, params.get(param));
			 
		}
		List<T> l=q.list();//ejecuta el resultado de la consulta
		return l;
	}

}
