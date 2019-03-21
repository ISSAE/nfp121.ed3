
import java.awt.*;
import java.util.*;


/*-----------------------------------------------------*/
class WaterView extends Canvas implements Observer 
/*-----------------------------------------------------*/
//NOTE: I was having difficulty initializing this view solely via its
//      update(Observable) method: it would always start off blank (no graphics shown)
//      even though update(Observable) was called. The problem was solved when
//      I provided a paint method and passed a WaterModel to the constructor.
//
//      This arrangement seems the most logical: paint() does all painting
//      and update(Observable) deals only with data. The only problem I have
//      with this scheme is that WaterView now has to mirror data in WaterModel,
//      effectively doubling the memory requirements of the model. This is not a
//      problem with only two ints, but could be for more complex models.
//      For complex models, it may be best to give them some view-like properties.
{
  private Dimension preferredSize = new Dimension(100,100);
  private Color col[] = new Color[7];
  private Color color;
  private int currentTemp;
  private String currentState;

  public WaterView(WaterModel wm)
    {
      System.out.println("--->Creating WaterView");
      currentTemp = wm.temperature("F");
      currentState = wm.state();
      initColors();
    }
  
  private void initColors() 
    {
      col[0] = Color.cyan;
      col[1] = Color.blue;
      col[2] = Color.green;
      col[3] = Color.yellow;
      col[4] = Color.orange;
      col[5] = Color.red;
      col[6] = Color.pink;
    }   
  
  private Color getColor(int temp) 
    {
      System.out.println("WaterView.getColor("+temp+")");
      
      if(temp <= 32) return col[0];
      else if(temp < 72) return col[1];
      else if(temp < 102) return col[2];
      else if(temp < 142) return col[3];
      else if(temp < 182) return col[4];
      else if(temp < 212) return col[5];
      else return col[6];
    }	
  
  public Dimension preferredSize(){ return preferredSize; }
  
  public void paint(Graphics g)
    {
      Dimension size = size();

      g.setColor( getColor(currentTemp));
      g.fillRect(1,1, size.width-2, size.height-2);
      g.setColor(Color.black);
      g.drawString(currentState, (int)(size.width/2)-15, (int)(size.height/2));
    }

  public void update(Observable ob, Object arg)
    {
      WaterModel water  = (WaterModel)ob;
      
      System.out.println("WaterView.update("+(water.temperature("F")+")"));

      currentTemp = water.temperature("F");
      currentState = water.state();
      repaint();
    }
}

