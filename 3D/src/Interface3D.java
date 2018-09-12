import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

	
public class Interface3D implements KeyListener {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	
	Vector3D point1 = new Vector3D(1,1,5);
	Vector3D point2 = new Vector3D(0,1,5);
	Vector3D point3 = new Vector3D(0,0,5);
	Vector3D point4 = new Vector3D(1,0,5);
	Vector3D point5 = new Vector3D(1,1,6);
	Vector3D point6 = new Vector3D(0,1,6);
	Vector3D point7 = new Vector3D(0,0,6);
	Vector3D point8 = new Vector3D(1,0,6);
	Vector3D point9 = new Vector3D(1.5,1.5,4.5);
	Vector3D point10 = new Vector3D(-.5,1.5,4.5);
	Vector3D point11 = new Vector3D(-.5,-.5,4.5);
	Vector3D point12 = new Vector3D(1.5,-.5,4.5);
	Vector3D point13 = new Vector3D(1.5,1.5,6.5);
	Vector3D point14 = new Vector3D(-.5,1.5,6.5);
	Vector3D point15 = new Vector3D(-.5,-.5,6.5);
	Vector3D point16 = new Vector3D(1.5,-.5,6.5);
	Vector3D point17 = new Vector3D(.75,.75,5.25);
	Vector3D point18 = new Vector3D(.25,.75,5.25);
	Vector3D point19 = new Vector3D(.25,.25,5.25);
	Vector3D point20 = new Vector3D(.75,.25,5.25);
	Vector3D point21 = new Vector3D(.75,.75,5.75);
	Vector3D point22 = new Vector3D(.25,.75,5.75);
	Vector3D point23 = new Vector3D(.25,.25,5.75);
	Vector3D point24 = new Vector3D(.75,.25,5.75);
	
	Camera camera;
	dimension three;
	JFrame frame;
	
	public Interface3D(){
		
		camera = new Camera(.5, .5, 0);
		frame = new JFrame("3D");
		three = new dimension();
		three.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		three.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(camera);
		frame.addMouseMotionListener(camera);
		frame.addKeyListener(camera);
		frame.addMouseWheelListener(camera);
		frame.addKeyListener(this);
		frame.add(three);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	private Vector2D transformPoint(Vector3D point){
		Vector3D relative = camera.getRelativeLocation(point);
		
		Vector3D rotated = relative.applyRotation(camera.getPitch(), camera.getYaw());
		
		Vector2D perspective = new Vector2D(rotated.getX() / rotated.getZ(), rotated.getY() / rotated.getZ(), rotated.getZ() >= 0.001);
		
		Vector2D screenSpace = new Vector2D(perspective.getX() * WIDTH + WIDTH / 2, perspective.getY() * HEIGHT + HEIGHT / 2, perspective.isInFront());
		
		return screenSpace;
	}
	
	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			
			camera = new Camera(0.5,0.5,0);
			frame.addMouseListener(camera);
			frame.addMouseMotionListener(camera);
			frame.addKeyListener(camera);
			frame.addMouseWheelListener(camera);
		}
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
	
	public double scale(double scale){
		
		return scale;
	}
	
	public int gradient(int color){
		int r = color & 0xFF0000;
		int g = color & 0x00FF00;
		int b = color & 0x0000FF;
		if(r == 0xFF0000 && g != 0x00FF00 && b== 0x000000)
		{
			color += 0x000F00;
		}else if(r != 0x000000 && g == 0x00FF00 && b== 0x000000){
			color -= 0x0F0000;
			
		}else if(r == 0x000000 && b != 0x0000FF){
			color -= 0x000F00;
			color += 0x00000F;
			
		}else if(r != 0xFF0000){
			color += 0x0F0000;
			
		}else{
			
			color -= 0x00000F;
		}
		return color;
	}
	
	public class dimension extends JPanel{
		 
		public dimension(){
		
			Timer tmr = new Timer(20, new ActionListener(){
        		
				public void actionPerformed(ActionEvent e){

					Color1 = gradient(Color1);
					Color2 = gradient(Color2);
					Color3 = gradient(Color3);
				}
			});
			tmr.start();
		}
		
		int Color1 = 0xFFFFFF;
		int Color2 = 0x00FFFF;
		int Color3 = 0x000FFF;

