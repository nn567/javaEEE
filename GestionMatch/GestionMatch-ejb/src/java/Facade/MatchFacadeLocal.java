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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author anastasia.salari
 */
@Local
public interface MatchFacadeLocal {

    void create(Match match);

    void edit(Match match);

    void remove(Match match);

    Match find(Object id);

    List<Match> findAll();

    List<Match> findRange(int[] range);

    int count();

    void creerMatch(Date date, int butE1, int butE2, Arbitre a );

    void modifierMatch(Date date, String eq1, String eq2);

    List<Match> recupMatchsArbitre(Arbitre a);

    List<Match> recupMatchsEquipe(Equipe e);
    
}
