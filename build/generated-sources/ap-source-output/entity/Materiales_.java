package entity;

import entity.MaterialesProyecto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:10")
@StaticMetamodel(Materiales.class)
public class Materiales_ { 

    public static volatile SingularAttribute<Materiales, String> descripcion;
    public static volatile SingularAttribute<Materiales, String> unidadMedida;
    public static volatile SingularAttribute<Materiales, Integer> idMaterial;
    public static volatile SingularAttribute<Materiales, String> nombreMaterial;
    public static volatile ListAttribute<Materiales, MaterialesProyecto> materialesProyectoList;

}