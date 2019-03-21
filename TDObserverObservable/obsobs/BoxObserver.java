//: c10:BoxObserver.java
// Demonstration of Observer pattern using
// Java's built-in observer classes.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class BoxObserver extends JFrame {

  Observable notifier = new BoxObservable();
  
  public BoxObserver(int grid) {
    setTitle("Demonstrates Observer pattern");
    Container cp = getContentPane();
    cp.setLayout(new GridLayout(grid, grid));
    for(int x = 0; x < grid; x++)
      for(int y = 0; y < grid; y++)
        cp.add(new OCBox(x, y, notifier));
  }  
  
  
  public static void main(String[] args) {
    int grid = 16;
    if(args.length > 0)
      grid = Integer.parseInt(args[0]);
    JFrame f = new BoxObserver(grid);
    f.setSize(500, 400);
    f.setVisible(true);
    // JDK 1.3:
    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    // Add a WindowAdapter if you have JDK 1.2
  }
}
