/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author anastasia.salari
 */
@Entity
public class Match implements Serializable {

    @ManyToMany
    private List<Joueur> compoE2;

    /**
     * Get the value of compoE2
     *
     * @return the value of compoE2
     */
    public List<Joueur> getCompoE2() {
        return compoE2;
    }

    /**
     * Set the value of compoE2
     *
     * @param compoE2 new value of compoE2
     */
    public void setCompoE2(List<Joueur> compoE2) {
        this.compoE2 = compoE2;
    }

    
    @ManyToMany
    private List<Joueur> compoE1;

    /**
     * Get the value of compoE1
     *
     * @return the value of compoE1
     */
    public List<Joueur> getCompoE1() {
        return compoE1;
    }

    /**
     * Set the value of compoE1
     *
     * @param compoE1 new value of compoE1
     */
    public void setCompoE1(List<Joueur> compoE1) {
        this.compoE1 = compoE1;
    }

    @ManyToOne
    private Arbitre arbitre;

    /**
     * Get the value of arbitre
     *
     * @return the value of arbitre
     */
    public Arbitre getArbitre() {
        return arbitre;
    }

    /**
     * Set the value of arbitre
     *
     * @param arbitre new value of arbitre
     */
    public void setArbitre(Arbitre arbitre) {
        this.arbitre = arbitre;
    }

    
    @OneToMany(mappedBy = "match")
    private List<FauteComise> fauteComises;

    public List<FauteComise> getFauteComises() {
        return fauteComises;
    }

    public void setFauteComises(List<FauteComise> fauteComises) {
        this.fauteComises = fauteComises;
    }

    
    private int butsEquipe2;

    /**
     * Get the value of butsEquipe2
     *
     * @return the value of butsEquipe2
     */
    public int getButsEquipe2() {
        return butsEquipe2;
    }

    /**
     * Set the value of butsEquipe2
     *
     * @param butsEquipe2 new value of butsEquipe2
     */
    public void setButsEquipe2(int butsEquipe2) {
        this.butsEquipe2 = butsEquipe2;
    }

    private int butsEquipe;

    /**
     * Get the value of butsEquipe
     *
     * @return the value of butsEquipe
     */
    public int getButsEquipe() {
        return butsEquipe;
    }

    /**
     * Set the value of butsEquipe
     *
     * @param butsEquipe new value of butsEquipe
     */
    public void setButsEquipe(int butsEquipe) {
        this.butsEquipe = butsEquipe;
    }

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;

    /**
     * Get the value of date
     *
     * @return the value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the value of date
     *
     * @param date new value of date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Match)) {
            return false;
        }
        Match other = (Match) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entites.Match[ id=" + id + " ]";
    }
    
}