	    public void paint(Graphics g){
	    	
	        super.paintComponent(g); 
	        
	        Vector2D p1 = transformPoint(point1);
	        Vector2D p2 = transformPoint(point2);
	        Vector2D p3 = transformPoint(point3);
	        Vector2D p4 = transformPoint(point4);
	        Vector2D p5 = transformPoint(point5);
	        Vector2D p6 = transformPoint(point6);
	        Vector2D p7 = transformPoint(point7);
	        Vector2D p8 = transformPoint(point8);
	        Vector2D p9 = transformPoint(point9);
	        Vector2D p10 = transformPoint(point10);
	        Vector2D p11 = transformPoint(point11);
	        Vector2D p12 = transformPoint(point12);
	        Vector2D p13 = transformPoint(point13);
	        Vector2D p14 = transformPoint(point14);
	        Vector2D p15 = transformPoint(point15);
	        Vector2D p16 = transformPoint(point16);
	        Vector2D p17 = transformPoint(point17);
	        Vector2D p18 = transformPoint(point18);
	        Vector2D p19 = transformPoint(point19);
	        Vector2D p20 = transformPoint(point20);
	        Vector2D p21 = transformPoint(point21);
	        Vector2D p22 = transformPoint(point22);
	        Vector2D p23 = transformPoint(point23);
	        Vector2D p24 = transformPoint(point24);
	        
	        g.setColor(new Color(Color1));
	   
	        if(p1.isInFront() && p2.isInFront()){
	        	g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p2.getX(), (int)p2.getY());
	        }
	        
	        if(p2.isInFront() && p3.isInFront()){
		        g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p3.getX(), (int)p3.getY());
	        }
	        if(p3.isInFront() && p4.isInFront())
	        {
	        	
		        g.drawLine((int)p3.getX(), (int)p3.getY(), (int)p4.getX(), (int)p4.getY());
	        }
	        if(p4.isInFront() && p1.isInFront())
	        {
	        	
		        g.drawLine((int)p4.getX(), (int)p4.getY(), (int)p1.getX(), (int)p1.getY());
	        }
	        
