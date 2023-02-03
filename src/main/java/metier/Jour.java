/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package metier;

/**
 *
 * @author perussel
 */
public class Jour {

    /**
     * 
     */
    public final static   int HASH = 7;
    
    /**
     * 
     */
    public final static  int VALEUR = 61;

    /**
     * année du jour.
     */
    private final int annee;

    /**
     * numero du jour.
     */
    private final int noJour;

    /**
     * Get the value of annee.
     *
     * @return the value of annee
     */
    public final int getAnnee() {
        return annee;
    }


    /**
     * Get the value of noJour.
     *
     * @return the value of noJour
     */
    public final int getNoJour() {
        return noJour;
    }

    /**
     * Constructor.
     * @param an
     * @param noJour
     */
    public Jour(final int an, int noJour) {
        this.annee = an;
        this.noJour = noJour;
    }

    @Override
    public final int hashCode() {
        int answer = HASH;
        answer = VALEUR * answer + this.annee;
        answer = VALEUR * answer + this.noJour;
        return answer;
    }

    /**
     *methode equals
     * @param obj
     * @return boolean
     */
    @Override
    public final boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jour other = (Jour) obj;
        return (this.annee == other.annee) && (this.noJour == other.noJour);
    }
   
}
