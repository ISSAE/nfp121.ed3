/**
  Program:   ThermometerMVC1 applet
  Purpose:   To illustrate the model-view-controller paradigm in Java.
  @author    Steve A. Chervitz (sac@genome.stanford.edu)
             Adapted from David Geary's example in Java Report 2(1):31-37.
  @version   3 Mar 1997
             This example encapsulates a minimal model, view and a controller
             to illustrate and experiment with the basics. 
*/

import java.awt.*;
import java.util.*;


/*----------------------------------------------------*/
public class ThermometerMVC1 extends Frame 
/*----------------------------------------------------*/
{
  private TemperatureView        tempView;
  private TemperatureController1 tempController;

  public ThermometerMVC1() {
      init();
      setVisible(true);
    }
  
  public void init() 
    { 
      tempView       = new TemperatureView();
      tempController = new TemperatureController1();

      setFont(new Font("Helvetica",Font.BOLD, 16));
      setForeground(Color.black);
      add( new Label("ThermometerMVC1: Illustrating the Model-View-Controller in Java"));

      Panel p_model = new Panel();
      p_model.setLayout( new BorderLayout());
      p_model.add("North", new Label("Model"));
      TextArea ta = new TextArea(tempController.getModel().toString(),5,40);
      ta.setFont( new Font("Helvetica",Font.PLAIN, 14));
      ta.setEditable( false);
      p_model.add("Center",ta);

      Panel p_view = new Panel();
      p_view.setLayout( new BorderLayout());
      p_view.add("North", new Label("View"));
      p_view.add("Center",tempView);

      Panel p_controller = new Panel();
      p_controller.setLayout( new BorderLayout());
      p_controller.add("North", new Label("Controller"));
      p_controller.add("Center",tempController);
      setLayout(new FlowLayout());
      add( p_model);
      add( p_view);
      add( p_controller);
      
      tempController.addObserver(tempView);
    }
}


