package entity;

import entity.ProyectosUsuarios;
import entity.Roles;
import entity.Tipodocumentos;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-17T14:09:08")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Tipodocumentos> fkTipoDocum;
    public static volatile SingularAttribute<Usuarios, Roles> fkRoles;
    public static volatile SingularAttribute<Usuarios, Integer> estado;
    public static volatile SingularAttribute<Usuarios, String> apellidoUsuario;
    public static volatile SingularAttribute<Usuarios, String> contacUsuario;
    public static volatile SingularAttribute<Usuarios, String> claveUsuario;
    public static volatile SingularAttribute<Usuarios, Integer> idUsuario;
    public static volatile SingularAttribute<Usuarios, Integer> documUsuario;
    public static volatile SingularAttribute<Usuarios, String> emailUsuario;
    public static volatile SingularAttribute<Usuarios, String> nombreUsuario;
    public static volatile ListAttribute<Usuarios, ProyectosUsuarios> proyectosUsuariosList;

}