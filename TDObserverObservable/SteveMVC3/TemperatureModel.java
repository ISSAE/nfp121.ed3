
import java.awt.*;
import java.util.*;

//////////////////////////
// Models

/*---------------------------------------*/
class TemperatureModel extends Observable 
/*---------------------------------------*/
{
  public static int MAX_TEMP_F=250, MIN_TEMP_F=0;
  private int fahrenheit, celcius;
  
  public TemperatureModel() {
    this(0);
  }
  
  public TemperatureModel(int temp) {
    System.out.println("--->Creating TemperatureModel");
    setTemperature(temp);
  }
  
  public void setTemperature(int f) 
    {
      System.out.println("TemperatureModel.setTemperature("+f+")");
      
      if(f > MAX_TEMP_F) f = MAX_TEMP_F;
      else if(f < MIN_TEMP_F) f = MIN_TEMP_F;
      
      fahrenheit = f;
      celcius = (int) ((double)(fahrenheit-32)*5/9);
      setChanged();
      notifyObservers();
    }
  
  public int F() { return fahrenheit; }
  
  public int C() { return celcius; }
  
  public int K() { return celcius+273; }
  
  public String toString() {
    return "TemperatureModel: provides current temp\n"+
      "in fahrenheit, celcius, or Kelvin.\n"+
      "Max temp = "+MAX_TEMP_F+"F; Min temp ="+MIN_TEMP_F+"F\n"+
      "setTemperature(int) expects fahrenheit.\n";
  }

} //end class TemperatureModel


