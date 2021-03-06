package com.luis.empleado.modelo;
// Generated 14-jul-2014 18:43:38 by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Proyecto generated by hbm2java
 */
@Entity
@Table(name="Proyecto"
    ,catalog="teide2014"
)
public class Proyecto  implements java.io.Serializable {


     private Integer idProyecto;
     private String nombre;
     private String descripcion;
     private Set<EmpleadoProyecto> empleadoProyectos = new HashSet<EmpleadoProyecto>(0);

    public Proyecto() {
    }

	
    public Proyecto(String nombre) {
        this.nombre = nombre;
    }
    public Proyecto(String nombre, String descripcion, Set<EmpleadoProyecto> empleadoProyectos) {
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.empleadoProyectos = empleadoProyectos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idProyecto", unique=true, nullable=false)
    public Integer getIdProyecto() {
        return this.idProyecto;
    }
    
    public void setIdProyecto(Integer idProyecto) {
        this.idProyecto = idProyecto;
    }

    
    @Column(name="nombre", nullable=false, length=45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="descripcion", length=45)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proyecto")
    public Set<EmpleadoProyecto> getEmpleadoProyectos() {
        return this.empleadoProyectos;
    }
    
    public void setEmpleadoProyectos(Set<EmpleadoProyecto> empleadoProyectos) {
        this.empleadoProyectos = empleadoProyectos;
    }




}


