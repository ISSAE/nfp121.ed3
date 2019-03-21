//: c10:BoxObserver.java
// Demonstration of Observer pattern using
// Java's built-in observer classes.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



class OCBox extends JPanel implements Observer {
   Observable notifier;
   
   int x, y; // Locations in grid
   Color cColor = newColor();
   static final Color[] colors = { 
    Color.black, Color.blue, Color.cyan, 
    Color.darkGray, Color.gray, Color.green,
    Color.lightGray, Color.magenta, 
    Color.orange, Color.pink, Color.red, 
    Color.white, Color.yellow 
  };
  static final Color newColor() {
    return colors[
      (int)(Math.random() * colors.length)
    ];
  }
  
  OCBox(int x, int y, Observable notifier) {
    this.x = x;
    this.y = y;
    notifier.addObserver(this);
    this.notifier = notifier;
    addMouseListener(this.new ML());
  }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(cColor);
    Dimension s = getSize();
    g.fillRect(0, 0, s.width, s.height);
  }
  
  // classe interne
  class ML extends MouseAdapter {
    public void mousePressed(MouseEvent e) {
      notifier.notifyObservers(OCBox.this);
    }
  }
  //imposée par interface Observer
  public void update(Observable o, Object arg) {
    OCBox clicked = (OCBox)arg;
    if(nextTo(clicked)) {
      cColor = clicked.cColor;
      repaint();
    }
  }
  private final boolean nextTo(OCBox b) {
    return Math.abs(x - b.x) <= 1 && 
           Math.abs(y - b.y) <= 1;
  }
} ///:~