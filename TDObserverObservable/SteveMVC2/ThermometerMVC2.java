/**
  Program:   ThermometerMVC2 applet
  Purpose:   To illustrate the model-view-controller paradigm in Java.
  @author    Steve A. Chervitz (sac@genome.stanford.edu)
             Adapted from David Geary's example in Java Report 2(1):31-37.
  @version   3 Mar 1997
             This is a more complicated example than ThermometerMVC1.
	     It has two views and two interacting controllers which inherit 
	     from a base class.
*/

import java.awt.*;
import java.util.*;


/*-----------------------------------------------------*/
public class ThermometerMVC2 extends java.applet.Applet 
/*-----------------------------------------------------*/
{
  //These two views 'view' the same model.
  private TemperatureView       tempView;
  private ThermometerView       thermView;

  //These two controllers control both views (but they don't have to.)
  private SwitchController     switchControl;
  private ThermostatController thermostatControl;

  public void init() 
    { 
      tempView          = new TemperatureView();
      thermView         = new ThermometerView();
      switchControl     = new SwitchController();
      thermostatControl = new ThermostatController();

      setFont(new Font("Helvetica",Font.BOLD, 16));
      setForeground(Color.black);
      add( new Label("ThermometerMVC2: Illustrating the Model-View-Controller in Java"));
      add( new Label("Two interacting controllers with shared views."));

      Panel p_model = new Panel();
      p_model.setLayout( new BorderLayout());
      p_model.add("North", new Label("Model"));
      TextArea ta = new TextArea(switchControl.getModel().toString(),5,40);
      ta.setFont( new Font("Helvetica",Font.PLAIN, 14));
      ta.setEditable( false);
      p_model.add("Center",ta);

      Panel p_view1 = new Panel();
      p_view1.setLayout( new BorderLayout());
      p_view1.add("North", new Label("View1"));
      p_view1.add("Center",tempView);

      Panel p_view2 = new Panel();
      p_view2.setLayout( new BorderLayout());
      p_view2.add("North", new Label("View2"));
      p_view2.add("Center",thermView);

      Panel p_controller1 = new Panel();
      p_controller1.setLayout( new BorderLayout());
      p_controller1.add("North", new Label("Controller1"));
      p_controller1.add("Center",switchControl);

      Panel p_controller2 = new Panel();
      p_controller2.setLayout( new BorderLayout());
      p_controller2.add("North", new Label("Controller2"));
      p_controller2.add("East",thermostatControl);

      add( p_model);
      add( p_view1);
      add( p_view2);
      add( p_controller1);
      add( p_controller2);

      switchControl.addObserver(tempView);
      switchControl.addObserver(thermView);
      thermostatControl.addObserver(tempView);
      thermostatControl.addObserver(thermView);
      //Link the two controllers: the thermostat should update as a result of switch events.
      switchControl.addObserver(thermostatControl); 
      switchControl.resetModel();  //To initialize the views.
    }
}


