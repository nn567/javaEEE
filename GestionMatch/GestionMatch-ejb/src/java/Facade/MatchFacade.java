/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Equipe;
import Entites.FauteComise;
import Entites.Joueur;
import Entites.Match;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public void creerMatch(Date date, int butE1, int butE2, Arbitre a) {
        Match m = new Match();
        m.setDate(date);
        m.setArbitre(a);
        m.setButsEquipe(butE2);
        m.setButsEquipe2(butE2);
        m.setFauteComises(new ArrayList<FauteComise>());
        m.setCompoE1( new ArrayList<Joueur>());
        m.setCompoE2(new ArrayList<Joueur>());
        em.persist(m);
    }

    @Override
    public void modifierMatch(Date date, String eq1, String eq2) {
      Match m = new Match();  
    }

    @Override
    public List<Match> recupMatchsArbitre(Arbitre a) {
        Query requete = em.createQuery("SELECT m from Match as m where m.arbitre=:arb");
        requete.setParameter("arb", a);     
        List<Match> liste =  requete.getResultList();
        return liste;
      
    }

    @Override
    public List<Match> recupMatchsEquipe(Equipe e) {
        Query requete = em.createQuery("SELECT m from Match as m where m.equipe1=:eq union SELECT m from Match as m where m.equipe2=:eq");
        requete.setParameter("eq", e);     
        List<Match> liste =  requete.getResultList();
        return  liste;
    }
    
    
    
    
    
}
