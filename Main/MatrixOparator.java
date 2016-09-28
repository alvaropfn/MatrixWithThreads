package Main;

import java.util.ArrayList;

public class MatrixOparator 
{
	public static void normalMultiply(
			ArrayList<ArrayList<Integer>> aMatrix,
			ArrayList<ArrayList<Integer>> bMatrix,
			ArrayList<ArrayList<Integer>> cMatrix)
	{
		int aLin = aMatrix.size();
		int aCol = aMatrix.get(0).size();
		int bCol = bMatrix.get(0).size();
		
		if(aLin != bCol)return;
		
		matrixInitializer(cMatrix, aLin, bCol);
		
		for(int lin = 0; lin < aLin; lin++)
		{
			for(int col = 0; col < bCol; col++)
			{
				ArrayList<Integer> line = new ArrayList<Integer>();
				for(int i = 0; i < aCol ; i ++)
				{
					//11036 elemento 0, 0
				}
			}
		}
	}
	
	public static void matrixInitializer(ArrayList<ArrayList<Integer>> matrix, int linOrder, int colOrder)
	{
		for(int lin = 0; lin < linOrder; lin++)
		{
			ArrayList<Integer> line = new ArrayList<Integer>();
			for(int col = 0; col < colOrder; col++)
			{
				line.add(0);
			}
			matrix.add(line);
		}
	}
}
