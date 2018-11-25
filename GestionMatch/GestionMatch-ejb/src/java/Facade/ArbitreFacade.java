/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Arbitre;
import Entites.Match;
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
public class ArbitreFacade extends AbstractFacade<Arbitre> implements ArbitreFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArbitreFacade() {
        super(Arbitre.class);
    }

    @Override
    public void creerArbitre(String nom, String prenom, String login, String mdp, List<Match> listeM) {
        Arbitre a = new Arbitre();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setLogin(login);
        a.setMdp(mdp);
        a.setMatchs(listeM);
        em.persist(a);
    }

    @Override
    public Arbitre authen(String log, String mdp) {    
        Query requete = em.createQuery("SELECT a from Arbitre as a where a.login=:lo and a.mdp=:m");
        requete.setParameter("lo", log);
        requete.setParameter("m", mdp);       
        List<Arbitre> liste =  requete.getResultList();
        if (!liste.isEmpty())
            return liste.get(0);
        else return null;
    }
    
    
    
    
    
}
