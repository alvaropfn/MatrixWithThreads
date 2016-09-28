package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main 
{	
	public static void main(String[] args)
	{
		PApplet p = new PApplet();
		MatrixPreparator mp = new MatrixPreparator(p);
		MatrixOparator mo;
		
		ArrayList<ArrayList<Integer>> a, b, c;
		
		a = new ArrayList<ArrayList<Integer>>();
		b = new ArrayList<ArrayList<Integer>>();
		c = new ArrayList<ArrayList<Integer>>();
		
		mp.createMatrix(a, 0);
		mp.createMatrix(b, 8);

		mp.printMatrix(a);
		p.println("===========");
		mp.printMatrix(b);
		p.println("===========");
		MatrixOparator.matrixInitializer(c, 4, 4);
		mp.printMatrix(c);
	}

}
