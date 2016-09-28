package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main 
{	
	public static void main(String[] args)
	{
		PApplet p = new PApplet();
		MatrixPreparator mp = new MatrixPreparator(p);
		MatrixOparator mo = new MatrixOparator();
		
		/*ArrayList<ArrayList<Integer>> a, b, c;
		
		a = new ArrayList<ArrayList<Integer>>();
		b = new ArrayList<ArrayList<Integer>>();
		c = new ArrayList<ArrayList<Integer>>();
		
		mp.createMatrix(a, 0);
		mp.createMatrix(b, 8);
		 */
		
		int[][] a, b, c;
		
		a = mp.createMatrix(0);
		b = mp.createMatrix(8);
		mp.printMatrix(a);
		p.println("===========");
		mp.printMatrix(b);
		p.println("===========");
		c = mo.matrixInitializer(4, 4);
		mo.normalMultiply(a, b, c);
		mp.printMatrix(c);
	}

}
