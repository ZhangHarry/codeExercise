package Algorithm.aimAtOffer.backtrack;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），
 * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * @author zhanghr
 *
 */
public class MovingCount {
	public static void main(String[] args) {
		MovingCount count = new MovingCount();
		System.out.println(count.movingCount(10, 1, 100));
	}
	
	public int movingCount(int threshold, int rows, int cols)
    {
		if (threshold < 0)
			return 0;
		if (rows <= 0 || cols <= 0)
			return 0;
		boolean[][] reachMatrix = new boolean[rows][cols];
		boolean[][] visitedMatrix = new boolean[rows][cols];
        movingCountBackTrack(threshold, rows, cols, 0, 0, reachMatrix, visitedMatrix);
        int count =0;
        for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (reachMatrix[i][j]) {
					count++;
					System.out.println(String.format("(%d, %d)", i, j));
				}
			}
		}
        return count;
    }
	
	private void movingCountBackTrack(int threshold, int rows, int cols, int i, int j, boolean[][] reachMatrix, boolean[][] visitedMatrix) {
		if (i == rows || i < 0)
			return ;
		if (j == cols || j < 0)
			return ;
		if (visitedMatrix[i][j])
			return;
		visitedMatrix[i][j] = true;
		if (getBitSum(i) + getBitSum(j) <= threshold) {
			reachMatrix[i][j] = true;
			movingCountBackTrack(threshold, rows, cols, i+1, j, reachMatrix, visitedMatrix);
			movingCountBackTrack(threshold, rows, cols, i-1, j, reachMatrix, visitedMatrix);
			movingCountBackTrack(threshold, rows, cols, i, j+1, reachMatrix, visitedMatrix);
			movingCountBackTrack(threshold, rows, cols, i, j-1, reachMatrix, visitedMatrix);
		}
	}

	public int getBitSum(int value){
		int sum = 0;
		while (value > 0){
			sum += value%10;
			value = value/10;
		}
		return sum;
	}
}
