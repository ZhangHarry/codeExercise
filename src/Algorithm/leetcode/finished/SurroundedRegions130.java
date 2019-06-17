package Algorithm.leetcode.finished;

import Algorithm.leetcode.util.Tool;

/**
 * Created by zhanghr on 2018/9/6.

 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X XTe'e'Map
 X O X X

 */

public class SurroundedRegions130 {
    boolean[][] visited;
    int rows,cols;
    // beat 56%
    // 一种优化空间的做法：不使用visited，而是直接修改board，比如将board[i][j]从O变成D，然后遍历的时候再改回来。
    public void solve(char[][] board) {
        rows = board.length;
        if (rows==0)
            return;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i=0; i<cols; i++){
            if (board[0][i]=='O')
                visit(board, 0, i);
            if (board[rows-1][i]=='O')
                visit(board, rows-1, i);
        }
        for (int i=0; i<rows; i++){
            if (board[i][0] == 'O')
                visit(board, i, 0);
            if (board[i][cols-1] == 'O')
                visit(board, i, cols-1);
        }

        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if(board[i][j]=='O' && !visited[i][j])
                    board[i][j]='X';
            }
        }
    }

    int[][] moves = new int[][]{
            new int[]{1,0}, new int[]{0,1}, new int[]{-1,0}, new int[]{0,-1}
    };

    public void visit(char[][] board, int i,int j){
        if (i<0 || i>=rows || j<0 || j>=cols)
            return;
        if (visited[i][j] || board[i][j]=='X')
            return;
        visited[i][j] = true;
        for (int[] move : moves){
            visit(board, i+move[0], j+move[1]);
        }
    }

    public static void main(String[] args){
        SurroundedRegions130 test = new SurroundedRegions130();
        String s= "[[\"X\",\"O\",\"X\"],[\"O\",\"X\",\"O\"],[\"X\",\"O\",\"X\"]]";
        char[][] board = Tool.toCharAA(s);
        test.solve(board);
    }
}
