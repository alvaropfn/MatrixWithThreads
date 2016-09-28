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

	public MatrixPreparator(PApplet p)
	{
		this.p = p;
		folder = new File(local);
		files = folder.listFiles();
	}

	public void createMatrix(ArrayList<ArrayList<Integer>> result, int index)
	{
		String[] matrix = p.loadStrings(files[index]);
		String[] order = p.splitTokens(matrix[0], " ");
		int linOrder = Integer.parseInt(order[this.lin]);
		int colOrder = Integer.parseInt(order[this.col]);

		for(int lin = 1; lin <= linOrder; lin++)
		{
			ArrayList line = new ArrayList();
			String[] temp = p.splitTokens(matrix[lin], " /t");
			for(int col = 0; col < colOrder; col++)
				line.add(Integer.parseInt(temp[col]));
			result.add(line);
		}
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

	public void printMatrix(ArrayList<ArrayList<Integer>> matrix)
	{
		int linOrder = matrix.size();
		int colOrder = matrix.get(0).size();
		for(int lin = 0; lin < linOrder; lin++)
		{
			for(int col = 0; col < colOrder; col++)
			{
				String pre = "["+lin+","+col+"]: ";
				if(col != colOrder -1 )
					p.print( pre+ matrix.get(lin).get(col) + " ");
				else
					p.println(pre+ matrix.get(lin).get(col));
			}
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
