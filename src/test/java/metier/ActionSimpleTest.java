package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David_C
 */
public class ActionSimpleTest {
    /**
     * ANNEE.
     */
    private static final int ANNEE = 2023;
    /**
     * JOUR.
     */
    private static final int JOURS = 15;
    /**
     * jours.
     */
    private static final int JOURS1 = 1;
    Jour j = new Jour(2023,1);
    float c = 20.0f;
    Jour j1 = new Jour(2023,3);
    float c1 = 30.0f;
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
    private static final float VAL = 4000;
        /**
     * ActionSimple.
     */
    public static final ActionSimple  ACTIONS_TEST = new ActionSimple("TF1");

    /**
     * C.
     */
    private static final float C = 20.0f;

    /**
     * c1.
     */
    private static final float C1 = 30.0f;

    /**
     * constructeur.
     */
    public ActionSimpleTest() { }

    /**
     * testValeur.
     */
    @Test
    public final void testValeur(){
    ACTIONS_TEST.enrgCours(j, c);
    ACTIONS_TEST.enrgCours(j1, c1);
    float res = ACTIONS_TEST.valeur(j);
    float expRes = c;
    Assertions.assertEquals(expRes, res, "The result must be the same as the one used at creation time.");
    }

    /**
     * Tester la méthode enregistrer un cours.
     */
    @Test
    public final void testEnregistrerCours() {
        Jour jour1 = new Jour(2023, 15);

         float valeur1 = 50;

        ActionSimple actionSimple1 = new ActionSimple("TF1");

        actionSimple1.enrgCours(jour1, valeur1);

        float result = actionSimple1.valeur(jour1);
        System.out.print(valeur1);
                System.out.print(result);

        Assertions.assertEquals(valeur1, result, "La valeur récupérée ne corresponds pas à la valeur ");
    }

    /**
     * Teste.r la méthode valeur pour connaitre la valeur d'une action.
     */
    @Test
    public final void testValeur2() {
        Jour jour2 = new Jour(ANNEE, JOURS);

        float valeur2 = 0;

        ActionSimple actionSimple2 = new ActionSimple("France 2");

        float result2 = actionSimple2.valeur(jour2);

        Assertions.assertEquals(valeur2, result2, "La valeur récupérée n'est pas nulle");

    }

    /**
     * Tester la méthode getLibelle pour connaitre le libelle d'une action.
     */
    @Test
    public final void testGetLibelle() {
        ActionSimple actionsimple3 = new ActionSimple("France 3");

        String libelle = "France 3";

        String result3 = actionsimple3.getLibelle();

        Assertions.assertEquals(libelle, result3, "Le libellé récupéré n'est pas le même ");
    }
}