	        if(p1.isInFront() && p5.isInFront())
	        {
	   
	        	g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p5.getX(), (int)p5.getY());
	        }
	        if(p2.isInFront() && p6.isInFront())
	        {
	        
		        g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p6.getX(), (int)p6.getY());
	        }
	        if(p3.isInFront() && p7.isInFront())
	        {
	        	
		        g.drawLine((int)p3.getX(), (int)p3.getY(), (int)p7.getX(), (int)p7.getY());
	        }
	        if(p4.isInFront() && p8.isInFront())
	        {
	     
		        g.drawLine((int)p4.getX(), (int)p4.getY(), (int)p8.getX(), (int)p8.getY());
	        }
	        
	      
	        if(p5.isInFront() && p6.isInFront())
	        {
	       
	        	g.drawLine((int)p5.getX(), (int)p5.getY(), (int)p6.getX(), (int)p6.getY());
	        }
	        if(p6.isInFront() && p7.isInFront())
	        {

		        g.drawLine((int)p6.getX(), (int)p6.getY(), (int)p7.getX(), (int)p7.getY());
	        }
	        if(p7.isInFront() && p8.isInFront())
	        {
	        
		        g.drawLine((int)p7.getX(), (int)p7.getY(), (int)p8.getX(), (int)p8.getY());
	        }
	        if(p8.isInFront() && p5.isInFront())
	        {
	        	
		        g.drawLine((int)p8.getX(), (int)p8.getY(), (int)p5.getX(), (int)p5.getY());
	        }
	        
	        g.setColor(new Color(Color2));
	        if(p9.isInFront() && p10.isInFront())
	        {
	        	
		        g.drawLine((int)p9.getX(), (int)p9.getY(), (int)p10.getX(), (int)p10.getY());
	        }
	        if(p10.isInFront() && p11.isInFront())
	        {
	        	
		        g.drawLine((int)p10.getX(), (int)p10.getY(), (int)p11.getX(), (int)p11.getY());
	        }
	        if(p11.isInFront() && p12.isInFront())
	        {
	        	
		        g.drawLine((int)p11.getX(), (int)p11.getY(), (int)p12.getX(), (int)p12.getY());
	        }
	        if(p12.isInFront() && p9.isInFront())
	        {
	      
		        g.drawLine((int)p12.getX(), (int)p12.getY(), (int)p9.getX(), (int)p9.getY());
	        }
	        
	        if(p9.isInFront() && p13.isInFront())
	        {
	        	
		        g.drawLine((int)p9.getX(), (int)p9.getY(), (int)p13.getX(), (int)p13.getY());
	        }
	        
	        if(p10.isInFront() && p14.isInFront())
	        {
	        	
		        g.drawLine((int)p10.getX(), (int)p10.getY(), (int)p14.getX(), (int)p14.getY());
	        }
	        
	        if(p11.isInFront() && p15.isInFront())
	        {
	    
		        g.drawLine((int)p11.getX(), (int)p11.getY(), (int)p15.getX(), (int)p15.getY());
	        }
	        
	        if(p12.isInFront() && p16.isInFront())
	        {
	        
		        g.drawLine((int)p12.getX(), (int)p12.getY(), (int)p16.getX(), (int)p16.getY());
	        }
	        
	        if(p13.isInFront() && p14.isInFront())
	        {
	        
		        g.drawLine((int)p13.getX(), (int)p13.getY(), (int)p14.getX(), (int)p14.getY());
	        }
	        
	        if(p14.isInFront() && p15.isInFront())
	        {
	        
		        g.drawLine((int)p14.getX(), (int)p14.getY(), (int)p15.getX(), (int)p15.getY());
	        }
	        
	        if(p15.isInFront() && p16.isInFront())
	        {
	        	
		        g.drawLine((int)p15.getX(), (int)p15.getY(), (int)p16.getX(), (int)p16.getY());
	        }
	        
	        if(p16.isInFront() && p13.isInFront())
	        {
	        
		        g.drawLine((int)p16.getX(), (int)p16.getY(), (int)p13.getX(), (int)p13.getY());
	        }
	        
	        g.setColor(new Color(Color3));
	        if(p17.isInFront() && p18.isInFront())
	        {
	        	
		        g.drawLine((int)p17.getX(), (int)p17.getY(), (int)p18.getX(), (int)p18.getY());
	        }
	     
	        if(p18.isInFront() && p19.isInFront())
	        {
	        
		        g.drawLine((int)p18.getX(), (int)p18.getY(), (int)p19.getX(), (int)p19.getY());
	        }
	     
	        if(p19.isInFront() && p20.isInFront())
	        {
	      
		        g.drawLine((int)p19.getX(), (int)p19.getY(), (int)p20.getX(), (int)p20.getY());
	        }
	     
	        if(p20.isInFront() && p17.isInFront())
	        {
		        g.drawLine((int)p20.getX(), (int)p20.getY(), (int)p17.getX(), (int)p17.getY());
	        }
	        
	        if(p17.isInFront() && p21.isInFront())
	        {
	    
		        g.drawLine((int)p17.getX(), (int)p17.getY(), (int)p21.getX(), (int)p21.getY());
	        }
	        if(p18.isInFront() && p22.isInFront())
	        {
	        	
		        g.drawLine((int)p18.getX(), (int)p18.getY(), (int)p22.getX(), (int)p22.getY());
	        }
	        if(p19.isInFront() && p23.isInFront())
	        {
	       
		        g.drawLine((int)p19.getX(), (int)p19.getY(), (int)p23.getX(), (int)p23.getY());
	        }
	        if(p20.isInFront() && p24.isInFront())
	        {
	        	
		        g.drawLine((int)p20.getX(), (int)p20.getY(), (int)p24.getX(), (int)p24.getY());
	        }
	        if(p21.isInFront() && p22.isInFront())
	        {
	     
		        g.drawLine((int)p21.getX(), (int)p21.getY(), (int)p22.getX(), (int)p22.getY());
	        }
	        if(p22.isInFront() && p23.isInFront())
	        {
	        	
		        g.drawLine((int)p22.getX(), (int)p22.getY(), (int)p23.getX(), (int)p23.getY());
	        }
	        if(p23.isInFront() && p24.isInFront())
	        {
	        	
		        g.drawLine((int)p23.getX(), (int)p23.getY(), (int)p24.getX(), (int)p24.getY());
	        }
	        if(p24.isInFront() && p21.isInFront())
	        {
	        	
	        	g.drawLine((int)p24.getX(), (int)p24.getY(), (int)p21.getX(), (int)p21.getY());
	        	
	        } 
	        
	        g.setColor(Color.WHITE);
	        
	        if(p1.isInFront() && p9.isInFront())
	        {
	        	
	        	g.drawLine((int)p1.getX(), (int)p1.getY(), (int)p9.getX(), (int)p9.getY());
	        	
	        } 
	        
	        if(p2.isInFront() && p10.isInFront())
	        {
	        	
	        	g.drawLine((int)p2.getX(), (int)p2.getY(), (int)p10.getX(), (int)p10.getY());
	        	
	        } 
	        
	        if(p3.isInFront() && p11.isInFront())
	        {
	        	
	        	g.drawLine((int)p3.getX(), (int)p3.getY(), (int)p11.getX(), (int)p11.getY());
	        	
	        } 
	        
	        if(p4.isInFront() && p12.isInFront())
	        {
	        	
	        	g.drawLine((int)p4.getX(), (int)p4.getY(), (int)p12.getX(), (int)p12.getY());
	        	
	        } 
	        
	        if(p5.isInFront() && p13.isInFront())
	        {
	        	
	        	g.drawLine((int)p5.getX(), (int)p5.getY(), (int)p13.getX(), (int)p13.getY());
	        	
	        } 
	        
	        if(p6.isInFront() && p14.isInFront())
	        {
	        	
	        	g.drawLine((int)p6.getX(), (int)p6.getY(), (int)p14.getX(), (int)p14.getY());
	        	
	        } 
	        
	        if(p7.isInFront() && p15.isInFront())
	        {
	        	
	        	g.drawLine((int)p7.getX(), (int)p7.getY(), (int)p15.getX(), (int)p15.getY());
	        	
	        } 
	        
	        if(p8.isInFront() && p16.isInFront())
	        {
	        	
	        	g.drawLine((int)p8.getX(), (int)p8.getY(), (int)p16.getX(), (int)p16.getY());
	        	
	        } 
	   
	        repaint();
	    }
	}
	
	public static void main(String args[]){
		
		Interface3D f = new Interface3D();
	}
}