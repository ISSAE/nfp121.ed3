import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Décrivez votre classe MultGUI ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class MultGUI extends JFrame
{
    //... éléments de l'interface
    protected JTextField m_totalTf     = new JTextField(10);
    protected JTextField m_userInputTf = new JTextField(10);
    private JButton    m_multiplyBtn = new JButton("Multiplier");
    private JButton    m_clearBtn    = new JButton("Effacer");
    private JLabel    m_entreeL = new JLabel("Entrée");
    private JLabel    m_totalL    = new JLabel("Total");

    protected java.math.BigInteger m_total;
    
    JPanel content = new JPanel(new FlowLayout());
    
    
    /** Constructor */
    MultGUI() {
        //ETAPE1
        content.add(m_entreeL);
        content.add(m_userInputTf);
        content.add(m_multiplyBtn);
        content.add(m_totalL);
        content.add(m_totalTf);
        content.add(m_clearBtn);
        //... finalize layout
        this.setContentPane(content);
        this.pack();
        
        //ETAPE2
        m_total = new java.math.BigInteger("1000000");
        m_multiplyBtn.addActionListener(new MultiplicationListener(this));
        m_clearBtn.addActionListener(new EffacerListener(this));
        
        setVisible(true);
    } 
   
    public static void main (String args[]) {
        MultGUI bbg=new MultGUI();
        bbg.setVisible(true);
    }
}
