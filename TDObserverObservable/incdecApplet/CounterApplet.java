//************
//Elif Tosun
//
//CounterApplet --Applet with MVC
//
//**************

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class CounterApplet extends Frame
implements ActionListener, CounterObserver{

    Button incButton, decButton;
    TextField valField;
    Counter ctr;

    public CounterApplet() {
        init();
        setVisible(true);
    }
    //*********
    //init
    //
    //**********

    public void init()
    {

        setBackground(Color.white);

        incButton = new Button("+");
        decButton = new Button("-");
        valField = new TextField();

        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add(incButton, "North");
        p.add(valField,"Center");
        p.add(decButton, "South");

        add(p);
      

        incButton.addActionListener(this);
        decButton.addActionListener(this);

        ctr = new Counter(10);
        ctr.registerAsObserver(this);

    }
    //**********
    //actionPerformed
    //
    //***********

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == incButton)
            ctr.inc();
        else
            ctr.dec();

    }

    //***********
    //counterHasChanged
    //
    //***********

    public void counterHasChanged (Counter ctr)
    {

        valField.setText(Integer.toString(ctr.getVal()));

    }

}
