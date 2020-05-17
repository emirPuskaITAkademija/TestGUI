package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * <li>
 * 1. JFrame - glavni kontejner unutar kojeg ubacujes neke komponente JPanel -
 * kontejneri
 * <li>
 * 2. LayoutManager -> BorderLayout, GridLayout, GridBagLayout, FlowLayout,
 * BoxLayout...
 *
 * <li>
 * 3. UI controls -> JButton, JLabel, JTextField, JComboBox, JCheckBox,
 * JRadioButton, ....
 *
 * <p>
 * JFrame frame = new JFRame(); frame.setLayout(new GridLayout()); JButton
 * button = new JButton(); JButton button2 = new JButton(); JButton button3 =
 * new JButton(); frame.add(button); frame.add(button2); frame.add(button3);
 *
 *
 *
 * @author emir
 */
public class FrameApplication {

    //glavni kontejner
    private JFrame frame;

    public FrameApplication() {
        frame = new JFrame("Nas frame");
        //BorderLayout layoutManager = new BorderLayout();
        //manager vezan frame
        Container container = frame.getContentPane();
        BoxLayout boxLayout = new BoxLayout(container, BoxLayout.Y_AXIS);
        //GridLayout gridLayout = new GridLayout(2, 3);
        frame.setLayout(boxLayout);//LayoutManager manager
    }

    public void showFrame() {
        //UI controls
        JButton button = new JButton("Sign in");
        ActionListener loginActionListener = new LoginActionListener();
        button.addActionListener(loginActionListener);
        JButton button2 = new JButton("Click me");
        JButton button3 = new JButton("Click me not him");
        JButton button4 = new JButton("Click me not him");
        JButton button5 = new JButton("Click me not him");
        frame.add(button);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();// ja cu biti one velicine kolko treba,
        //frame.setSize(300, 200);
        frame.pack();
        frame.setVisible(true);

    }
    
    //inner klasa 
    private class LoginActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //Exceptions -> mehanizmi pomocu kojih programer moze otkriti najbrze gresku kada radi osjetljive stvari
            PrintWriter out = null;
            try{
                out = new PrintWriter("mirza.txt");
                out.println("Mirza, neko se pokušao logovati");
            }catch(IOException exception){
                System.err.println(exception.getMessage());
            }finally{
                if(out!=null){
                    out.close();
                }
            }
        }
        
    }

    public static void main(String[] args) {
        //Brian Goetz
        System.out.println("Izvršavanje main metode pokreće: "+ Thread.currentThread().getName());
        //MAIN Thread
        //Proces -> radnu memoriju; izvršno okruženje
        //Proces -> više threadova -> Proces ima najmanje jedan Thread(Main Thread)
        //Dual core -> Quad core  4 jezgre i hyperthreadin 8 jezgri -> thread
        // Single core -> više threadova 
        //UI ili GUI -> nije dobro ga iscrtavati u MAIN Thread
        FrameApplication frameApplication = new FrameApplication();
        //frameApplication.showFrame();
        Runnable frameInvoker = new FrameInvoker(frameApplication);
        //frameApplication.showFrame();
        SwingUtilities.invokeLater(frameInvoker); // frameInvoker -> frameInvoke.run()
    }
}
