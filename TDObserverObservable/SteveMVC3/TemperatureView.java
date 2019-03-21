
import java.awt.*;
import java.util.*;


//////////////////////////
// Views
// Issue: How to initialize a view when it is does not directly know
//        about its model(s)?
//        -- For the Temperature view, the controller must initialize it.
//        -- For the Water view, its constructor is passed a reference to a model.
//        -- Alternatively, we could just give the view a reference to its model.
//        Doing so violates the spirit of the observer/observable mechanism where 
//        the observer decides at runtime the model being updated. 
//        Also, since controllers (which contain the models) work 
//        closely with views, there's really no need.

/*-----------------------------------------------------*/
class TemperatureView extends Label implements Observer 
/*-----------------------------------------------------*/
{
  private Dimension preferredSize = new Dimension(350,50);

  public TemperatureView()
    {
      System.out.println("--->Creating TemperatureView");
      setText("Current temperature: ");
      setForeground(Color.red);
    }

  public Dimension preferredSize(){ return preferredSize; }

  public void update(Observable ob, Object arg)
    {
      TemperatureModel temp = (TemperatureModel)ob;
      
      System.out.println("TemperatureView.update("+temp.F()+")\n");
      
      setText("Current temperature: "+temp.F()+"F,   "+
	      temp.C()+"C,   "+temp.K()+"K");
    }
}
