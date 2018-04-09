package Algorithm.leetcode.finished.backTracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid. The word
 * can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * For example, Given board = [ 
 * 		['A','B','C','E'], 
 * 		['S','F','C','S'], 
 * 		['A','D','E','E'] ] 
 * word = "ABCCED", -> returns true, 
 * word = "SEE", -> returns true, 
 * word = "ABCB", -> returns false.
 * 
 * @author zhanghr
 *
 */
public class WordSearch {
	int rows, cols;
	/**
	 *  beat 93%
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (word == null || word.length() == 0)
			return true;
		if (board == null)
			return false;
		rows = board.length;
		cols = board[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (backTrack(board, visited, word, 0, i, j))
					return true;
			}
		}
		return false;
	}

	public boolean backTrack(char[][] board, boolean[][] visited, String word, int index, int row, int col) {
		if (index == word.length())
			return true;
		if (row >= rows || row < 0 || col >= cols || col < 0)
			return false;
		if (visited[row][col])
			return false;
		if (board[row][col] != word.charAt(index))
			return false;

		visited[row][col] = true;

		if (backTrack(board, visited, word, index + 1, row - 1, col))
			return true;

		if (backTrack(board, visited, word, index + 1, row + 1, col))
			return true;

		if (backTrack(board, visited, word, index + 1, row, col + 1))
			return true;

		if (backTrack(board, visited, word, index + 1, row, col - 1))
			return true;

		visited[row][col] = false;
		return false;

	}
}
