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
		int linOrder = Integer.parseInt(order[lin]);
		int colOrder = Integer.parseInt(order[col]);

		for(int lin = 1; lin <= linOrder; lin++)
		{
			ArrayList line = new ArrayList();
			String[] temp = p.splitTokens(matrix[lin], " /t");
			for(int col = 0; col < colOrder; col++)
				line.add(Integer.parseInt(temp[col]));
			result.add(line);
		}
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
				if(col != colOrder -1 )
					p.print(matrix.get(lin).get(col) + " ");
				else
					p.println(matrix.get(lin).get(col));
			}
		}
	}
}
