/**
  Program:   ThermometerMVC3 applet
  Purpose:   To illustrate the model-view-controller paradigm in Java.
  @author    Steve A. Chervitz (sac@genome.stanford.edu)
             Adapted from David Geary's example in Java Report 2(1):31-37.
  @version   3 Mar 1997
             This is a more complicated example than ThermometerMVC1.
	     It has two interacting models, each with its own independent view. 
	     A controller affects only one of the models (Temperature).
*/

import java.awt.*;
import java.util.*;


/*----------------------------------------------------*/
public class ThermometerMVC3 extends java.applet.Applet 
/*----------------------------------------------------*/
{
  private TemperatureView        tempView;
  private TemperatureController1 tempController;
  private WaterView              waterView;
  private WaterModel       	waterModel;
  private Panel                      p_mvW, p_mvT;
  
  public void init() 
    { 
      tempView           = new TemperatureView();
      tempController   = new TemperatureController1();
      waterModel        = new WaterModel(tempController.getModel().F());
      waterView          = new WaterView(waterModel);
	
      setFont(new Font("Helvetica",Font.BOLD, 16));
      setForeground(Color.black);
      add( new Label("ThermometerMVC2: Illustrating the Model-View-Controller in Java"));
      add( new Label("Two interacting models with independent views."));

      Panel p_modelT = new Panel();
      p_modelT.add( new Label("Model 1: Temperature"));
      TextArea ta_t = new TextArea(tempController.getModel().toString(),5,35);
      ta_t.setFont( new Font("Helvetica",Font.PLAIN, 14));
      ta_t.setEditable( false);
      p_modelT.add(ta_t);


      Panel p_viewT = new Panel();
      p_viewT.setLayout( new BorderLayout());
      p_viewT.add("North", new Label("Temperature View"));
      p_viewT.add("Center",tempView);

      p_mvT = new Panel();
      p_mvT.setLayout( new BorderLayout());
      p_mvT.add("North", p_modelT);
      p_mvT.add("Center", p_viewT);

      Panel p_modelW = new Panel();
      p_modelW.add( new Label("Model 2: Water"));
      TextArea ta_w = new TextArea(waterModel.toString(),5,35);
      ta_w.setFont( new Font("Helvetica",Font.PLAIN, 14));
      ta_w.setEditable( false);
      p_modelW.add(ta_w);

      Panel p_viewW = new Panel();
      p_viewW.setLayout( new BorderLayout());
      p_viewW.add("North", new Label("Water View"));
      p_viewW.add("Center",waterView);

      p_mvW = new Panel();
      p_mvW.setLayout( new BorderLayout());
      p_mvW.add("North", p_modelW);
      p_mvW.add("Center", p_viewW);

      Panel p_controller = new Panel();
      p_controller.setLayout( new BorderLayout());
      p_controller.add("North", new Label("Controller"));
      p_controller.add("Center",tempController);

      add( p_mvT);
      add( p_mvW);
      add( p_controller);

      waterModel.addObserver( waterView);   // waterView observes only waterModel.

      //tempController will call the observer's update() method.
      tempController.addObserver(tempView);
      tempController.addObserver(waterModel); //waterModel is an observer of temperatureModel
      
    }

  public void paint(Graphics g)
    {
      //Draw rect around the Temperature model + view.
      g.draw3DRect(p_mvT.location().x-1 ,p_mvT.location().y-1, 
		   p_mvT.size().width+1, p_mvT.size().height+1, false);
      
      //Draw rect around the Water model + view.
      g.draw3DRect(p_mvW.location().x-1 ,p_mvW.location().y-1, 
		   p_mvW.size().width+1, p_mvW.size().height+1, false);
      
    }

} //end class ThermometerMVC3








