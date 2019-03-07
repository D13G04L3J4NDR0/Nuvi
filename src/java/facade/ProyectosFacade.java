/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Proyectos;
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
public class ProyectosFacade extends AbstractFacade<Proyectos> {

    @PersistenceContext(unitName = "NuviSenaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectosFacade() {
        super(Proyectos.class);
    }
    
    // Consulta de estado
    public List<Proyectos> consultarEstadosdeProyectos(String estado) {
        Query consulta = em.createNativeQuery("call listarProyectosPorEstado(?1);", Proyectos.class);
        consulta.setParameter(1, estado);
        return consulta.getResultList();
    }

    public int consultarCodProyectos(String codProyecto) {
        Query consultamas = em.createNativeQuery("SELECT count(proyectos.cod_proyecto) from proyectos\n"
                + "where proyectos.cod_proyecto = '" + codProyecto + "';");
        return Integer.parseInt("" + consultamas.getSingleResult());
    }

    public int contarEstados(String estado) {
        Query consultamas = em.createNativeQuery("SELECT count(*) from proyectos\n"
                + "where proyectos.Estado_Proyecto = '" + estado + "';");
        return Integer.parseInt("" + consultamas.getSingleResult());
    }
    
}
