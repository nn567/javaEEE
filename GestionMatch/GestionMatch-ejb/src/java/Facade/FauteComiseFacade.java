/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.Faute;
import Entites.FauteComise;
import Entites.Joueur;
import Entites.Match;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class FauteComiseFacade extends AbstractFacade<FauteComise> implements FauteComiseFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FauteComiseFacade() {
        super(FauteComise.class);
    }

    @Override
    public void creerFaute(Faute type, Joueur joueur, Match match) {
        FauteComise FC = new FauteComise();
        FC.setFaute(type);
        FC.setJoueur(joueur);
        FC.setMatch(match);
        em.persist(FC);
    }
    
    
}
