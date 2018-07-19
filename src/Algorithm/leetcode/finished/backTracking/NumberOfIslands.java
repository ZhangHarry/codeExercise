package Algorithm.leetcode.finished.backTracking;

/**
 * Created by zhanghr on 2018/7/17.

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 Example 1:

 Input:
 11110
 11010
 11000
 00000

 Output: 1
 Example 2:

 Input:
 11000
 11000
 00100
 00011

 Output: 3
 */

public class NumberOfIslands {
    int rows,columns;
    int island = 0;
    // beat 98.70%
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        rows = grid.length;
        columns = grid[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                if (grid[i][j] == '1'){
                    island++;
                    backTrack(grid, i, j);
                }
            }
        }
        return island;
    }

    public void backTrack(char[][] grid, int i, int j){
        if (i<0 || j<0 || j>=columns || i>= rows)
            return;
        if (grid[i][j] == '1'){
            grid[i][j] = '2';
            backTrack(grid, i+1, j);
            backTrack(grid, i, j-1);
            backTrack(grid, i, j+1);
            backTrack(grid, i-1, j);
        }else
            grid[i][j] = '2';
    }
}
