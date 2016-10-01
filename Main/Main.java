package Main;

import java.util.ArrayList;

import processing.core.PApplet;

public class Main 
{	
	public static void main(String[] args)
	{
		PApplet p = new PApplet();
		MatrixPreparator mp = new MatrixPreparator();
		MatrixOperator mo = new MatrixOperator();
		MatrixOperatorThreads m1, m2;
		m1 = new MatrixOperatorThreads(0, 10, 100);
		
		
		int[][] a, b, c;
		
		a = mp.createMatrix(0);
		b = mp.createMatrix(8);
		mp.printMatrix(a);
		p.println("===========");
		mp.printMatrix(b);
		p.println("===========");
		c = mo.matrixInitializer(a[0].length, a.length);
		//mo.multiply(a, b, c);
		for(int i = 0; i<a[0].length; i++)
			m1.multiply(a, b, c, i);
		mp.printMatrix(c);
	}

}
