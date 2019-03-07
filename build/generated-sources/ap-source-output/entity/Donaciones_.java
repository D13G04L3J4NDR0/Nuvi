package entity;

import entity.Donador;
import entity.Proyectos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:08")
@StaticMetamodel(Donaciones.class)
public class Donaciones_ { 

    public static volatile SingularAttribute<Donaciones, Integer> idDonacion;
    public static volatile SingularAttribute<Donaciones, Integer> valorDonacion;
    public static volatile SingularAttribute<Donaciones, String> imgComporbante;
    public static volatile SingularAttribute<Donaciones, Donador> fkDonador;
    public static volatile SingularAttribute<Donaciones, Date> fechaDonacion;
    public static volatile SingularAttribute<Donaciones, Proyectos> fkProyecto;

}