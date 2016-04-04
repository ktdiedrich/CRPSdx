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


import javax.swing.*;
import java.awt.*;

/** Input medical examiner observed signs. 
 * @author Karl T. Diedrich <ktdiedrich@gmail.com>
 * */
public class SignPanel extends Input implements Constants
{

    public SignPanel(Control control)
    {
        super(control, "Diagnose by signs for clinicians");
        build();
    }
    public void build()
    {
        // @todo get realistic prob. of sign given disease
        addMessage("Diagnose "+DISEASE+" by signs in Examination. Use a poputation probability of "+
                DISEASE_PROB);
        createColumnHeaders();
        addQuestion("Allodynia", 0.74, .1, 
                "Exagerated painful response to a normally non-painful stimuli such a touch.");
        addQuestion("Decreased range of motion", 0.70, .1,
                "Joint can't move as far.");
        addQuestion("Color changes", 0.66, .05, 
                "Skin may appear red or bluish.");
        addQuestion("Hyperalgesia", 0.63, .05, 
                "Extreme sensitivity to pain");
        addQuestion("Temperature assemetry", 0.56, .05,
                "The afected extremity is warmer or colder than the unafected extremity.");
        addQuestion("Edema", 0.56, .05, "Swelling");
        addQuestion("Weakness", 0.56, .05, "Less muscle stength.");
        addQuestion("Sweating changes", 0.24, .05, 
                "A increase or decrease of sweating in the affected extremity.");
        addQuestion("Skin changes", 0.20, .05, 
                "Skin codition such as dry skin or rashes arising after the onset of pain. ");
        addQuestion("Dystonia", 0.14, .05, 
                "Sustained muscle contractions casuing twisting, repetivie movements or abnormal posture.");
        addQuestion("Nail changes", 0.09, .05, 
                "Increased or decrease nail growth.");
        addQuestion("Hair changes", 0.09, .05,
                "Increased or decreased body hair growth.");
        addQuestion("Tremor", 0.09, .05, 
                "Shaking or twitching or affected muscles.");
        addQuestion("Female", 0.80, 0.5, "The pateint is a woman.");
        addDxButton();
    }

}
