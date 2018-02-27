/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOLab;

import ModeloLab.Estudiante;
import ModeloLab.Matricula;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Personal
 */
@Stateless
public class MatriculaFacade extends AbstractFacade<Matricula> implements MatriculaFacadeLocal {

    @PersistenceContext(unitName = "Laboratorio1.4PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatriculaFacade() {
        super(Matricula.class);
    }

    @Override
    public void matricula(int codeMate, int id) {
        Matricula matricula = new Matricula();
        EstudianteFacade ef = new EstudianteFacade();
        MateriaFacade mf = new MateriaFacade();
        
        matricula.setIdMate(mf.find(codeMate));
        matricula.setIdEst(ef.find(id));
        
        em.persist(matricula);
        
        
//        Query q = em.createQuery("insert  into  Matricula (idEst,idMate) values (:codeMate,:id)  ");
//        q.setParameter("id", id);
//        q.setParameter("codeMate", codeMate);
//        q.executeUpdate();
       }
    
}
