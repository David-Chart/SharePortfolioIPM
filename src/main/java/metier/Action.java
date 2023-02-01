/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.util.Objects;

/**
 *
 * @author David_C
 */
public abstract class Action {

    /**
     * declaration de l'attribut libelle.
     */
    private final String libelle;

    /**
     * Get the value of libelle.
     *
     * @return the value of libelle
     */
    public final String getLibelle() {
        return libelle;
    }

    /**
     * Constructeur d'action.
     * @param libelleA
     */
    public Action(final String libelleA) {
        this.libelle = libelleA;
    }

    /**
     * @param j
     * @return valeur de l'action en fonction d'un jour
     */
    public abstract float valeur(Jour j);

    /**
     * @return hascode du libelle d'une action
     */
    @Override
    public final int hashCode() {
        return Objects.hashCode(this.libelle);
    }

   /**
    * @param obj
    * @return equals du libelle de l'action
    */
    @Override
    public final boolean equals(final Object obj) {
      if (this == obj) {
          return true;
      }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Action action;
        action = (Action) obj;
        return Objects.equals(libelle, action.libelle);
    }
    /**
     *
     * @return le libelle d'une action
     */
    @Override
    public final String toString() {
        return this.getLibelle();
    }
}
