import java.awt.*;
import java.util.*;

/*-----------------------------------------------------*/
class TemperatureView extends Label implements Observer 
/*-----------------------------------------------------*/
{
  private Dimension preferredSize = new Dimension(350,20);
  
  public TemperatureView()
    {
      setText("Current temperature: ");
      setForeground(Color.red);
    }
  
  public Dimension preferredSize(){ return preferredSize; }
  
  public void update(Observable ob, Object arg)
    {
      TemperatureModel temp = (TemperatureModel)ob;
      
      setText("Current temperature: "+temp.F()+"F,   "+
	      temp.C()+"C,   "+temp.K()+"K");
    }
}
