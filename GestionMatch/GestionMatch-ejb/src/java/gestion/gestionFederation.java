/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import Entites.Entraineur;
import Entites.Equipe;
import Entites.HistoriqueEEquipe;
import Entites.HistoriqueJEquipe;
import Entites.Match;
import Facade.ArbitreFacadeLocal;
import Facade.EntraineurFacadeLocal;
import Facade.EquipeFacadeLocal;
import Facade.HistoriqueEEquipeFacadeLocal;
import gestion.gestionFederationLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author anastasia.salari
 */
@Stateless
public class gestionFederation implements gestionFederationLocal {

    @EJB
    private HistoriqueEEquipeFacadeLocal historiqueEEquipeFacade;

    @EJB
    private EntraineurFacadeLocal entraineurFacade;

    @EJB
    private EquipeFacadeLocal equipeFacade;

     @EJB
    private ArbitreFacadeLocal arbitreFacade;
    
     
     
    @Override
    public void creerEquipe(String nom) {
        equipeFacade.creerEquipe(nom,  new ArrayList<HistoriqueJEquipe>(), 0,  new ArrayList<HistoriqueEEquipe>());
    }

    @Override
    public void creerArbitre(String n, String p, String l, String m) {
        arbitreFacade.creerArbitre(n, p, l, m, new ArrayList<Match>());
    }

    @Override
    public void affecterEE(String n, String p, String nomE) {
       Entraineur e = entraineurFacade.rechercheEntraineur(n, p);
       Equipe eq = equipeFacade.rechercheEquipe(n);
       historiqueEEquipeFacade.creerHEE(new Date(), null, e, eq);    
    }


    
    
    
    
    
    

    
}
