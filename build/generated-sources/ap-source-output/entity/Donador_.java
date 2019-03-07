package entity;

import entity.Donaciones;
import entity.Tipodocumentos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:10")
@StaticMetamodel(Donador.class)
public class Donador_ { 

    public static volatile SingularAttribute<Donador, Tipodocumentos> fkTipoDocum;
    public static volatile SingularAttribute<Donador, Date> fechaIngreso;
    public static volatile SingularAttribute<Donador, String> ciudadResidencia;
    public static volatile SingularAttribute<Donador, String> emailDonador;
    public static volatile ListAttribute<Donador, Donaciones> donacionesList;
    public static volatile SingularAttribute<Donador, Integer> docuDonador;
    public static volatile SingularAttribute<Donador, String> direccionResidencia;
    public static volatile SingularAttribute<Donador, Integer> idDonador;
    public static volatile SingularAttribute<Donador, String> contacDonador;
    public static volatile SingularAttribute<Donador, String> nombreDonador;

}