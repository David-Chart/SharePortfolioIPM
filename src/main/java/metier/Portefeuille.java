/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

/**
 *
 * @author perussel
 */
public class Portefeuille {
        /**
     * Map stockant les ventes.
     */
    private Map<Long, Vente> ventes;
    /**
     * Map stockant les achats.
     */
    private Map<Long, Achat> achats;
    /**
     * Sous objet ligne portefeuille.

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
         * @param quantite
         * Setteur of qté.
         */
        public void setQte(final int quantite) {
            this.qte = quantite;
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
         * @param actions
         * @param qte
         */
        public LignePortefeuille(final Action actions, int qte) {
            this.action = actions;
            this.qte = qte;
        }

        @Override
        public String toString() {
            return Integer.toString(qte);
        }
    }
    
        /**
     * Intern class vente.
     */
    public static class Vente {
        /**
        * Attribut action.
        */
       private final Action action;
       /**
        * Attribut Jour.
        */
       private Jour jour;
       /**
        * Attribut qté.
        */
       private int qte;

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 37 * hash + Objects.hashCode(this.action);
            hash = 37 * hash + Objects.hashCode(this.jour);
            hash = 37 * hash + this.qte;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Vente other = (Vente) obj;
            if (this.qte != other.qte) {
                return false;
            }
            if (!Objects.equals(this.action, other.action)) {
                return false;
            }
            return Objects.equals(this.jour, other.jour);
        }
       
       
       /**
        * getteur of quantité.
        * @return la quantité
        */
       public int getQte() {
            return qte;
        }
        /**
         * Setteur of qté.
         * @param qte
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
         * Getter of Jour
         * @return 
         */
        public Jour getJour(){
            return this.jour;
        }
        
        /**
         * Setter of Jour
         * @param jour
         */
        public void setJour(Jour jour){
            this.jour = jour;
        }
        /**
         * Constructor.
         * @param action
         * @param jour
         * @param qte
         */
        public Vente(Action action, Jour jour, int qte) {
            this.action = action;
            this.jour = jour;
            this.qte = qte;
        }

