
import java.lang.Math;

public class Vector3D{

	float X;
	float Y;
	float Z;
	double unitVX;
	double unitVY;
	
	public double getX(){
		
		return X;
	}
	
	public double getY(){
		
		return Y;
	}
	
	public double getZ(){
		
		return Z;
	}
	
	public void moveX(double dx)
	{
		X += dx;
	}
	
	public void moveZ(double dz)
	{
		Z += dz;
	}
	
	public void moveY(double dy)
	{
		Y += dy;
	}
	
	Vector3D(double x, double y, double z){
		
		this.X = (float) x;
	    this.Y = (float) y;
		this.Z = (float) z;
	}
	
	public double magnitude(){
		
		return Math.sqrt(Math.pow(X,2) + Math.pow(Y,2) + Math.pow(Z,2));
	}
	
	public void normalize(){
		
		if(magnitude()>0){
			X /= magnitude();
		 	Y /= magnitude();
		}
	}
	
	
	public double[] VecArray(){
		
		double[] points  = new double[]{(double) X,(double) Y,(double) Z};
		return points;
	}
	
	
	public double[] rotationX(double angle){
		 
		double[] vectprimeX = new double[3];
		double[][] matX = new double[][]{{1.0,0.0,0.0},
				 				{0.0,Math.cos(angle), Math.sin(angle)},
				 				{0.0,-Math.sin(angle), Math.cos(angle)}		 
		};
		 
		for(int i = 0; i<matX.length; i++){
			for(int j =0; j<matX[0].length;j++){
							
				vectprimeX[i] += (matX[i][j]*VecArray()[j]);
			}
		}
		
		return vectprimeX;	
	}
	

	public double[] rotationY(double vector[],double angle){
		
		double[] vectprimeY = new double[3];
		double[][] matY = new double[][]{{Math.cos(angle),0.0,-Math.sin(angle)},
				 				{0.0,1.0, 0.0},
				 				{Math.sin(angle),0.0, Math.cos(angle)}		 
		};
		 
		 for(int i = 0; i<matY.length; i++){
			for(int j =0; j<matY[0].length;j++){
					
					vectprimeY[i] += (matY[i][j]*vector[j]);
			}
		}
	
		 return vectprimeY;
	}
	
	public Vector3D applyRotation(double angleX, double angleY){
		double[] ret = rotationX(angleX);
		double[] ret2 = rotationY(ret, angleY);
		
		return new Vector3D(ret2[0], ret2[1], ret2[2]);
	}
}