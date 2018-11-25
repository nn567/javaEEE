/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.FauteComise;
import Entites.Match;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class MatchFacade extends AbstractFacade<Match> implements MatchFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MatchFacade() {
        super(Match.class);
    }

    @Override
    public void creerMatch(Date date, int butE1, int butE2, Arbitre a, List<FauteComise> liste) {
        Match m = new Match();
        m.setDate(date);
        m.setArbitre(a);
        m.setButsEquipe(butE2);
        m.setButsEquipe2(butE2);
        m.setFauteComises(liste);
        em.persist(m);
    }
    
    
}
