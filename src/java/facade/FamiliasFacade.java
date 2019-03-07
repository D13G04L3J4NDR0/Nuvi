/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Familias;
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
public class FamiliasFacade extends AbstractFacade<Familias> {

    @PersistenceContext(unitName = "NuviSenaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FamiliasFacade() {
        super(Familias.class);
    }
    
    public List<Object[]> graficarProblematica() {
        Query q = em.createNativeQuery("SELECT problematicas.Problematica, COUNT(*) as Cantidad\n"
                + "	FROM FAMILIAS  JOIN problematicas\n"
                + "	ON problematicas.id_Problematica= familias.fk_Problematica \n"
                + "	GROUP BY problematicas.id_Problematica;");
        List<Object[]> listadoFamilias = q.getResultList();
        return listadoFamilias;
    }
    
}
