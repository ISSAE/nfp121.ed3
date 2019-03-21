
import java.awt.*;
import java.util.*;


/*------------------------------------------------------*/
class WaterModel extends Observable implements Observer
/*------------------------------------------------------*/
// NOTE: This model is an observer of a TemperatureModel but does not present
//       any representation of it so it not a view, even though it implements
//       Observer. Thus, not all Observers are views. 
{
  static final int SOLID = 32;
  static final int LIQUID = 211;
  static final int GAS = 212;
  
  private int state, degreesC, degreesF;  
  
  public WaterModel(int tempF) {
    System.out.println("--->Creating WaterModel");
    setState(tempF);
  }

  //Using private set accessors makes it easier to manage interaction with
  //observers. We can notify our observers when all updating is done (see update()).
  private void setState(int tempF) 
    {
      System.out.println("WaterModel.setState("+tempF+")");
      if(tempF <= SOLID)
	state = SOLID;
      else if(tempF <= LIQUID)
	state = LIQUID;
      else
	state = GAS;
    }
  
  public String state()
    {
      if(state == SOLID) return "ice";
      else if(state == LIQUID) return "water";
      else return "steam";
    }
  
  public int temperature(String scale) 
    {
      if(scale.equals("F")) return degreesF; 
      else return degreesC; 
      
    }
  
  public void update(Observable ob, Object arg)
    {	
      TemperatureModel temp = (TemperatureModel)ob;
      
      System.out.println("WaterModel.update("+temp.F()+")");
      
      degreesC = temp.C();
      degreesF = temp.F();
      setState(temp.F());
      //It is critical to call setChanged()/notifyObservers() after ALL updating has occurred.
      //Not doing so can lead to subtle bugs (as I found out %^).
      setChanged();
      notifyObservers();
    }

  public String toString() {
    return "WaterModel: reports physical state of\n"+
      "water textually and graphically.\n"+
      "Update occurs by observing a Temperature \nmodel.\n";
  }

} //end class WaterModel

