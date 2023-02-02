/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {

    /**
     * Map stockant les ligne du portefeuille.
     */
    private final Map<Action, LignePortefeuille> mapLignes;

    /**
     * Sous objet ligne portefeuille.
     */
    private class LignePortefeuille {

        /**
         * Attribut action.
         */
        private final Action action;
        /**
         * Attribut qté.
         */
        private int qte;

        /**
         * getteur of quantité.
         *
         * @return la quantité
         */
        public int getQte() {
            return qte;
        }

        /**
         * Setteur of qté.
         */
        public void setQte(final int qte) {
            this.qte = qte;
        }

        /**
         * Getter of Action.
         *
         * @return Action
         */
        public Action getAction() {
            return this.action;
        }

        /**
         * Constructor.
         */
        LignePortefeuille(final Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        @Override
        public String toString() {
            return Integer.toString(qte);
        }
    }

    /**
     * Constructor.
     */
    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    /**
     * Methode for buying action in portefeuille.
     *
     * @param a
     * @param q
     */
    public final void acheter(Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * @param a
     * @param q
     * @return une hashmap des actions vendues
     */
    public HashMap<Action, Jour> vendre(Action a, int q) {
        Calendar c = Calendar.getInstance();
        Jour j = new Jour(c.get(Calendar.YEAR), c.get(Calendar.MONTH));
        HashMap<Action, Jour> jourVentesActions = new HashMap<>();
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

    @Override
    public String toString() {
        return this.mapLignes.toString();
    }

    /**
     * Methode to calculate tha value of portfeuille.
     *
     * @param j
     * @return the value
     */
    public float valeur(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total = total + (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }

    public float valeurAction(Jour j) {
        float totalAction = 0;
        for (Action a : this.mapLignes.keySet()) {
            totalAction += a.valeur(j);
        }
        return totalAction;
    }

    /**
     *
     * @param j
     * @return
     */
    public HashMap<String, Float> listeActions(Jour j) {
        HashMap<String, Float> listeActions = new HashMap<String, Float>();

        for (Action a : mapLignes.keySet()) {
            listeActions.put(a.getLibelle(), valeurAction(j));
        }
        return listeActions;
    }


    
    public int getMapLignes(Action a) {
        if (this.mapLignes.containsKey(a)) {
            return this.mapLignes.get(a).getQte();
        } else {
            return 0;
        }
    }
}
