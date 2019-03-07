package entity;

import entity.Materiales;
import entity.Proyectos;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:09")
@StaticMetamodel(MaterialesProyecto.class)
public class MaterialesProyecto_ { 

    public static volatile SingularAttribute<MaterialesProyecto, Integer> idMaterialProyecto;
    public static volatile SingularAttribute<MaterialesProyecto, Float> valorTotal;
    public static volatile SingularAttribute<MaterialesProyecto, Materiales> fkMaterial;
    public static volatile SingularAttribute<MaterialesProyecto, Float> cantidadMaterial;
    public static volatile SingularAttribute<MaterialesProyecto, Proyectos> fkProyecto;
    public static volatile SingularAttribute<MaterialesProyecto, Float> valorUnitario;

}