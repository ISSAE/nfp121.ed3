
//////////////////////////
// Controllers

/*-------------------------------------------------*/

import java.awt.*;
import java.util.*;





abstract class TemperatureController2 extends Canvas
/*-------------------------------------------------*/
// This is a base class for all temperature controllers.
{
  protected Dimension preferredSize;
  protected TemperatureModel tempModel;
  protected int maxTemp = TemperatureModel.MAX_TEMP_F;

  public TemperatureController2()
    {
      tempModel = new TemperatureModel();
      setForeground(Color.blue);
      setBackground(Color.yellow);
    }

  public Dimension preferredSize(){ return preferredSize; }

  public void addObserver(Observer obs)
    {
      tempModel.addObserver(obs);
      //Initialize the view. Caveat emptor: 
//      obs.update(tempModel,this); //This was causing problems for the Thermometer viewer
                                    // whose update(Obs) method requires a Graphics object.
                                    //Since addObserver() is called by its constructor, a 
                                    //NullPointerException resulted.
    }
  
  public TemperatureModel getModel() { return tempModel; }

  public void resetModel() 
    {
      tempModel.reset();
    }

  public abstract boolean mouseDown(Event evt, int x, int y);
  public abstract void paint(Graphics g);
    
}

/*----------------------------------------------------*/
class SwitchController extends TemperatureController2
/*----------------------------------------------------*/
//This controller is a low-tech button.
{
  public SwitchController()
    {
      preferredSize = new Dimension(300,40);
    }

  public void paint(Graphics g)
    {
      g.draw3DRect(0,0,size().width-1, size().height-1, true);
      g.drawString("Switch temperature (0-"+maxTemp+"F)", 35, 25);
    }

  public boolean mouseDown(Event evt, int x, int y)
    {
      getGraphics().draw3DRect(0,0,size().width-1, size().height-1, false);
      setForeground(Color.yellow);
      setBackground(Color.blue);
      tempModel.setTemperature((int)(Math.random()*maxTemp));
      return true;
    }

  public boolean mouseUp(Event evt, int x, int y)
    {
      getGraphics().draw3DRect(0,0,size().width-1, size().height-1, true);
      setForeground(Color.blue);
      setBackground(Color.yellow);
      return true;
    }
}

