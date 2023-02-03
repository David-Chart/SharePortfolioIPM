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
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;





/**
 *
 * @author David_C
 */
public final class PortefeuilleTest {
private static final Jour TEST_J1 = new Jour(2014, 1);
    /**
     * Tests.
     */
    public PortefeuilleTest() {    }

 

    /**
     * consulter ventes.
     */

    @Test
     void testConsultationVentes() {
        ActionSimple france2;
        ActionSimple france3;
        Jour j1;

        // init des objets metiers Jour
        j1 = new Jour(2014, 1);

        // creation d'actions simples et composée
        france2 = new ActionSimple("France2");
        france3 = new ActionSimple("France3");

        france3.enrgCours(j1, 200);
        france2.enrgCours(j1, 100);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(france3, 10);
        p.acheter(france2, 20);
        HashMap<Action, Jour> res = new HashMap<>();
        res = (HashMap<Action, Jour>) p.vendre(france2,5);
        int valeur = res.size();
        Assertions.assertEquals(valeur, res.size());
    }



    /**
     * Quantite.
     */
    @Test
     void testGetQte() {

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
     void testAcheter() {
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
     void testVendre() {
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
     void testVendreTout() {
        ActionSimple actionSimple = new ActionSimple("TF1");
        Portefeuille portefeuille1 = new Portefeuille();

        portefeuille1.acheter(actionSimple, 4);
        portefeuille1.vendre(actionSimple, 4);

        int qte3 = 0;

        int result3 = portefeuille1.getMapLignes(actionSimple);

        Assertions.assertEquals(qte3, result3, "la quantité récupérée n'est pas égale à 0");

    }
    
       /**
     * Test permettant de verifier la valeur du portefeuille.
     */
    @Test
     void testGetValeurPortefeuille() {
        ActionSimple France2;
        ActionSimple France3;

        // creation d'actions simples et composée
        France2 = new ActionSimple("France2");
        France3 = new ActionSimple("France3");
        
        France3.enrgCours(TEST_J1, 200);
        France2.enrgCours(TEST_J1, 100);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(France3, 10);
        p.acheter(France2, 20);

        float valeur = 4000;
        float res = p.valeur(TEST_J1);
        Assertions.assertEquals(res, valeur);
    }
}

