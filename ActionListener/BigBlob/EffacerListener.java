import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.JOptionPane;
/**
 * Décrivez votre classe EffacerListener ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class EffacerListener implements ActionListener
{
   MultGUI bbg;
   public EffacerListener(MultGUI bbg) {
       this.bbg=bbg;
       System.out.println("EffacerListener" + bbg);
    }
   public void actionPerformed(ActionEvent e) {
        System.out.println("EffacerListener" + bbg);
        bbg.m_userInputTf.setText("");
        bbg.m_totalTf.setText("");
       
     }
}
