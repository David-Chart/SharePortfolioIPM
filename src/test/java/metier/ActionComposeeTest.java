/*
 * Copyright 2023 Laldja DJEDDOU.
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

import metier.ActionComposee;
import metier.ActionSimple;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author 
 */
public class ActionComposeeTest {
    
    public ActionComposeeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getMapPanier method, of class ActionComposee.
     */
    
    public static final ActionSimple ACTIONSIMPLE1_TEST = new ActionSimple("TF1");
    public static final ActionSimple ACTIONSIMPLE2_TEST = new ActionSimple("TFX");
    public static final ActionSimple ACTIONSIMPLE3_TEST = new ActionSimple("NT1");
    
    @Test
    public void testGetMapPanier() {
       
        Map<ActionSimple, Float> composition = new HashMap<ActionSimple, Float>();
        composition.put(ACTIONSIMPLE1_TEST, 0.33f);
        composition.put(ACTIONSIMPLE2_TEST, 0.33f);
        composition.put(ACTIONSIMPLE3_TEST, 0.34f);
        
        ActionComposee instance = new ActionComposee("FranceTV");
        instance.enrgComposition(ACTIONSIMPLE1_TEST, 0.33f);
        instance.enrgComposition(ACTIONSIMPLE2_TEST, 0.33f);
        instance.enrgComposition(ACTIONSIMPLE3_TEST, 0.34f);
        
        
        Map<ActionSimple, Float> result = instance.getMapPanier();
        assertEquals(composition, result, "The result must be the same as the one used at creation time.");
        // TODO review the generated test code and remove the default call to fail.
    }
}
