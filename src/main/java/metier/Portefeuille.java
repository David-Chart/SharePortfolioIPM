/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {

    /**
     * Map comportant les actions et les lignes de portefeuilles.
     */
    private final Map<Action, LignePortefeuille> mapLignes;

    /**
     * Classe d'encapsulation LignePorteFeuille.
     */
    private class LignePortefeuille {

        /**
         * Declaration Attribut Action.
         */
        private final Action action;

         /**
         * Declaration Attribut quantite.
         */
        private int qte;

        /**
         * Getter de la quantite.
         * @return la quantite d'une ligne du portefeuille
         */
        public int getQte() {
            return qte;
        }

        /**
         * Setter de la quantite.
         * @param quantite
         */
        public void setQte(final int quantite) {
            this.qte = quantite;
        }

        /**
         * Getter d'une action.
         * @return une action
         */
        public Action getAction() {
            return this.action;
        }

        /**
         * Constructeur d'une ligne de portefeuille.
         * @param a
         * @param qte
         */
        LignePortefeuille(final Action a, int qte) {
            this.action = a;
            this.qte = qte;
        }

        @Override
        public String toString() {
            return Integer.toString(qte);
        }
    }

    /**
     * Constructeur du portefeuille.
     */
    public Portefeuille() {
        this.mapLignes = new HashMap<>();
    }

    /**
     * Methode qui permet d'acheter d'une action.
     * @param a
     * @param q
     */
    public final void acheter(final Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * Methode pour vendre une action qui retourne .
     * @param a
     * @param q
     * @return la liste des ventes avec son jour.
     */
    public final Map<Action, Jour> vendre(final Action a, int q) {
        Calendar c = Calendar.getInstance();
        Jour j = new Jour(c.get(Calendar.YEAR), c.get(Calendar.MONTH));
        Map<Action, Jour> jourVentesActions = new HashMap<>();
        if (this.mapLignes.containsKey(a)) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                jourVentesActions.put(a, j);
                this.mapLignes.remove(a);
            }
        }
        return jourVentesActions;
    }

    /**
     * Methode tostring de l'hashmap des actions de portefeuille.
     * @return  la liste des actions
     */
    @Override
    public final String toString() {
        return this.mapLignes.toString();
    }

    /**
     * Methode de valeur du portefeuille.
     * @param j
     * @return la valeur du portefeuille a un jour donnée
     */
    public final float valeurPortefeuille(final Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }

    /**
     * Methode de calcul de la valeur des actions pour un jour.
     * @param j
     * @return le valeur total
     */
    public final float valeurAction(final Jour j) {
        float totalAction = 0;
        for (Action a : this.mapLignes.keySet()) {
            totalAction += a.valeur(j);
        }
        return totalAction;
    }

    /**
     * Methode de consultation des actions.
     * @param j
     * @return la liste des actions avec leur nom et leur valeur
     */
    public final Map<String, Float> listeActions(final Jour j) {
        HashMap<String, Float> listeActions;
        listeActions = new HashMap<>();
        for (Action a : mapLignes.keySet()) {
            listeActions.put(a.getLibelle(), valeurAction(j));
        }
        return listeActions;
    }
}
