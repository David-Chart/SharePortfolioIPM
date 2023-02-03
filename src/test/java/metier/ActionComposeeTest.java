/*
 * Copyright 2023 Moham.
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
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActionComposeeTest {

    /**
     * Test of getMapPanier method, of class ActionComposee.
     */
    /**
     * ACTIONSIMPLE1.
     */
    public static final ActionSimple ACTIONSIMPLE1 = new ActionSimple("TF1");
    /**
     * ACTIONSIMPLE2.
     */
    public static final ActionSimple ACTIONSIMPLE2 = new ActionSimple("TFX");
    /**
     * ACTIONSIMPLE1.
     */
    public static final ActionSimple ACTIONSIMPLE3 = new ActionSimple("NT1");

    @Test
    /**
     *
     */
    void testGetMapPanier() {
        Map<ActionSimple, Float> composition;
        composition = new HashMap<ActionSimple, Float>();

        composition.put(ACTIONSIMPLE1, 0.33f);
        composition.put(ACTIONSIMPLE2, 0.33f);
        composition.put(ACTIONSIMPLE3, 0.34f);

        ActionComposee instance = new ActionComposee("FranceTV");
        instance.enrgCompo(ACTIONSIMPLE1, 0.33f);
        instance.enrgCompo(ACTIONSIMPLE2, 0.33f);
        instance.enrgCompo(ACTIONSIMPLE3, 0.34f);

        Map<ActionSimple, Float> result = instance.getMapPanier();
        Assertions.assertEquals(composition, result, "The result must be the same as the one used at creation time.");
    }

    /**
     * test of value méthode.
     */
    @Test
    final void testValeurVraie() {

        float expRes = 0.34f;
        ActionComposee instance = new ActionComposee("FranceTV");
        instance.enrgCompo(ACTIONSIMPLE1, 0.33f);
        instance.enrgCompo(ACTIONSIMPLE2, 0.33f);
        instance.enrgCompo(ACTIONSIMPLE3, 0.34f);
        float res = instance.pourcentageActionSimple(ACTIONSIMPLE3);

        Assertions.assertEquals(expRes, res, "The result must be the same as the one used at creation time.");
    }
}
