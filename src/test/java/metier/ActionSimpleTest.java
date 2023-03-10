package metier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author David_C
 */
public class ActionSimpleTest {

    /**
     * ActionSimple.
     */
    public static final ActionSimple ACTIONS_TEST = new ActionSimple("TF1");
    /**
     * j.
     */
    private final Jour j = new Jour(2023, 1);
    /**
     * c.
     */
    private final float c = 20.0f;
    /**
     * j1.
     */
    private final Jour j1 = new Jour(2023, 3);
    /**
     * c1.
     */
    private final float c1 = 30.0f;

    /**
     * constructor.
     */
    public ActionSimpleTest() {
    }

    /**
     * testValeur.
     */
    @Test
    final void testValeur() {
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
    final void testEnregistrerCours() {
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
    final void testValeur2() {
        Jour jour2 = new Jour(2023, 16);

        float valeur2 = 0;

        ActionSimple actionSimple2 = new ActionSimple("France 2");

        float result2 = actionSimple2.valeur(jour2);

        Assertions.assertEquals(valeur2, result2, "La valeur récupérée n'est pas nulle");
    }

    /**
     * Tester la méthode getLibelle pour connaitre le libelle d'une action.
     */
    @Test
    final void testGetLibelle() {
        ActionSimple actionsimple3 = new ActionSimple("France 3");

        String libelle = "France 3";

        String result3 = actionsimple3.getLibelle();

        Assertions.assertEquals(libelle, result3, "Le libellé récupéré n'est pas le même ");
    }

    /**
     * valeur max du portefeuille.
     */
    @Test
    final void testValeurMax() {
        ActionSimple france2;
        Jour jour1;

        // init des objets metiers Jour
        jour1 = new Jour(2022, 31);

        // creation d'actions simples
        france2 = new ActionSimple("France2");
        france2.enrgCours(jour1, 200);
        france2.enrgCours(jour1, 100);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(france2, 10);
        p.acheter(france2, 30);

        float val = france2.valeurMaxActionSimple();
        float res = 200;

        Assertions.assertEquals(val, res, "Erreur ! valeur max non calculé");

    }
}
