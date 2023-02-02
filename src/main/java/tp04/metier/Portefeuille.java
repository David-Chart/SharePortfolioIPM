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
public class Portefeuille {
    /**
     * Map stockant les ligne du portefeuille.
     */
    private Map<Action, LignePortefeuille> mapLignes;
    /**
     * Sous objet ligne portefeuille.
     */
    private class LignePortefeuille {
       /**
        * Attribut action.
        */
       private Action action;
       /**
        * Attribut qté.
        */
       private int qte;
       /**
        * getteur of quantité.
        * @return la quantité
        */
       public int getQte() {
            return qte;
        }
        /**
         * Setteur of qté.
         */
        public void setQte(int qte) {
            this.qte = qte;
        }

        /**
         * Getter of Action.
         * @return Action
         */
        public Action getAction() {
            return this.action;
        }
        /**
         * Constructor.
         */
        public LignePortefeuille(Action action, int qte) {
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
     * @param a
     * @param q
     */
    public void acheter(Action a, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * Mehtode for selling actions in portefeuille.
     * @param a
     * @param q
     */
    public void vendre(Action a, int q) {
        if (this.mapLignes.containsKey(a)) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
        }
    }

    @Override
    public String toString() {
        return this.mapLignes.toString();
    }

    /**
     * Methode to calculate tha value of portfeuille.
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
}
