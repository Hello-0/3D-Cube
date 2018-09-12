import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class StartScreen implements ActionListener {

	final static String a = "CHOOSE A GAME MODE";
	private JFrame frame;
	private JPanel contentPane;
	private JLabel label;
	private JButton single;
	private JButton multi;

	StartScreen(){
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		 
		try {
			contentPane.add(new JLabel(new ImageIcon(ImageIO.read(new File("pic/galaxy.jpg")))));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		single = new JButton("Single Player");
		multi = new JButton("Multiplayer");
		single.setActionCommand("Single Player");
		multi.setActionCommand("Multiplayer");
		single.setAlignmentX(JButton.CENTER_ALIGNMENT);
		multi.setAlignmentX(JButton.CENTER_ALIGNMENT);
		single.addActionListener(this);
		multi.addActionListener(this);
		
		label = new JLabel(a);
		label.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		
		contentPane.add(label);
		contentPane.add(single);
		contentPane.add(multi); 
		contentPane.setLayout(new GridLayout(0,1,5,0));
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
	
	}
	public static void runScreen(){
		
		@SuppressWarnings("unused")
		StartScreen mode = new StartScreen();
	}
	
	public static void main(String[] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			 public void run(){
				 runScreen();
			 }
		});
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}