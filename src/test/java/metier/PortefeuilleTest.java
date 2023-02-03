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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;





/**
 *
 * @author David_C
 */
final class PortefeuilleTest {
    /**
     * 
     */
    private static final Jour TEST_J1 = new Jour(2014, 1);
    
    /**
     * Tests.
     */
     PortefeuilleTest() {   
     }
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
        ActionSimple france2;
        ActionSimple france3;

        // creation d'actions simples et composée
        france2 = new ActionSimple("France2");
        france3 = new ActionSimple("France3");
        france3.enrgCours(TEST_J1, 200);
        france2.enrgCours(TEST_J1, 100);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(france3, 10);
        p.acheter(france2, 20);

        float valeur = 4000;
        float res = p.valeur(TEST_J1);
        Assertions.assertEquals(res, valeur);
    }
     
     /**
      * test pour vérifier que la méthode acheter et la methode getActionsPortfeuillefonctionne 
      */
    @Test
    void testAcheterM() {
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");
        
        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        HashMap<Action, Integer> resultAttendu = new HashMap<>();
        resultAttendu.put(france2, 12);
        resultAttendu.put(france3, 10);
        resultAttendu.put(tf1, 5);

        Map<Action, Integer> result1 = portefeuille1.getActionsPortefeuille();

        Assertions.assertIterableEquals(resultAttendu.entrySet(), result1.entrySet(), "le resultat attendu difère du résultat réel");
    }

    /**
     * Test pour vérifier que la méthode vendre fonctionne quand on vends une quantité inférieure à la quantité existante
     */
    @Test
     void testVendreM() {

        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");
        
        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        portefeuille1.vendre(tf1, jour4, 2);
        portefeuille1.vendre(france2, jour4, 1);
                
        HashMap<Action, Integer> resultAttendu = new HashMap<>();
        resultAttendu.put(france2, 11);
        resultAttendu.put(france3, 10);
        resultAttendu.put(tf1, 3);

        Map<Action, Integer> result1 = portefeuille1.getActionsPortefeuille();

        Assertions.assertIterableEquals(resultAttendu.entrySet(), result1.entrySet(), "le resultat attendu difère du résultat réel");

    }
    
    /**
     * Test pour vérifier que la méthode vendre fonctionne quand on vends une quantité inférieure à la quantité existante
     */
    @Test
    void testVendreToutLaQtéDuneAction() {

        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");
        
        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        portefeuille1.vendre(tf1, jour4, 5);
                
        HashMap<Action, Integer> resultAttendu = new HashMap<>();
        resultAttendu.put(france2, 12);
        resultAttendu.put(france3, 10);


        Map<Action, Integer> result1 = portefeuille1.getActionsPortefeuille();

        Assertions.assertIterableEquals(resultAttendu.entrySet(), result1.entrySet(), "le resultat attendu difère du résultat réel");

    }
    
    /**
     * 
     */
    @Test
    void testVenteJour(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        ArrayList<Portefeuille.Vente> resultAttendu = new ArrayList();
        Portefeuille.Vente vente1 = new Portefeuille.Vente(tf1, jour2, 1);
        Portefeuille.Vente vente2 = new Portefeuille.Vente(france2, jour2, 3);
        Portefeuille.Vente vente3 = new Portefeuille.Vente(france2, jour2, 1);

        resultAttendu.add(vente3);
        resultAttendu.add(vente2);
        resultAttendu.add(vente1);
        
        portefeuille1.vendre(tf1, jour2, 1);
        portefeuille1.vendre(france2, jour2, 3);
        portefeuille1.vendre(france2, jour2, 1);
        List<Portefeuille.Vente> result1 = portefeuille1.venteJour(jour2);
        Assertions.assertTrue(resultAttendu.containsAll(result1));

    }
    
    /**
     * 
     */
    @Test
    void testVenteJourFaux(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        ArrayList<Portefeuille.Vente> resultAttendu = new ArrayList();
        Portefeuille.Vente vente2 = new Portefeuille.Vente(france2, jour2, 3);
        Portefeuille.Vente vente3 = new Portefeuille.Vente(france2, jour2, 1);

        resultAttendu.add(vente3);
        resultAttendu.add(vente2);
        
        portefeuille1.vendre(tf1, jour2, 1);
        portefeuille1.vendre(france2, jour2, 3);
        portefeuille1.vendre(france2, jour2, 1);
        List<Portefeuille.Vente> result1 = portefeuille1.venteJour(jour2);
        Assertions.assertTrue(result1.containsAll(resultAttendu));

    }
    
    /**
     * 
     */
    @Test 
    void testDerniereVentes(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        ArrayList<Portefeuille.Vente> resultAttendu = new ArrayList();
        Portefeuille.Vente vente1 = new Portefeuille.Vente(tf1, jour2, 1);
        Portefeuille.Vente vente2 = new Portefeuille.Vente(france2, jour2, 3);
        Portefeuille.Vente vente4 = new Portefeuille.Vente(france3, jour2, 5);

        resultAttendu.add(vente4);
        resultAttendu.add(vente2);
        resultAttendu.add(vente1);
        
        portefeuille1.vendre(tf1, jour2, 1);
        portefeuille1.vendre(france2, jour2, 3);
        portefeuille1.vendre(france2, jour2, 1);
        portefeuille1.vendre(france3, jour2, 5);
        
        List<Portefeuille.Vente> result1 = portefeuille1.derniereVentes();
        Assertions.assertFalse(resultAttendu.containsAll(result1));
    }
    
      @Test
    void testAcheterEtgetActionsPortefeuille() {
        //test pour vérifier que la méthode acheter et la methode getActionsPortfeuillefonctionne 
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");
        
        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        HashMap<Action, Integer> resultAttendu = new HashMap<>();
        resultAttendu.put(france2, 12);
        resultAttendu.put(france3, 10);
        resultAttendu.put(tf1, 5);

        Map<Action, Integer> result1 = portefeuille1.getActionsPortefeuille();

        Assertions.assertIterableEquals(resultAttendu.entrySet(), result1.entrySet(), "le resultat attendu difère du résultat réel");
    }


    
    public void testDerniereVentesFaux(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);

        ArrayList<Portefeuille.Vente> resultAttendu = new ArrayList();
        Portefeuille.Vente vente1 = new Portefeuille.Vente(tf1, jour2, 1);
        Portefeuille.Vente vente2 = new Portefeuille.Vente(france2, jour2, 3);
        Portefeuille.Vente vente3 = new Portefeuille.Vente(france2, jour2, 1);
        Portefeuille.Vente vente4 = new Portefeuille.Vente(france3, jour2, 5);

        resultAttendu.add(vente4);
        resultAttendu.add(vente2);
        
        
        portefeuille1.vendre(tf1, jour2, 1);
        portefeuille1.vendre(france2, jour2, 3);
        portefeuille1.vendre(france2, jour2, 1);
        portefeuille1.vendre(france3, jour2, 5);
        
        List<Portefeuille.Vente> result1 = portefeuille1.derniereVentes();
        Assertions.assertTrue(resultAttendu.containsAll(result1));

    }
    
    @Test
    public void testDernierAchats(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        Portefeuille.Achat achat1 = new Portefeuille.Achat(france2, jour1, 2);
        Portefeuille.Achat achat2 = new Portefeuille.Achat(france3, jour2, 5);
        Portefeuille.Achat achat3 = new Portefeuille.Achat(france2, jour2, 5);
        Portefeuille.Achat achat4 = new Portefeuille.Achat(tf1, jour3, 5);
        Portefeuille.Achat achat5 = new Portefeuille.Achat(france3, jour4, 5);
        Portefeuille.Achat achat6 = new Portefeuille.Achat(france2, jour4, 5);
        
        ArrayList<Portefeuille.Achat> resultAttendu = new ArrayList();

        resultAttendu.add(achat4);
        resultAttendu.add(achat5);
        resultAttendu.add(achat6);
              
        List<Portefeuille.Achat> result1 = portefeuille1.dernierAchats();
        Assertions.assertTrue(resultAttendu.containsAll(result1));

    }
    
    @Test
    public void testDernierAchatsFaux(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        Portefeuille.Achat achat1 = new Portefeuille.Achat(france2, jour1, 2);
        Portefeuille.Achat achat2 = new Portefeuille.Achat(france3, jour2, 5);
        Portefeuille.Achat achat3 = new Portefeuille.Achat(france2, jour2, 5);
        Portefeuille.Achat achat4 = new Portefeuille.Achat(tf1, jour3, 5);
        Portefeuille.Achat achat5 = new Portefeuille.Achat(france3, jour4, 5);
        Portefeuille.Achat achat6 = new Portefeuille.Achat(france2, jour4, 5);
        
        ArrayList<Portefeuille.Achat> resultAttendu = new ArrayList();

        resultAttendu.add(achat3);
        resultAttendu.add(achat5);
        resultAttendu.add(achat6);
              
        List<Portefeuille.Achat> result1 = portefeuille1.dernierAchats();
        Assertions.assertFalse(resultAttendu.containsAll(result1));

    }
    
    @Test
    public void testAchatJour(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        Portefeuille.Achat achat1 = new Portefeuille.Achat(france2, jour1, 2);
        Portefeuille.Achat achat2 = new Portefeuille.Achat(france3, jour2, 5);
        Portefeuille.Achat achat3 = new Portefeuille.Achat(france2, jour2, 5);
        Portefeuille.Achat achat4 = new Portefeuille.Achat(tf1, jour3, 5);
        Portefeuille.Achat achat5 = new Portefeuille.Achat(france3, jour4, 5);
        Portefeuille.Achat achat6 = new Portefeuille.Achat(france2, jour4, 5);
        
        ArrayList<Portefeuille.Achat> resultAttendu = new ArrayList();

        resultAttendu.add(achat5);
        resultAttendu.add(achat6);
              
        List<Portefeuille.Achat> result1 = portefeuille1.achatJour(jour4);
        Assertions.assertTrue(result1.containsAll(resultAttendu));

    }
    @Test
    public void testAchatJourFaux(){
        
        Portefeuille portefeuille1 = new Portefeuille();
        ActionSimple actionSimple = new ActionSimple("TF1");
        ActionSimple france2 = new ActionSimple("France2");
        ActionSimple france3 = new ActionSimple("France3");
        ActionSimple tf1 = new ActionSimple("TF1");

        Jour jour1 = new Jour(2023,01);
        Jour jour2 = new Jour(2023,02);
        Jour jour3 = new Jour(2023,15);
        Jour jour4 = new Jour(2023,30);

        portefeuille1.acheter(france2, jour1, 2);
        portefeuille1.acheter(france3, jour2, 5);
        portefeuille1.acheter(france2, jour2, 5);
        portefeuille1.acheter(tf1, jour3, 5);
        portefeuille1.acheter(france3, jour4, 5);
        portefeuille1.acheter(france2, jour4, 5);
        
        Portefeuille.Achat achat1 = new Portefeuille.Achat(france2, jour1, 2);
        Portefeuille.Achat achat2 = new Portefeuille.Achat(france3, jour2, 5);
        Portefeuille.Achat achat3 = new Portefeuille.Achat(france2, jour2, 5);
        Portefeuille.Achat achat4 = new Portefeuille.Achat(tf1, jour3, 5);
        Portefeuille.Achat achat5 = new Portefeuille.Achat(france3, jour4, 5);
        Portefeuille.Achat achat6 = new Portefeuille.Achat(france2, jour4, 5);
        
        ArrayList<Portefeuille.Achat> resultAttendu = new ArrayList();

        resultAttendu.add(achat4);
        resultAttendu.add(achat6);
              
        List<Portefeuille.Achat> result1 = portefeuille1.achatJour(jour4);
        Assertions.assertFalse(result1.containsAll(resultAttendu));
    }
    
    
}

