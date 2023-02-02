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
    public PortefeuilleTest() {
        testGetValeurPortefeuille();
    }

    /**
     * Test permettant de verifier la valeur du portefeuille.
     */
    @Test
    void testGetValeurPortefeuille() {
        ActionSimple France2;
        ActionSimple France3;
        Jour j1;

        // init des objets metiers Jour
        j1 = new Jour(2014, 1);

        // creation d'actions simples et composée
        France2 = new ActionSimple("France2");
        France3 = new ActionSimple("France3");

        France3.enrgCours(j1, 200);
        France2.enrgCours(j1, 100);

        Portefeuille p;
        p = new Portefeuille();
        p.acheter(France3, 10);
        p.acheter(France2, 20);

        float valeur = 4000;
        float res = p.valeur(j1);
        Assertions.assertEquals(res, valeur);

    }

}
