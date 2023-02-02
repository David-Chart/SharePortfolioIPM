/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionSimple extends Action {

    // attribut lien
    private Map<Jour, Cours> mapCours;

    /**
     * Constructor.
     * @param libelle
     */
    public ActionSimple(String libelle) {
        // Action simple initialisée comme 1 action
        super(libelle);
        // init spécifique
        this.mapCours = new HashMap();
    }

    /**
     * enrg possible si pas de cours pour ce jour.
     * @param j
     * @param v
     */
    public void enrgCours(Jour j, float v) {
        if (!this.mapCours.containsKey(j)) {
            this.mapCours.put(j, new Cours(j, v));
        }
    }

    @Override
    public float valeur(Jour j) {
        if (this.mapCours.containsKey(j)) {
            return this.mapCours.get(j).getValeur();
        } else {
            return 0;
        }
    }

    /**
     * encapsulation de la définition de la classe Cours.
     */
    private class Cours {
        /**
         * attribut Jour jour.
         */
        private Jour jour;
        /**
         * Atribut valeur.
         */
        private float valeur;
        /**
         * Getter of valeur.
         * @return valeur
         */
        public float getValeur() {
            return valeur;
        }
        /**
         * Getter jour.
         * @return Jour jour
         */
        public Jour getJour() {
            return jour;
        }
        /**
         * Constructor.
         * @param jour
         * @param valeur
         */
        public Cours(Jour jour, float valeur) {
            this.jour = jour;
            this.valeur = valeur;
        }

    }
}
