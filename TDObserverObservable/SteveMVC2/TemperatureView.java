
import java.awt.*;
import java.util.*;
import javax.swing.JLabel;


/*------------------------------------------------------*/
class TemperatureView extends JLabel implements Observer 
/*------------------------------------------------------*/
{
  private Dimension preferredSize = new Dimension(350,20);
  
  public TemperatureView()
    {
      setText("Current temperature: click a controller");
      setForeground(Color.red);
    }

  public Dimension preferredSize(){ return preferredSize; }

  public void update(Observable ob, Object arg)
    {
      TemperatureModel model = (TemperatureModel)ob;

      setText("Current temperature: "+model.F()+"F,   "+
	      model.C()+"C,   "+model.K()+"K");
    }
}

