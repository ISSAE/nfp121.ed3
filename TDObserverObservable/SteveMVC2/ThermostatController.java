
import java.awt.*;
import java.util.*;

/*---------------------------------------------------------------------------*/
class ThermostatController extends TemperatureController2 implements Observer 
/*---------------------------------------------------------------------------*/
//This controller has a GUI which needs to be updated if the switchController
//gets pressed. This is accomplished by having this object add itself as an
//observer to the temperature model. Because of this, the mouseDown handler simply calls
//setTemperature() on the model and the model then updates this controller's GUI.
{
  boolean update = false;
  int     barHeight;

  public ThermostatController() 
    {
      preferredSize = new Dimension(20,100);
      addObserver( this); //Allows controller to update its GUI as a result of its own changes.
    }

  public void paint(Graphics g)
    {
      Dimension size = size();

      g.drawRect(0,0,size.width-1, size.height-1);
    }

  public boolean mouseDown(Event evt, int x, int y)
    {
      int newTemp = (int)(maxTemp*(size().height-y)/size().height);
            
      tempModel.setTemperature(newTemp);

      return true;
    }

  public boolean mouseDrag(Event evt, int x, int y)
    {
      int newTemp = (int)(maxTemp*(size().height-y)/size().height);
            
      tempModel.setTemperature(newTemp);

      return true;
    }

  public void update(Observable ob, Object arg)
    {
      TemperatureModel model = (TemperatureModel)ob;

      Graphics  g    = getGraphics();
      Dimension size = size();
      int       temp = model.F();
      barHeight = (int)(size.height*((double)temp/TemperatureModel.MAX_TEMP_F)-1);
	
//      System.out.println("ThermstatController.update("+temp+")");
      g.clearRect(1,1, size.width-2, size.height-2);
      g.drawLine(1, size.height-barHeight, size.width-2, size.height-barHeight);
    }
}

