/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package tp04.metier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author David_C
 */
public class ActionSimpleTest {
    
    public ActionSimpleTest() {
    }

    @org.junit.jupiter.api.Test
    public void testSomeMethod() {
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
}
