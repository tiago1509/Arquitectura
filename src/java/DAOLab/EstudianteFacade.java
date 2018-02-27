/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOLab;

import ModeloLab.Estudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Personal
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> implements EstudianteFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1.4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }

    @Override
    public boolean checkLogin(String u, String p) {
       Query q = em.createQuery("select a from Estudiante a where a.name=:u and a.password=:p");
       q.setParameter("u",u);
       q.setParameter("p",p);
       return q.getResultList().size()>0;
       
               
    }
    
    
}
