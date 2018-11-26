/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Equipe;
import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class EquipeFacade extends AbstractFacade<Equipe> implements EquipeFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipeFacade() {
        super(Equipe.class);
    }

    @Override
    public void creerEquipe(String nomE, List<HistoriqueJEquipe> histoJE, int points, List<HistoriqueEEquipe> histoEE ) {
        Equipe e = new Equipe();
        e.setNomE(nomE);
        e.setPoints(points);
        e.setHistoriqueJE(histoJE);
        e.setHistoriqueEEquipes(histoEE);
        em.persist(e);
    }
    
    
    
    
}
