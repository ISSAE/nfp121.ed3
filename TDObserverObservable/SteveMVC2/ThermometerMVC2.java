/**
  Program:   ThermometerMVC2 applet
  Purpose:   To illustrate the model-view-controller paradigm in Java.
  @author    Steve A. Chervitz (sac@genome.stanford.edu)
             Adapted from David Geary's example in Java Report 2(1):31-37.
  @version   3 Mar 1997
             This is a more complicated example than ThermometerMVC1.
	     It has two views and two interacting controllers which inherit 
	     from a base class.
*/

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;


/*-----------------------------------------------------*/
public class ThermometerMVC2 extends JFrame 
/*-----------------------------------------------------*/
{
    Container container;
  //These two views 'view' the same model.
  private TemperatureView       tempView;
  private ThermometerView       thermView;

  //These two controllers control both views (but they don't have to.)
  private SwitchController     switchControl;
  private ThermostatController thermostatControl;
  public ThermometerMVC2() {
      container=getContentPane();
      init();
    }
  public void init() 
    { 
      tempView          = new TemperatureView();
      thermView         = new ThermometerView();
      switchControl     = new SwitchController();
      thermostatControl = new ThermostatController();

      setFont(new Font("Helvetica",Font.BOLD, 16));
      setForeground(Color.black);
      add( new Label("ThermometerMVC2:  Model-View-Controller in Java"));
      add( new Label("Vue partagée 2 interactions"));

      //Penl model
      JPanel p_model = new JPanel();
      p_model.setLayout( new BorderLayout());
      p_model.add("North", new JLabel("Model"));
      TextArea ta = new TextArea(switchControl.getModel().toString(),5,40);
      ta.setFont( new Font("Helvetica",Font.PLAIN, 14));
      ta.setEditable( false);
      p_model.add("Center",ta);

      //View1
      JPanel p_view1 = new JPanel();
      p_view1.setLayout( new BorderLayout());
      p_view1.add("North", new JLabel("View1"));
      p_view1.add("Center",tempView);

      //View2
      JPanel p_view2 = new JPanel();
      p_view2.setLayout( new BorderLayout());
      p_view2.add("North", new JLabel("View2"));
      p_view2.add("Center",thermView);

      //Controler1 
      JPanel p_controller1 = new JPanel();
      p_controller1.setLayout( new BorderLayout());
      p_controller1.add("North", new JLabel("Controller1"));
      p_controller1.add("Center",switchControl);

      //Controler 2
      JPanel p_controller2 = new JPanel();
      p_controller2.setLayout( new BorderLayout());
      p_controller2.add("North", new JLabel("Controller2"));
      p_controller2.add("East",thermostatControl);


      container.setLayout(new FlowLayout());
      container.add( p_model);
      container.add( p_view1);
      container.add( p_view2);
      container.add( p_controller1);
      container.add( p_controller2);

      switchControl.addObserver(tempView);
      switchControl.addObserver(thermView);
      switchControl.addMouseListener(switchControl);
      switchControl.addMouseMotionListener(switchControl);
      thermostatControl.addObserver(tempView);
      thermostatControl.addObserver(thermView);
      thermostatControl.addMouseListener(thermostatControl);
      thermostatControl.addMouseMotionListener(thermostatControl);
      //Link the two controllers: the thermostat should update as a result of switch events.
      switchControl.addObserver(thermostatControl); 
      switchControl.resetModel();  //To initialize the views.
    }
  
  public static void main (String ...args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
       LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
       for (LookAndFeelInfo info : plafs) {
           System.out.println(info);
       }
       UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
      JFrame jf=new ThermometerMVC2();
      //jf.setPreferredSize(new Dimension(200, 100));
      jf.setBounds(300, 300, 500, 500);
      jf.setVisible(true);
  }
}


