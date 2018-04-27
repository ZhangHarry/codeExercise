package Algorithm.leetcode.finished.backTracking;

/*
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */
import java.util.*;

public class PacificAtlanticWaterFlow {
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> list = new LinkedList<>();
		if (matrix == null)
			return list;
		else if (matrix.length == 1){
			list.add(new int[]{0,0});
			return list;
		}
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		for (int i =0; i<matrix.length; i++)
			if (backTrack(matrix, list, 0, i, visited))
				return list;
//		for (int i =1; i<matrix[0].length;i++)
//			if (backTrack(matrix, list, i, 0, visited))
//				return list;
		return list;
	}

	private boolean backTrack(int[][] matrix, List<int[]> list, int i, int j, boolean[][] visited) {
		if (i == matrix.length-1) {
			list.add(new int[]{i, j});
			return true;
		}
		if (i<0 || i >= matrix.length)
			return false;
		if (j<0 || j>=matrix[0].length)
			return false;
		if (visited[i][j])
			return false;
				
		visited[i][j] = true;
		list.add(new int[]{i,j});
		if (i>0 && matrix[i-1][j]<=matrix[i][j] && backTrack(matrix, list, i-1, j, visited))
			return true;
		
		if (i<matrix.length-1 && matrix[i+1][j]<=matrix[i][j] && backTrack(matrix, list, i+1, j, visited))
			return true;
		
		if (j>0 && matrix[i][j-1]<=matrix[i][j] && backTrack(matrix, list, i, j-1, visited))
			return true;
		
		if (j<matrix[0].length-1 && matrix[i][j+1]<=matrix[i][j] && backTrack(matrix, list, i, j+1, visited))
			return true;
		
		visited[i][j] = false;
		list.remove(list.size()-1);
		return false;
	}
	
	public static void main(String[] args) {				
		PacificAtlanticWaterFlow test = new PacificAtlanticWaterFlow();
		int[][] matrix = new int[][]{
			new int[]{1, 2, 2, 3, 5},
			new int[]{3, 2, 3, 4, 4},
			new int[]{2, 4, 5, 3, 1},
			new int[]{6, 7, 1, 4, 5},
			new int[]{5, 1, 1, 2, 4},
		};
		test.pacificAtlantic(matrix);
	}
}
