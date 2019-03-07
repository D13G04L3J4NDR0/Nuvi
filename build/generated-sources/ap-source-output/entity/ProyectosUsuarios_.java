package entity;

import entity.Proyectos;
import entity.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:10")
@StaticMetamodel(ProyectosUsuarios.class)
public class ProyectosUsuarios_ { 

    public static volatile SingularAttribute<ProyectosUsuarios, Usuarios> fkUsuario;
    public static volatile SingularAttribute<ProyectosUsuarios, Integer> idProyectoUsuario;
    public static volatile SingularAttribute<ProyectosUsuarios, Proyectos> fkProyecto;

}