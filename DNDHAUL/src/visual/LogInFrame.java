package visual;

import java.awt.BorderLayout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.DBAbfragen;

public class LogInFrame extends JFrame {

	public JPanel mainPanel = new JPanel();
	public TopPanel topPanel = new TopPanel("LogIn");
	public LogInPanel loginPanel= new LogInPanel();
	
	
	public LogInFrame (String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(BorderLayout.NORTH,topPanel);
        mainPanel.add(BorderLayout.CENTER,loginPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
        this.pack();

        
        
    }

    public static void main (String []args){
//        JFrame frame = new CelsiusConverterGui("My Celsius Converter");
        JFrame frame = new LogInFrame("DNDHAUL");
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }
	
}
