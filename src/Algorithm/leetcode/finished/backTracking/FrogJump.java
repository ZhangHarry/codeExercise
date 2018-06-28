package Algorithm.leetcode.finished.backTracking;

import java.util.HashSet;

/**
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. The frog can jump on a stone, but it must not jump into the water.

 Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.

 If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog can only jump in the forward direction.

 Note:

 The number of stones is ≥ 2 and is < 1,100.
 Each stone's position will be a non-negative integer < 231.
 The first stone's position is always 0.
 Example 1:

 [0,1,3,5,6,8,12,17]

 There are a total of 8 stones.
 The first stone at the 0th unit, second stone at the 1st unit,
 third stone at the 3rd unit, and so on...
 The last stone at the 17th unit.

 Return true. The frog can jump to the last stone by jumping
 1 unit to the 2nd stone, then 2 units to the 3rd stone, then
 2 units to the 4th stone, then 3 units to the 6th stone,
 4 units to the 7th stone, and 5 units to the 8th stone.
 Example 2:

 [0,1,2,3,4,8,9,11]

 Return false. There is no way to jump to the last stone as
 the gap between the 5th and 6th stone is too large.
 */
public class FrogJump {
	/**
	 * beat 78.47%, but only 39 test cases in leetcode
	 *
	 * 思路：backtrack（与dfs很相似，但是backtrack使用递归，dfs使用迭代，用stack后进先出的特性就可以实现，效率上还是dfs要高点，backtrack的过程中还可以记录数据，dfs一般只需要最终结果），
	 * 用HashSet保存下已经测试过的路径（重复的路径应该不少，k,k-1,(k,k-1,k-1) 与 k-1,k,(k,k-1,k+1)后面重合的路径就有2/3），这种保存的策略也可以说是智慧搜索
	 *
     * @param stones: a list of stones' positions in sorted ascending order
     * @return: true if the frog is able to cross the river or false
     */
    public boolean canCross(int[] stones) {
        // write your code here
        if (stones.length<=1)
            return true;
        if (stones[1] != 1)
        	return false;
        return backTrack(stones, 1, 1);
    }
    
    int[] update = new int[]{-1,0,1};
    HashSet<String> visited = new HashSet<>();
    private boolean backTrack(int[] stones, int step, int index){
    	if (index == stones.length-1)
    			return true;
    	if (index >= stones.length)
    			return false;
    	int curStone = stones[index];
        for (int i=0; i<update.length; i++){
        	int nStep = step+update[i];
        	if (nStep<=0)
        		continue;
            int nextStone = curStone + nStep;
            int nIndex = findIndex(stones, index, nextStone);
            if (visited.contains(nIndex+","+nStep))
            	;
            else if (backTrack(stones, nStep, nIndex))
            	return true;
        }
        visited.add(index+","+step);
        return false;
    }

	private int findIndex(int[] stones, int index, int nextStone) {
		// TODO Auto-generated method stub
		int start = index, end = stones.length-1;
		if (stones[start] == nextStone)
			return start;
		if (stones[end] < nextStone || stones[start] > nextStone)
			return end+1;
		if (stones[end] == nextStone)
			return end;
		while (true){
			int median = start + (end-start)/2;
			if (stones[median] == nextStone)
				return median;
			else if (stones[median] < nextStone)
				start = median;
			else
				end = median;
			if (start+1==end)
				break;
		}
		return stones.length;
	}
	public static void main(String[] args) {
		FrogJump test = new FrogJump();
		int[] stones = new int[]{0,1,3,5,6,8,12,17};
		System.out.println(test.canCross(stones));
		stones = new int[]{0,1,2,3,4,8,9,11};
		System.out.println(test.canCross(stones));
		
	}
}
