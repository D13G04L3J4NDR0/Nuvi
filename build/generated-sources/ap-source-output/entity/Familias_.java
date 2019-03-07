package entity;

import entity.Problematicas;
import entity.Proyectos;
import entity.Tipodocumentos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:10")
@StaticMetamodel(Familias.class)
public class Familias_ { 

    public static volatile SingularAttribute<Familias, Integer> idFamilia;
    public static volatile SingularAttribute<Familias, Tipodocumentos> fkTipoDocum;
    public static volatile SingularAttribute<Familias, String> nombreCdeFamilia;
    public static volatile SingularAttribute<Familias, Integer> integrantesFamilia;
    public static volatile SingularAttribute<Familias, String> documCdeFamilia;
    public static volatile SingularAttribute<Familias, String> barrioFamilia;
    public static volatile SingularAttribute<Familias, String> apellidoCdeFamilia;
    public static volatile SingularAttribute<Familias, Problematicas> fkProblematica;
    public static volatile ListAttribute<Familias, Proyectos> proyectosList;
    public static volatile SingularAttribute<Familias, String> direccionFamilia;
    public static volatile SingularAttribute<Familias, Date> fechaVisita;
    public static volatile SingularAttribute<Familias, String> ciudadFamilia;
    public static volatile SingularAttribute<Familias, String> imgHogar;

}