package entity;

import entity.Donador;
import entity.Familias;
import entity.Personal;
import entity.Usuarios;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:09")
@StaticMetamodel(Tipodocumentos.class)
public class Tipodocumentos_ { 

    public static volatile SingularAttribute<Tipodocumentos, String> descripcion;
    public static volatile ListAttribute<Tipodocumentos, Usuarios> usuariosList;
    public static volatile SingularAttribute<Tipodocumentos, Integer> idTipoDocum;
    public static volatile ListAttribute<Tipodocumentos, Familias> familiasList;
    public static volatile ListAttribute<Tipodocumentos, Donador> donadorList;
    public static volatile SingularAttribute<Tipodocumentos, String> tipoDocum;
    public static volatile ListAttribute<Tipodocumentos, Personal> personalList;

}