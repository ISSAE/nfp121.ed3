
import java.awt.*;
import java.util.*;

//////////////////////////
// Views


/*------------------------------------------------------*/
class ThermometerView extends Canvas implements Observer 
/*------------------------------------------------------*/
{
  private Dimension preferredSize = new Dimension(20,100);

  private Color fillColor;

  public ThermometerView()
    {
      setBackground(Color.white);
      fillColor = Color.red;
    }

  public Dimension preferredSize(){ return preferredSize; }

  public void paint(Graphics g)
    {
      g.drawRect(0,0,size().width-1, size().height-1);
    }

  public void update(Observable ob, Object arg)
    {
      TemperatureModel model = (TemperatureModel)ob;
      int       temp       = model.F();
      Graphics  g          = getGraphics();
      Dimension size       = size();
      int       fillHeight = (int)(size.height*((double)temp/TemperatureModel.MAX_TEMP_F)-1);

      g.clearRect(1,1, size.width-2, size.height-2);
      g.setColor(fillColor);
      g.fillRect(1, size.height-fillHeight-1, size.width-2, fillHeight);
    }
}

