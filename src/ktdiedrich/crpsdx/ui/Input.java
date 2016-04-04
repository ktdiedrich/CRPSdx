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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ktdiedrich.crpsdx.data.*;
import java.util.List;
import java.util.ArrayList;

/** Common interface for input.
 * @author Karl T. Diedrich <ktdiedrich@gmail.com> */
public class Input extends JPanel implements Constants
{
    protected GridBagLayout _layout;
    protected GridBagConstraints _constraints;
    protected Control _control;
    protected CRPSdxMain _main;
    protected int _y;
    protected String _title;
    protected Disease _disease;
    protected int _questionNumber;
    protected double _calcDiseaseProb;
    protected JTextField _probOut;
    protected JTextField _fractionOfGivenText;
    protected List<JTextField> _probGivenDiseaseTexts;
    protected List<JTextField> _probGivenNoDiseaseTexts;
    protected JTextField _conditions;
    
    protected Input(Control control, String title)
    {
        _control = control;
        _title = title;
        _disease = new Disease(DISEASE, DISEASE_PROB);
        _layout = new GridBagLayout();
        setLayout(_layout);
        _constraints = new GridBagConstraints();
        _constraints.fill = GridBagConstraints.BOTH;
        _constraints.weightx = 1.0;
        _constraints.weighty = 0.0;
        _y = 0;
        _constraints.gridx = 0;
        _constraints.gridy = _y;
        _questionNumber = 0;
        _calcDiseaseProb = 0.0;
        _probGivenDiseaseTexts = new ArrayList<JTextField>();
        _probGivenNoDiseaseTexts = new ArrayList<JTextField>();
    }
    private void assignCurrentProbToQuestions()
    {
        List<Question> dxQuestions = _disease.getDxQuestions();
        assert dxQuestions.size() == _probGivenDiseaseTexts.size();
        assert dxQuestions.size() == _probGivenNoDiseaseTexts.size();
        int k = 0;
        for (Question q: dxQuestions)
        {
            q.setProbGivenDisease(Double.parseDouble(_probGivenDiseaseTexts.get(k).getText()));
            q.setProbGivenNoDisease(Double.parseDouble(_probGivenNoDiseaseTexts.get(k).getText()));
            k++;
        }
    }
    protected void addDxButton()
    {
        _y++;
        _constraints.gridy = _y;
        _constraints.gridx = 1;
        
        JLabel label = new JLabel("Conditions Present");
        _layout.setConstraints(label, _constraints);
        add(label);
        
        _conditions = new JTextField();
        _conditions.setEditable(false);
        _conditions.setBackground(Color.lightGray);
        _constraints.gridx++;
        _layout.setConstraints(_conditions, _constraints);
        add(_conditions);
        
        _y++;
        _constraints.gridy = _y++;
        _constraints.gridx = 0;
        JButton dxButton = new JButton("Diagnose disease probability");
        dxButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                assignCurrentProbToQuestions();
                _calcDiseaseProb = _disease.calcProb();
                _probOut.setText(_calcDiseaseProb+"");
            }
        });
        int width = 2;
        _constraints.gridwidth = width;
        _layout.setConstraints(dxButton, _constraints);
        add(dxButton);
        
        _probOut = new JTextField();
        _constraints.gridx+=width;
        _constraints.gridwidth = GridBagConstraints.REMAINDER;
        _probOut.setEditable(false);
        _probOut.setBackground(Color.lightGray);
        _probOut.setToolTipText("Calculated probability of disease "+
                DISEASE);
        _layout.setConstraints(_probOut, _constraints);
        add(_probOut);
        _constraints.gridx = 0;
    }
    
    private void updateGivenNoDisease()
    {
        assert _probGivenNoDiseaseTexts.size() == _probGivenDiseaseTexts.size();
        int k = 0;
        for (JTextField t : _probGivenNoDiseaseTexts)
        {
            double probGivenDisease = Double.parseDouble(
                    _probGivenDiseaseTexts.get(k).getText());
            double fraction = Double.parseDouble(_fractionOfGivenText.getText());
            double newProbGivenNoDisease = fraction*probGivenDisease;
            t.setText(newProbGivenNoDisease+"");
            k++;
        }
    }
    
    protected void createColumnHeaders()
    {
        String condition = "Condition";
        String conditionTip ="The name of the condition";
        String present = "Present?";
        String presentTip = "The condition is present or absent, No or Yes?";
        String givenDisease = "Probability given "+DISEASE_ABBR;
        String diseaseTip = 
        	"Probability of the condition to the left given the patient has the disease";
        String givenNoDisease = "Probability given no "+DISEASE_ABBR;
        String noDiseaseTip = 
        	"Probability of the condition to the left given the patient does not have the disease";
        createColumnHeaders(condition, conditionTip, present, presentTip, givenDisease, diseaseTip,
                givenNoDisease, noDiseaseTip);
    }
    
    protected void createColumnHeaders(String condition, String conditionTip,
            String present, String presentTip, String givenDisease, String diseaseTip,
            String givenNoDisease, String noDiseaseTip)
    {
        _y++;
        _constraints.gridy = _y;
        _constraints.gridwidth = 1;
        _constraints.gridx = 0;
        
        // @todo more description
        JLabel label = new JLabel("Faction of probability given disease");
        label.setToolTipText("Set the Probability of the condition given no disease to a "+
        		"fraction of the probability of the sign given the disease.");
        _constraints.gridx++;
        _layout.setConstraints(label, _constraints);
        add(label);
        
        _fractionOfGivenText = new JTextField();
        _constraints.gridx++;
        _layout.setConstraints(_fractionOfGivenText, _constraints);
        add(_fractionOfGivenText);
        
        JButton button = new JButton("Update "+givenNoDisease);
        button.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               updateGivenNoDisease();
           }
        });
        _constraints.gridx++;
        _layout.setConstraints(button, _constraints);
        add(button);
        
        
        _y++;
        _constraints.gridy = _y;
        _constraints.gridx = 0;
        
        label = new JLabel("No.");
        _layout.setConstraints(label, _constraints);
        add(label);
        
        label = new JLabel(condition);
        label.setToolTipText(conditionTip);
        _constraints.gridx++;
        _layout.setConstraints(label, _constraints);
        add(label);
        
        label = new JLabel(present);
        label.setToolTipText(presentTip);
        _constraints.gridx++;
        _layout.setConstraints(label, _constraints);
        add(label);
        
        label = new JLabel(givenDisease);
        label.setToolTipText(diseaseTip);
        _constraints.gridx++;
        _layout.setConstraints(label, _constraints);
        add(label);
        
        label = new JLabel(givenNoDisease);
        label.setToolTipText(noDiseaseTip);
        _constraints.gridx++;
        _layout.setConstraints(label, _constraints);
        add(label);
        
    }
    protected void addMessage(String message)
    {
        JLabel label = new JLabel(message);
        _constraints.gridwidth = GridBagConstraints.REMAINDER;
        _layout.setConstraints(label, _constraints);
        add(label);
        _constraints.gridwidth = 1;
    }
    protected void addQuestion(String question, 
            double probGivenDisease, double probGivenNoDisease, String description)
    {
        Question dxQuestion = new Question(question, 
                probGivenDisease,
                probGivenNoDisease);
        _disease.addDxQuestion(dxQuestion);
        _constraints.gridwidth = 1;
        _constraints.gridx = 0;
        _y++;
        _constraints.gridy = _y;
        
        JLabel questionNumber = new JLabel((_questionNumber+1)+"");
        _layout.setConstraints(questionNumber, _constraints);
        _constraints.weightx = 0.0;
        add(questionNumber);
        
        JLabel q = new JLabel(question);
        q.setToolTipText(description);
        _constraints.gridx++;
        _layout.setConstraints(q, _constraints);
        add(q);
        
        ButtonGroup bg = new ButtonGroup();
        JRadioButton no = new JRadioButton("No");
        no.addActionListener(new YesNoAction(_questionNumber, false));
        
        JRadioButton yes = new JRadioButton("Yes");
        yes.addActionListener(new YesNoAction(_questionNumber, true));
        
        bg.add(no);
        bg.add(yes);
        no.setSelected(true);
        JPanel select = new JPanel();
        select.setLayout(new BoxLayout(select, BoxLayout.LINE_AXIS));
        select.add(no);
        select.add(yes);
        _constraints.gridx++;
        _layout.setConstraints(select, _constraints);
        add(select);
        
        JTextField probGivenDiseaseText = new JTextField();
        _probGivenDiseaseTexts.add(probGivenDiseaseText);
        probGivenDiseaseText.setText(dxQuestion.getProbGivenDisease()+"");
        _constraints.gridx++;
        _layout.setConstraints(probGivenDiseaseText, _constraints);
        add(probGivenDiseaseText);
        
        JTextField probGivenNoDiseaseText = new JTextField();
        _probGivenNoDiseaseTexts.add(probGivenNoDiseaseText);
        probGivenNoDiseaseText.setText(dxQuestion.getProbGivenNoDisease()+"");
        _constraints.gridx++;
        _layout.setConstraints(probGivenNoDiseaseText, _constraints);
        add(probGivenNoDiseaseText);
        
        _questionNumber++;
        _constraints.gridx = 0;
    }
    public String getTitle()
    {
        return _title;
    }
    private class YesNoAction implements ActionListener
    {
        protected int _qNum;
        protected boolean _yes;
        public YesNoAction(int qNum, boolean yes)
        {
            _qNum = qNum;
            _yes = yes;
        }
        public void actionPerformed(ActionEvent e)
        {
            _disease.getDxQuestions().get(_qNum).setYes(_yes);
            
            List<Question> dxQuestions = _disease.getDxQuestions();
            int cnt = 0;
            for (Question q : dxQuestions)
            {
                if (q.isYes())
                {
                    cnt++;
                }
            }
            _conditions.setText(cnt+"");
        }
    }
}
