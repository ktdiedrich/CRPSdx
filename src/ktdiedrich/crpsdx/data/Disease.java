package ktdiedrich.crpsdx.data;

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


import java.util.List;
import java.util.ArrayList;

/** Disease being diagnosed.
 * @author Karl T. Diedrich <ktdiedrich@gmail.com> 
 * */
public class Disease
{
    protected String _disease;
    protected double _populationProb;
    protected List<Question> _dxQuestions;
    public Disease(String disease, double populationProb)
    {
        this();
        setDisease(disease);
        setPopulationProb(populationProb);
    }
    protected Disease()
    {
        _dxQuestions = new ArrayList<Question>();
    }
    public void addDxQuestion(Question question)
    {
        _dxQuestions.add(question);
    }
    public List<Question> getDxQuestions()
    {
        return _dxQuestions;
    }
    public double getPopulationProb()
    {
        return _populationProb;
    }
    public void setPopulationProb(double populationProb)
    {
        _populationProb = populationProb;
    }
    public String getDisease()
    {
        return _disease;
    }
    public void setDisease(String disease)
    {
        _disease = disease;
    }
    /** Calculate probability of disease based on the answers to the 
     * diagnostic questions using Multimembership Bayes for a single
     * disease probability calculation. */
    public double calcProb()
    {
        double probDisease = 0.0;
        double priorProb = getPopulationProb();
        for (Question q : _dxQuestions)
        {
            if (q.isYes())
            {
                probDisease = (priorProb * q.getProbGivenDisease()) / 
                (priorProb*q.getProbGivenDisease()+(1-priorProb)*
                        (q.getProbGivenNoDisease()));
                priorProb = probDisease;
            }
        }
        return probDisease;
    }
}
