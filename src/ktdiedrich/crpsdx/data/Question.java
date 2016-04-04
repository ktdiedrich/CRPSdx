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


/** Diagnostic question
 * @author Karl T. Diedrich <ktdiedrich@gmail.com> */
public class Question
{
    protected String _question;
    protected double _probGivenDisease;
    protected double _probGivenNoDisease;
    protected boolean _isYes;
    
    public Question(String question, double probGivenDisease,
            double probGivenNoDisease)
    {
        setQuestion(_question);
        setProbGivenDisease(probGivenDisease);
        setYes(false);
        setProbGivenNoDisease(probGivenNoDisease);
    }
    
    public double getProbGivenDisease()
    {
        return _probGivenDisease;
    }
    public void setProbGivenDisease(double probGivenDisease)
    {
        _probGivenDisease = probGivenDisease;
    }
    public String getQuestion()
    {
        return _question;
    }
    public void setQuestion(String question)
    {
        _question = question;
    }

    public boolean isYes()
    {
        return _isYes;
    }

    public void setYes(boolean isYes)
    {
        _isYes = isYes;
    }

    public double getProbGivenNoDisease()
    {
        return _probGivenNoDisease;
    }

    public void setProbGivenNoDisease(double probGivenNoDisease)
    {
        _probGivenNoDisease = probGivenNoDisease;
    }
}
