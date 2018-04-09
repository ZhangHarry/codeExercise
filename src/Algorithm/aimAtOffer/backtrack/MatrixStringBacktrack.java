package Algorithm.aimAtOffer.backtrack;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，
 * 则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 
 * 问题实际上是问有没有连续的路径就是所求，不需要考虑不连续的情况
 * @author zhanghr
 *
 */
public class MatrixStringBacktrack {
	public static void main(String[] args) {
		MatrixStringBacktrack backtrack = new MatrixStringBacktrack();
		char[] matrix = new char[]{'a', 'b', 'c','e','s','f', 'c', 's', 'a', 'd', 'e', 'e'};
		int rows = 3, cols = 4;
		char[] str = new char[]{'b', 'c', 'c', 'e', 'd'};
		str = new char[]{'a', 'b', 'c', 'b'};
		System.out.println(backtrack.hasPath(matrix, rows, cols, str));
	}
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
		if (str==null || str.length==0)
			return true;
		if (matrix == null || matrix.length ==0 || matrix.length != rows * cols)
			return false;
		boolean[] visited = new boolean[matrix.length];
		int mi = 0, si = 0;
		for (;mi<matrix.length;mi++){
			if (backTrack(matrix, mi, cols, str, si, visited))
				return true;
		}
		return false;
    }
	
	public boolean backTrack(char[] matrix, int mi, int cols, char[] str, int si, boolean[] visited){
		if (si == str.length)
			return true;
		if (mi < 0 || mi >= matrix.length)
			return false;
		if (visited[mi])
			return false;
		if (matrix[mi] != str[si])
			return false;
		
		visited[mi] = true;
		if (backTrack(matrix, mi+cols, cols, str, si+1, visited))
			return true;
		
		if (backTrack(matrix, mi-cols, cols, str, si+1, visited))
			return true;
		
		if (((mi+1)%cols != 0) && backTrack(matrix, mi+1, cols, str, si+1, visited))
			return true;
		
		if ((mi%cols != 0) && backTrack(matrix, mi-1, cols, str, si+1, visited))
			return true;
		
		visited[mi] = false;
		return false;
	}
}
