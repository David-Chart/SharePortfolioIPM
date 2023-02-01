/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp04.metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class Portefeuille {

    Map<Action, LignePortefeuille> mapLignes;

    private class LignePortefeuille {

        private Action action;

        private int qte;

        
        public int getQte() {
            return qte;
        }

        public void setQte(int qte) {
            this.qte = qte;
        }

        public Action getAction() {
            return this.action;
        }

        public LignePortefeuille(Action action, int qte) {
            this.action = action;
            this.qte = qte;
        }

        public String toString() {
            return Integer.toString(qte);
        }
    }

    public Portefeuille() {
        this.mapLignes = new HashMap();
    }

    /**
     * 
     * @param a
     * @param q 
     */
    public void acheter(Action a, int q) {
        if (this.mapLignes.containsKey(a) == false) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
    }

    /**
     * 
     * @param a
     * @param q
     * @return 
     */
    public HashMap<Action, Jour> vendre(Action a, int q) {
        Calendar c = Calendar. getInstance();
        Jour j = new Jour(c. get(Calendar. YEAR), c.get(Calendar. MONTH));
        HashMap<Action, Jour> jourVentesActions = new HashMap<>();
        if (this.mapLignes.containsKey(a) == true) {
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
     * 
     * @return 
     */
    public String toString() {
        return this.mapLignes.toString();
    }
    
    /**
     * 
     * @param j
     * @return 
     */
    public float valeurPortefeuille(Jour j) {
        float total = 0;
        for (LignePortefeuille lp : this.mapLignes.values()) {
            total += (lp.getQte() * lp.getAction().valeur(j));
        }
        return total;
    }
    
    /**
     * 
     * @param j
     * @return 
     */
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
    public HashMap<String, Float> listeActions(Jour j)
    {    
        HashMap<String, Float> listeActions = new HashMap<String, Float>();
        
        for (Action a : mapLignes.keySet()){
            listeActions.put(a.getLibelle(), valeurAction(j));
        }
        return listeActions;
    }
}
