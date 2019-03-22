import java.awt.event.*;
import java.math.BigInteger;
import javax.swing.JOptionPane;
/**
 * Décrivez votre classe MultiplicationListener ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MultiplicationListener implements ActionListener
{
   MultGUI bbg;
   
   public MultiplicationListener(MultGUI bbg) {
       this.bbg=bbg;
       System.out.println(bbg);
    }
   public void actionPerformed(ActionEvent e) {
        try {
            bbg.m_total = bbg.m_total.multiply(new BigInteger(bbg.m_userInputTf.getText()));
            bbg.m_totalTf.setText(bbg.m_total.toString());
            System.out.println(bbg.m_total);
        } catch (NumberFormatException nex) {
            JOptionPane.showMessageDialog(bbg, "Bad Number");
        }
     }
}
