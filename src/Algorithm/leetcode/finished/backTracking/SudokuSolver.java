package Algorithm.leetcode.finished.backTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 注意数独游戏不仅要求横竖不能包含相同项，九宫格也需要保证1~9
 * @author zhanghr
 *
 */
public class SudokuSolver {
	public static void main(String[] args) {
		char[][] board = new char[][]{
			new char[]{'.','.','9','7','4','8','.','.','.'},
			new char[]{'7','.','.','.','.','.','.','.','.'},
			new char[]{'.','2','.','1','.','9','.','.','.'},
			new char[]{'.','.','7','.','.','.','2','4','.'},
			new char[]{'.','6','4','.','1','.','5','9','.'},
			new char[]{'.','9','8','.','.','.','3','.','.'},
			new char[]{'.','.','.','8','.','3','.','2','.'},
			new char[]{'.','.','.','.','.','.','.','.','6'},
			new char[]{'.','.','.','2','7','5','9','.','.'}		
		};
		SudokuSolver test = new SudokuSolver();
		test.solveSudoku(board);
	}
	
	public void solveSudoku(char[][] board) {
		backTrack(board, 0, 0);
		System.out.println();
	}
	
	// beat 13.71%
	private boolean backTrack(char[][] board, int row, int col) {
		if (row == board.length)
			return true;
		
		if (board[row][col] != '.') {
			if (col == board[0].length-1)
				return backTrack(board, row+1, 0);
			else {
				return backTrack(board, row, col+1);
			}
		}else {
			List<Character> list = getCandidates(board, row, col);
			for (Character can : list){
				board[row][col] = can;
				boolean bl;
				if (col == board[0].length-1)
					bl = backTrack(board, row+1, 0);
				else {
					bl = backTrack(board, row, col+1);
				}
				if (bl)
					return true;
				board[row][col] = '.';
			}
		}
		
		return false;		
	}

	
	private List<Character> getCandidates(char[][] board, int i, int j){
		List<Character> list = new LinkedList<>();
		for (int index = 0; index<9; index++)
			list.add((char)('1'+index));
		for (int ii =0;ii<9;ii++) {
			if (board[ii][j] != '.')
				list.remove((Character)board[ii][j]);
		}
		
		for (int jj =0; jj<9;jj++) {
			if (board[i][jj] != '.')
				list.remove((Character)board[i][jj]);
		}
		
		int gridy = (j/3)*3;
		int gridX = (i/3)*3;
		for (int ii = gridX; ii<gridX+3; ii++){
			for (int jj = gridy; jj<gridy+3; jj++)
				if (board[ii][jj] != '.')
					list.remove((Character)board[ii][jj]);
		}
		return list;
	}
}
