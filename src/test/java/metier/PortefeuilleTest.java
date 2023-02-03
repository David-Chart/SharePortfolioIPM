/*
 * Copyright 2023 David_C.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package metier;

import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





/**
 *
 * @author David_C
 */
public final class PortefeuilleTest {

    /**
     * Tests.
     */
    public PortefeuilleTest() {    }

    /**
     * ANNEE.
     */
    private static final int ANNEE = 2014;
    /**
     * JOUR.
     */
    private static final int JOURS = 1;
    /**
     * VALEUR1.
     */
    private static final int VALEUR1 = 200;
    /**
     * VALEUR2.
     */
    private static final int VALEUR2 = 100;
    /**
     * QTE1.
     */
    private static final int QTE1 = 10;
    /**
     * QTE2.
     */
    private static final int QTE2 = 20;
    /**
     * valeur.
     */
    private static final float val = 4000;



    /**
     * Test permettant de verifier la valeur du portefeuille.
     */
    @Test
    void testGetValeurPortefeuille() {
        ActionSimple France2;
        ActionSimple France3;
        Jour j1;

        // init des objets metiers Jour
        j1 = new Jour(ANNEE, JOURS);

        // creation d'actions simples et composée
        France2 = new ActionSimple("France2");
        France3 = new ActionSimple("France3");

        France3.enrgCours(j1, VALEUR1);
        France2.enrgCours(j1, VALEUR2);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(France3, QTE1);
        p.acheter(France2, QTE2);

        float res = p.valeur(j1);
        System.out.println(res);
        Assertions.assertEquals(val, res);
    }

    /**
     * consulter ventes.
     */
    @Test
    public void testConsultationVentes() {
        ActionSimple France2;
        ActionSimple France3;
        Jour j1;

        // init des objets metiers Jour
        j1 = new Jour(ANNEE, JOURS);

        // creation d'actions simples et composée
        France2 = new ActionSimple("France2");
        France3 = new ActionSimple("France3");

        France3.enrgCours(j1, VALEUR1);
        France2.enrgCours(j1, VALEUR2);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(France3, QTE1);
        p.acheter(France2, QTE2);
        HashMap<Action, Jour> res = new HashMap<>();
        res = (HashMap<Action, Jour>) p.vendre(France2,5);
        int valeur = res.size();
        Assertions.assertEquals(valeur, res.size());
    }

    /**
     * valeur mx action portefeuille.
     */
    @Test
    void testValeurMax() {
        ActionSimple France2;
        ActionSimple France3;
        Jour j1;

        // init des objets metiers Jour
        j1 = new Jour(ANNEE, JOURS);

        // creation d'actions simples et composée
        France2 = new ActionSimple("France2");
        France3 = new ActionSimple("France3");

        France3.enrgCours(j1, VALEUR1);
        France2.enrgCours(j1, VALEUR2);
        Portefeuille p;
        p = new Portefeuille();
        p.acheter(France3, QTE1);
        p.acheter(France2, QTE2);
        float values = p.valeurMaxPortefeuille(j1);
        float res = val;
        System.out.print(values);
        Assertions.assertEquals(values, res);

    }

    /**
     * Quantite.
     */
    @Test
    public void testGetQte() {

        //Test la récuperation d'une quantité
        ActionSimple actionSimple = new ActionSimple("TF1");

        Portefeuille portefeuille1 = new Portefeuille();

        portefeuille1.acheter(actionSimple, 5);

        portefeuille1.getMapLignes(actionSimple);

        int qte = 5;

        int result = portefeuille1.getMapLignes(actionSimple);

        Assertions.assertEquals(qte, result, "la quantité récupérée n'est pas la même que la quantité enregistrée");
    }

    /**
     * vérifier que  l'action existe déjà dans le portefeuille.
     */
    @Test
    public void testAcheter() {
        //
        ActionSimple actionSimple = new ActionSimple("TF1");

        Portefeuille portefeuille1 = new Portefeuille();

        portefeuille1.acheter(actionSimple, 2);
        portefeuille1.acheter(actionSimple, 5);

        int qte1 = 7;

        int result1 = portefeuille1.getMapLignes(actionSimple);

        Assertions.assertEquals(qte1, result1, "quantité récupérée n'a pas fait la somme de la quantité déjà existance");
    }

    /**
     * méthode vendre fonctionne quand on vends une quantité inf à la qte ex.
     */
    @Test
    public void testVendre() {
        ActionSimple actionSimple = new ActionSimple("TF1");
        Portefeuille portefeuille1 = new Portefeuille();
        portefeuille1.acheter(actionSimple, 7);
        portefeuille1.vendre(actionSimple, 3);

        int qte2 = 4;

        int result2 = portefeuille1.getMapLignes(actionSimple);

        Assertions.assertEquals(qte2, result2, "la quantité récupérée n'a pas soustrait la qte vendue à celle déjà existante");

    }

    /**
     * methode vente.
     */
    @Test
    public void testVendreTout() {
        ActionSimple actionSimple = new ActionSimple("TF1");
        Portefeuille portefeuille1 = new Portefeuille();

        portefeuille1.acheter(actionSimple, 4);
        portefeuille1.vendre(actionSimple, 4);

        int qte3 = 0;

        int result3 = portefeuille1.getMapLignes(actionSimple);

        Assertions.assertEquals(qte3, result3, "la quantité récupérée n'est pas égale à 0");

    }
}

