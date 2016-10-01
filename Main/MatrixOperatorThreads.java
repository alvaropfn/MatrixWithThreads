package Main;

import java.util.Random;

import processing.core.PApplet;

public class MatrixOperatorThreads extends MatrixOperator
{
	int[][] matrix;
	int id, valor, tempo;
	PApplet p;
	
	public void multiply(int[][] a, int[][] b, int[][] c, int lin)
	{
		int aLin = a.length;
		int aCol = a[0].length;
		int bLin = b.length;
		int bCol = b[0].length;
		
		if(aCol != bLin) return;
		
		Runnable r = new Runnable()
		{
			@Override
			public void run()
			{
				for(int col = 0; col < bCol; col++)
					for(int i = 0; i < aCol; i++)
						c[lin][col] += a[lin][i] * b[i][col];
			}
		};
		
		new Thread(r).start();
	}
	
	public MatrixOperatorThreads(int id, int valor, int tempo) {
		this.id = id;
		this.valor = valor;
		this.tempo = tempo;
		matrix = new int[][]{{11,12,13,14},
							{21,22,23,24},
							{31,32,33,34},
							{41,42,43,44}}
		;/********************************/
	}
	
	public void myMethod(int id)
	{
		int k=0;
		Runnable r= new Runnable() {
			
			@Override
			public void run() 
			{
				for(int i = 0; i < 4; i++)
				{
					p.println(id+": ["+matrix[id][i]+"]");
					try 
					{
						Random rnd = new Random();
						Thread.sleep(rnd.nextInt(tempo));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
			}
		};
		
		Thread t = new Thread(r);
		t.start();
	}
	
	
	
	
	
}
