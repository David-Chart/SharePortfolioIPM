/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tp04.metier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author David_C
 */
public class ActionComposee extends Action {
    // attribut lien
    Map<ActionSimple, Float> mapPanier;

    
    /**
     * 
     * @param libelle 
     */
    public ActionComposee(String libelle) {
        super(libelle);
        this.mapPanier = new HashMap();
    }
    
    /**
     * 
     * @param as
     * @param pourcentage 
     */
    public void enrgComposition(ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    
    /**
     * 
     * @param j
     * @return 
     */
    @Override
    public float valeur(Jour j) {
        float valeur;
        
        valeur = 0;
        for(ActionSimple as : this.mapPanier.keySet()) {
            valeur = valeur + (as.valeur(j) * this.mapPanier.get(as));
        }
        return valeur;
    }    

  
    
    
}
