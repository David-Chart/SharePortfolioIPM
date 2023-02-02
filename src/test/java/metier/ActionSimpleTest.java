/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David_C
 */
public class ActionSimpleTest {
    
    public ActionSimpleTest() {
    }

    
    public static final ActionSimple ACTIONSIMPLE1_TEST = new ActionSimple("TF1");
    Jour j = new Jour(2023,1);
    float c = 20.0f;
    Jour j1 = new Jour(2023,3);
    float c1 = 30.0f;
    
    @Test
    public void testValeur(){
    ACTIONSIMPLE1_TEST.enrgCours(j,c);
    ACTIONSIMPLE1_TEST.enrgCours(j1,c1);
    
    float res = ACTIONSIMPLE1_TEST.valeur(j);
    float expRes = c;
    
    assertEquals(expRes, res, "The result must be the same as the one used at creation time.");
    
    }
    
    
      @org.junit.jupiter.api.Test
    public void testSomeMethod() {

        //Tester la méthode enregistrer un cours
        Jour jour1 = new Jour(2023, 15);

        float valeur1 = 50;

        ActionSimple actionSimple1 = new ActionSimple("TF1");

        actionSimple1.enrgCours(jour1, valeur1);

        float result = actionSimple1.valeur(jour1);

        Assertions.assertEquals(valeur1, result, "La valeur récupérée ne corresponds pas à la valeur ");
    }

    public void testValeur2() {
        // Tester la méthode valeur pour connaitre la valeur d'une action
        Jour jour2 = new Jour(2023, 16);

        float valeur2 = 0;

        ActionSimple actionSimple2 = new ActionSimple("France 2");

        float result2 = actionSimple2.valeur(jour2);

        Assertions.assertEquals(valeur2, result2, "La valeur récupérée n'est pas nulle");

    }

    public void testGetLibelle() {
        //Tester la méthode getLibelle pour connaitre le libelle d'une action
        ActionSimple actionsimple3 = new ActionSimple("France 3");

        String libelle = "France 3";

        String result3 = actionsimple3.getLibelle();

        Assertions.assertEquals(libelle, result3, "Le libellé récupéré n'est pas le même ");

    }


    
    
}
