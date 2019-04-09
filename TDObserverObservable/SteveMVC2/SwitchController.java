
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*----------------------------------------------------*/
class SwitchController extends TemperatureController2 {

    public SwitchController() {
        preferredSize = new Dimension(300, 40);
    }

    public void paintComponent(Graphics g) {
        g.draw3DRect(0, 0, getSize().width - 1, getSize().height - 1, true);
        g.drawString("Switch temperature (0-" + maxTemp + "F)", 35, 25);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        getGraphics().draw3DRect(0, 0, getSize().width - 1, getSize().height - 1, false);
        setForeground(Color.yellow);
        setBackground(Color.blue);
        tempModel.setTemperature((int) (Math.random() * maxTemp));
         repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        getGraphics().draw3DRect(0, 0, getSize().width - 1, getSize().height - 1, true);
        setForeground(Color.blue);
        setBackground(Color.yellow);
         repaint();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }
    
    //

    
    
}
