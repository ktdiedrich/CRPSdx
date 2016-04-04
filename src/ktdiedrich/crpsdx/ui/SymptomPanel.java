package ktdiedrich.crpsdx.ui;

/*=========================================================================
*
*  Copyright (c) Karl T. Diedrich 
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*         http://www.apache.org/licenses/LICENSE-2.0.txt
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*
*=========================================================================*/


import java.awt.*;

import javax.swing.*;

/** Input Pateint described symptoms. 
 * @author Karl T. Diedrich <ktdiedrich@gmail.com> */
public class SymptomPanel extends Input
{

    public SymptomPanel(Control control)
    {
        super(control, "Diagnose by symptoms for patients");
        build();
    }
    public void build()
    {
        // @todo get realistic prob of symptom given no disease
        addMessage("Diagnose "+DISEASE+" by patient symptoms. Use a poputation probability of "+
                DISEASE_PROB);
        createColumnHeaders();
        addQuestion("Decreased range of motion", 0.80, .1,
                "Joint can't move as far.");
        addQuestion("Color changes", 0.87, .1,
                "Skin may appear red or bluish.");
        addQuestion("Temperature assemetry", 0.79, .1,
                "The afected extremity is warmer or colder than the unafected extremity.");
        addQuestion("Edema", 0.80, .1, "Swelling");
        addQuestion("Weakness", 0.75, .1,
                "Less muscle stength in the affected extremity.");
        addQuestion("Sweating changes", 0.53, .1,
                "A increase or decrease of sweating in the affected extremity.");
        addQuestion("Skin changes", 0.24, .05, 
                "Skin codition such as dry skin or rashes arising after the onset of pain. ");
        addQuestion("Dystonia", 0.20, .05, 
                "Sustained muscle contractions casuing twisting, repetivie movements or abnormal posture.");
        addQuestion("Nail changes", 0.21, .05, 
                "Shaking or twitching or affected muscles.");
        addQuestion("Hair changes", 0.19, .05,
                "Increased or decreased body hair growth.");
        addQuestion("Tremor", 0.24, .05,
                "Shaking or twitching or affected muscles.");
        addQuestion("Hyperesthesia", 0.65, .1, "Extreme sensitivity to pain");
        addQuestion("Burning pain", 0.81, .1, "Pain described as burning.");
        addQuestion("Female", 0.80, 0.5, "The patient is a woman.");
        addDxButton();
    }
}
