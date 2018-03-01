/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOLab;

import ModeloLab.Estudiante;
import ModeloLab.Materia;
import ModeloLab.Matricula;
import java.util.List;
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
        Estudiante ef = new Estudiante();
        Materia mf = new Materia();
        MatriculaFacade maf = new MatriculaFacade();

        ef.setId(id);
        mf.setCode(codeMate);

        matricula.setIdMatri(0);

        matricula.setIdMate(mf);
        matricula.setIdEst(ef);

        em.persist(matricula);
    }

}
