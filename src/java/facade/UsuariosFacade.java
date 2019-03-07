/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Diego Alejandro
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "NuviSenaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    public Usuarios iniciarSesion(int documento, String clave){
        Usuarios usuario =  null;
        String consulta;
        try{
            consulta ="SELECT u FROM Usuarios u WHERE u.documUsuario = :usuario AND u.claveUsuario = :clave";            
            Query q = em.createQuery(consulta);
            q.setParameter("usuario", documento);
            q.setParameter("clave", clave);
            
            List<Usuarios> lista = q.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
    public String cargarArchivos(String nombre, String tabla) {
        System.out.println();
        Query consulta = em.createNativeQuery("load data local infile 'C:/Users/Diego Leguizamon/Desktop/"+nombre+"' into table "+tabla+" fields terminated by ';'");
        int resultado=consulta.executeUpdate();
        String mensaje=resultado+ " filas afectadas";
        System.out.println(mensaje);
        return mensaje;
    }
}
