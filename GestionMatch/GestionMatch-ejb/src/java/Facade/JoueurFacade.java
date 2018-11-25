/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entites.FauteComise;
import Entites.HistoriqueJEquipe;
import Entites.Joueur;
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
public class JoueurFacade extends AbstractFacade<Joueur> implements JoueurFacadeLocal {

    @PersistenceContext(unitName = "GestionMatch-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public JoueurFacade() {
        super(Joueur.class);
    }

    @Override
    public void creerJoueur(String nom, String prenom, List<FauteComise> listeF, List<HistoriqueJEquipe> histoE, Date dateI) {
        Joueur j = new Joueur();
        j.setNom(nom);
        j.setPrenom(prenom);
        j.setFauteComises(listeF);
        j.setHistoriqueJEquipes(histoE);
        j.setDateInterdiction(dateI);
        em.persist(j);
    }
    
    
    
}
