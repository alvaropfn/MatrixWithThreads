package Main;

import java.util.ArrayList;

public class MatrixOparator 
{
	public void normalMultiply(
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
			ArrayList<Integer> cLine = cMatrix.get(lin);
			for(int col = 0; col < bCol; col++)
			{
				for(int i = 0; i < aCol ; i ++)
				{
					//11036 elemento 0, 0
					int temp = cLine.get(col);
					temp += aMatrix.get(lin).get(i) * bMatrix.get(i).get(col);
					cLine.set(col, temp); 
					//System.out.println(temp);
				}
				
			}
			cMatrix.set(lin, cLine);
		}
	}
	
	public void normalMultiply(int[][] a, int[][] b, int[][] c)
	{
		
		int aLin = a.length;
		int aCol = a[0].length;
		int bLin = b.length;
		int bCol = b[0].length;
		
		if(aCol != bLin) return;
		
		for(int lin = 0; lin < aLin; lin++)
			for(int col = 0; col < bCol; col++)
				for(int i = 0; i < aCol; i++)
					c[lin][col] += a[lin][i] * b[i][col];
		
	}
	
	public void matrixInitializer(ArrayList<ArrayList<Integer>> matrix, int linOrder, int colOrder)
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
	public int[][] matrixInitializer(int linOrder, int colOrder)
	{
		int[][] result = new int[linOrder][colOrder];
		for(int lin = 0; lin < linOrder; lin++)
			for(int col = 0; col < colOrder; col++)
				result[lin][col] = 0;
		return result;
	}
}
