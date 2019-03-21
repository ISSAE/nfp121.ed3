import java.util.Observable;
/*---------------------------------------*/
class TemperatureModel extends Observable 
/*---------------------------------------*/
{
  public static int MAX_TEMP_F=250, MIN_TEMP_F=0;
  private int fahrenheit, celsius;
  
  public TemperatureModel() {
    this(0);
  }
  
  public TemperatureModel(int temp) {
    setTemperature(temp);
  }
  
  public void setTemperature(int f) 
    {
      //    System.out.println("TemperatureModel.setTemperature("+f+")");
      
      if(f > MAX_TEMP_F) f = MAX_TEMP_F;
      else if(f < MIN_TEMP_F) f = MIN_TEMP_F;
      
      fahrenheit = f;
      celsius = (int) ((double)(fahrenheit-32)*5/9);
      setChanged();
      notifyObservers();
    }
  
  public int F() { return fahrenheit; }
  
  public int C() { return celsius; }
  
  public int K() { return celsius+273; }
  
  public String toString() {
    return "TemperatureModel: provides current temp\n"+
      "in fahrenheit, celsius, or Kelvin.\n"+
	"Max temp = "+MAX_TEMP_F+"F; Min temp ="+MIN_TEMP_F+"F\n"+
	  "setTemperature(int) expects fahrenheit.\n";
  }
}
