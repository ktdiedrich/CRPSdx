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
import java.util.List;
import java.util.ArrayList;

/** Launches the stand alone CRPSdx Application  
 * @author Karl T. Diedrich <ktdiedrich@gmail.com> 
 * */
public class CRPSdxMain extends JFrame implements Constants, UIConstants
{
    protected Control _control;
    protected Container _contentPane;
    protected List<Input> _inputs;
    protected JTabbedPane _inputTabs;
    public CRPSdxMain() throws HeadlessException
    {
        this(TITLE);
    }

    public CRPSdxMain(String title) throws HeadlessException
    {
        super(title);
        _control = new Control( this );
        SwingUtilities.invokeLater( new Runnable()
        {
            public void run()
            {
                build();
            }
        } );
    }
    protected void addInput(Input input)
    {
        _inputs.add(input);
        _inputTabs.addTab(input.getTitle(), input);
    }
    protected void build()
    {
        setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        _contentPane = getContentPane();
        _inputTabs = new JTabbedPane();
        _inputs = new ArrayList<Input>(2);
        addInput(new SignPanel(_control));
        addInput(new SymptomPanel(_control));
        
        _contentPane.add(_inputTabs, BorderLayout.CENTER);
        
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        CRPSdxMain main = new CRPSdxMain();
        main.setVisible(true);
    }

}
