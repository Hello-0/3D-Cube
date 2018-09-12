
public class Vector2D{

	float X;
	float Y;
	
	boolean front;
	
	Vector2D(double x, double y, boolean front) {
		
		this.X = (float) x;
		this.Y = (float) y;
		this.front = front;
	}
	
	public double getX(){
		
		return X;
	}
	
	public double getY(){
		
		return Y;
	}
	
	public boolean isInFront(){
		return front;
	}
}