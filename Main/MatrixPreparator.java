package Main;

import java.io.File;
import java.util.ArrayList;
import processing.core.PApplet;

public class MatrixPreparator
{
	PApplet p;
	private File folder;
	private File[] files;
	private final int lin = 0, col = 1;
	private final String local = ".//src/Matrizes/";

	public MatrixPreparator()
	{
		folder = new File(local);
		files = folder.listFiles();
	}
	
	public int[][] createMatrix(int index)
	{
		String[] matrix = p.loadStrings(files[index]);
		String[] order = p.splitTokens(matrix[0], " ");
		
		int linOrder = Integer.parseInt(order[this.lin]);
		int colOrder = Integer.parseInt(order[this.col]);
		
		int[][] result = new int[linOrder][colOrder]; 
		
		for(int lin = 0; lin < linOrder; lin++)
		{
			String[] temp = p.splitTokens(matrix[lin+1], " /t");
			for(int col = 0; col < colOrder; col++)
				result[lin][col] = Integer.parseInt(temp[col]);
			
		}
		return result;
	}

	public void printFiles()
	{
		int i = 0;
		for(File f: files)
		{
			p.println("["+i+"] " +f.toString().replaceFirst(local,""));
			//p.println("["+i+"] " +f.toString());
			i++;
		}
	}
	
	public void printMatrix(int[][] matrix)
	{
		int linOrder = matrix.length;
		int colOrder = matrix[0].length;
		for(int lin = 0; lin < linOrder; lin++)
		{
			for(int col = 0; col < colOrder; col++)
			{
				String pre = "["+lin+","+col+"]: ";
				if(col != colOrder -1 )
					p.print( pre+ matrix[lin][col] + " ");
				else
					p.println(pre+ matrix[lin][col]);
			}
		}
	}
}
