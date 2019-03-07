/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Problematicas;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Diego Alejandro
 */
@Stateless
public class ProblematicasFacade extends AbstractFacade<Problematicas> {

    @PersistenceContext(unitName = "NuviSenaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProblematicasFacade() {
        super(Problematicas.class);
    }
    
}
