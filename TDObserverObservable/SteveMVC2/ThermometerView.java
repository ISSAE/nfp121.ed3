

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.*;
import javax.swing.JPanel;

//////////////////////////
// Views
/*------------------------------------------------------*/
class ThermometerView extends JPanel implements Observer /*------------------------------------------------------*/ {

    private Dimension preferredSize = new Dimension(20, 100);

    private Color fillColor;

    public ThermometerView() {
        setBackground(Color.white);
        fillColor = Color.red;
        
    }

    public Dimension preferredSize() {
        return preferredSize;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
    }

    public void update(Observable ob, Object arg) {
        TemperatureModel model = (TemperatureModel) ob;
        int temp = model.F();
        Graphics g = getGraphics();
        if (g==null) return;
        Dimension size = getSize();
        int fillHeight = (int) (size.height * ((double) temp / TemperatureModel.MAX_TEMP_F) - 1);

        g.clearRect(1, 1, size.width - 2, size.height - 2);
        g.setColor(fillColor);
        g.fillRect(1, size.height - fillHeight - 1, size.width - 2, fillHeight);
    }
}
