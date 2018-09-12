import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.GradientPaint;

public class Camera implements MouseListener, MouseMotionListener, KeyListener, MouseWheelListener{

	double initX,initY;
	double X, Y;
	Vector3D position;
	double yaw,pitch;
	
	public void mouseEntered(MouseEvent arg0) {}
	public void mouseExited(MouseEvent arg0) {}
	public void mouseReleased(MouseEvent arg0) {}
	
	Camera(double x, double y, double z) {
		position = new Vector3D(x, y, z);
		
	}
	
	public void mouseClicked(MouseEvent click) {
		
	}

	public void mousePressed(MouseEvent press) {

		initX = press.getLocationOnScreen().getX();
		initY = press.getLocationOnScreen().getY();
	}
	
	public double getPitch()
	{
		return pitch;
	}
	
	public double getYaw()
	{
		return yaw;
	}
	
	public Vector3D getRelativeLocation(Vector3D point)
	{
		return new Vector3D(point.getX() - position.getX(), point.getY() - position.getY(), point.getZ() - position.getZ());
	}
	
	public void move(){
		
		
	}
	@Override
	public void mouseDragged(MouseEvent press) {
		X = press.getPoint().getX();
		Y = press.getPoint().getY();
		
		yaw += (X - initX) / 1500.0;
		pitch -= (Y - initY) / 1500.0;
		
		initX = X;
		initY = Y;
	}

	public void mouseMoved(MouseEvent arg0) {}
	
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_A)
		{
			position.moveX(0.2);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_D)
		{
			position.moveX(-0.2);
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_W)
		{
			position.moveY(0.2);
		}
		if(arg0.getKeyCode() == KeyEvent.VK_S)
		{
			position.moveY(-0.2);
		}
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {

	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent scroll) {

			if(scroll.getWheelRotation() >0){
				position.moveZ(0.2);
			}else if(scroll.getWheelRotation()<0){
				position.moveZ(-0.2);
			}
		
	}
}