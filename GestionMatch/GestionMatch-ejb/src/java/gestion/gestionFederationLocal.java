/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface gestionFederationLocal {

    void creerEquipe(String nom);

    void creerArbitre(String n, String p, String l, String m);

    void affecterEE(String n, String p, String nomE);


    
}
