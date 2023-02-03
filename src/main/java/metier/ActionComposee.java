/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author perussel
 */
public class ActionComposee extends Action {

    /**
     * attribut lien.
     */
    private final Map<ActionSimple, Float> mapPanier;

    /**
     * Constructeur ActionComposee.
     * @param libelle
     */
    public ActionComposee(final String libelle) {
        super(libelle);
        this.mapPanier = new HashMap<>();
    }

    /**
     * Methode permet l'ajout d'action simple dans une action composée.
     * @param as
     * @param pourcentage
     */
    public final void enrgCompo(final ActionSimple as, float pourcentage) {
        this.mapPanier.put(as, pourcentage);
    }

    /**
     * valeur de l'action composée.
     * @param j
     * @return valeur
     */
    @Override
    public final float valeur(Jour j) {
        float valeur;
        valeur = 0;
        for (Map.Entry<ActionSimple, Float> entry : mapPanier.entrySet()) {
            valeur = valeur + (entry.getKey().valeur(j) * entry.getValue());
        }
        return valeur;
    }

    /**
     * Cette méthode permet de connaitre la composition d'une action composée.
     * @return La méthode retourne une hashMap qui stock toute les actions. qui
     * composent l'action composée et les pourcentages
     */
    public final Map<ActionSimple, Float> getMapPanier() {
        return this.mapPanier;
    }

    /**
     * Cette méthode retourne le pourcentage d'une action simpla composant une
     * action composée.
     * @param as
     * @return le pourcentage.
     */
    public final float pourcentageActionSimple(final ActionSimple as) {
        return this.mapPanier.get(as);
    }
}