        @Override
        public String toString() {
            return "Vente{" + "action=" + action + ", jour=" + jour + ", qte=" + qte + '}';
        }
        

    }
    
      /**
     * Intern class Achat.
     */
    public static class Achat {
        /**
        * Attribut Action.
        */
       private final Action action;
       /**
        * Attribut Jour.
        */
       private Jour jour;
       /**
        * Attribut qté.
        */
       private int qte;

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 97 * hash + Objects.hashCode(this.action);
            hash = 97 * hash + Objects.hashCode(this.jour);
            hash = 97 * hash + this.qte;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Achat other = (Achat) obj;
            if (this.qte != other.qte) {
                return false;
            }
            if (!Objects.equals(this.action, other.action)) {
                return false;
            }
            return Objects.equals(this.jour, other.jour);
        }
       
       
       /**
        * getteur of quantité.
        * @return la quantité
        */
       public int getQte() {
            return qte;
        }
        /**
         * Setteur of qté.
         * @param qte
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
         * Getter of Jour
         * @return 
         */
        public Jour getJour(){
            return this.jour;
        }
        
        /**
         * Setter of Jour
         * @param jour
         */
        public void setJour(Jour jour){
            this.jour = jour;
        }
        
        /**
         * Constructor.
         * @param action
         * @param jour
         * @param qte
         */
        public Achat(Action action, Jour jour, int qte) {
            this.action = action;
            this.jour = jour;
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
        this.mapLignes = new HashMap<>();
        this.ventes = new HashMap<>();
        this.achats = new HashMap<>();
    }
    
    
    /**
     * Methode qui retourne les actions et la qté dans un portefeuille
     * @return 
     */
    public Map<Action, Integer> getActionsPortefeuille(){
        HashMap<Action, Integer> resultat = new HashMap<>();
        for(Entry<Action,LignePortefeuille> a : this.mapLignes.entrySet()){
            resultat.put(a.getKey(), a.getValue().getQte());
        }
        return resultat;
    }
    
      /**
     * Methode qui retourne les achats à un jour donnée.
     */
    public List<Achat> achatJour(Jour jour) {
        ArrayList<Achat> res = new ArrayList<>();
        for (Entry<Long,Achat> map : this.achats.entrySet() ){
            if (map.getValue().getJour().equals(jour)) {
                res.add(map.getValue());
            }
        }
        return res;
    }
    
    
    /**
     * Methode qui retourne les vente à un jour donnée.
     */
    public List<Vente> venteJour(Jour jour) {

        ArrayList<Vente> res = new ArrayList<>();

        for (Entry<Long,Vente> map : this.ventes.entrySet() ){
            if (map.getValue().getJour().equals(jour)) {
                res.add(map.getValue());
                
            }
        }
        return res;
    }
    
    
      /**
     * Methode for buying action in portefeuille.
     * @param a
     * @param q
     */
    public void acheter(Action a, Jour jour, int q) {
        if (!this.mapLignes.containsKey(a)) {
            this.mapLignes.put(a, new LignePortefeuille(a, q));
        } else {
            this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() + q);
        }
        this.achats.put(System.nanoTime(), new Achat (a,jour,q));
    }
    
    
        /**
     * Methode qui retourne les trois derniere ventes.
     * @return
     */
    public List<Vente> derniereVentes(){
       int count = 0;
       Map<Long, Vente> sortedMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
       ArrayList<Vente> res = new ArrayList<>();
       sortedMap.putAll(this.ventes);
       for (Entry<Long,Vente> v : sortedMap.entrySet()) {
           if (count >= 3) {
                break;
            }
           System.out.println(v.getValue());
           res.add(v.getValue());
           count++;
       }
       return res; 
   }
    
   /**
     * Methode qui retourne les trois dernier achats.
     * @return
     */
    public List<Achat> dernierAchats(){
       int count = 0;
       Map<Long, Achat> sortedMap = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
       ArrayList<Achat> res = new ArrayList<>();
       sortedMap.putAll(this.achats);
       for (Entry<Long, Achat> a : sortedMap.entrySet()) {
           if (count >= 3) {
                break;
            }
           res.add(a.getValue());
           count++;
       }
       return res;
   }

       /**
     * Methode for buying action in portefeuille.
     *
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
     * Mehtode for selling actions in portefeuille.
     * @param a
     * @param jour
     * @param q
     */
    public void vendre(Action a, Jour jour, int q) {
        if (this.mapLignes.containsKey(a)) {
            if (this.mapLignes.get(a).getQte() > q) {
                this.mapLignes.get(a).setQte(this.mapLignes.get(a).getQte() - q);
            } else if (this.mapLignes.get(a).getQte() == q) {
                this.mapLignes.remove(a);
            }
            this.ventes.put(System.nanoTime(), new Vente (a,jour,q));
        }
    }
    
    /**
     * @param a
     * @param q
     * @return une hashmap des actions vendues
     */
    public final Map<Action, Jour> vendre(final Action a, int q) {
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

    /**
     *
     * @return hashmap
     */
    @Override
    public final String toString() {
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

    /**
     * methode qui retourne la valeur total des actions du portefeuille.
     * @param j
     * @return valeur total
     */
    public final float valeurAction(final Jour j) {
        float totalAction = 0;
        for (Action a : this.mapLignes.keySet()) {
            totalAction += a.valeur(j);
        }
        return totalAction;
    }

    /**
     *
     * @param j
     * @return liste des actions
     */
    public final Map<String, Float> listeActions(final Jour j) {
        HashMap<String, Float> listeActions = new HashMap<>();

        for (Action a : mapLignes.keySet()) {
            listeActions.put(a.getLibelle(), valeurAction(j));
        }
        return listeActions;
    }


    /**
     * @param a
     * @return Hashmap
     */
    public final int getMapLignes(final Action a) {
        if (this.mapLignes.containsKey(a)) {
            return this.mapLignes.get(a).getQte();
        } else {
            return 0;
        }
    }

    public Map<Long, Vente> getVentes() {
        return ventes;
    }

    public void setVentes(Map<Long, Vente> ventes) {
        this.ventes = ventes;
    }

    public Map<Long, Achat> getAchats() {
        return achats;
    }

    public void setAchats(Map<Long, Achat> achats) {
        this.achats = achats;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.ventes);
        hash = 67 * hash + Objects.hashCode(this.achats);
        hash = 67 * hash + Objects.hashCode(this.mapLignes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Portefeuille other = (Portefeuille) obj;
        if (!Objects.equals(this.ventes, other.ventes)) {
            return false;
        }
        if (!Objects.equals(this.achats, other.achats)) {
            return false;
        }
        return Objects.equals(this.mapLignes, other.mapLignes);
    }

    
}
