
//////////////////////////
// Controllers

/*-------------------------------------------------*/
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import javax.swing.JPanel;

abstract class TemperatureController2 extends JPanel implements MouseListener,MouseMotionListener /*-------------------------------------------------*/ // This is a base class for all temperature controllers.
{

    protected Dimension preferredSize;
    protected TemperatureModel tempModel;
    protected int maxTemp = TemperatureModel.MAX_TEMP_F;

    public TemperatureController2() {
        tempModel = new TemperatureModel();
        setForeground(Color.blue);
        setBackground(Color.yellow);
    }

    public Dimension preferredSize() {
        return preferredSize;
    }

    public void addObserver(Observer obs) {
        tempModel.addObserver(obs);
        //Initialize the view. Caveat emptor: 
//      obs.update(tempModel,this); //This was causing problems for the Thermometer viewer
        // whose update(Obs) method requires a Graphics object.
        //Since addObserver() is called by its constructor, a 
        //NullPointerException resulted.
    }

    public TemperatureModel getModel() {
        return tempModel;
    }

    public void resetModel() {
        tempModel.reset();
    }

    //Les listener qui ne nous intereserons pas dans notre implémentation
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }


    @Override
    public void mouseMoved(MouseEvent e) {
       
    }

}

