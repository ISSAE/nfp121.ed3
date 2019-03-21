//****************8
//Elif Tosun
//
//Counter Class
//****************

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Counter
{
private int max, val = 0;
CounterObserver observer;

public Counter(int max)
{
this.max = max;
}

public void reset()
{
val = 0;
}


public int getVal()
{
return val;
}

public void setVal(int val)
{
if (val >= 0 && val <= max)
	this.val = val;
notifyObserver();

}

public void inc()
{
if (val<max)  val++;
notifyObserver();
}

public void dec()
{
if (val>0) val--;
notifyObserver();
}


public void registerAsObserver(CounterObserver observer)
{
this.observer = observer;
notifyObserver();

}

private void notifyObserver()
{
observer.counterHasChanged(this);
}



}
