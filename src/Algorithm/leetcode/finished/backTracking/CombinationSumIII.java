package Algorithm.leetcode.finished.backTracking;

import java.util.*;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * 
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author zhanghr
 *
 */
public class CombinationSumIII {
	public static void main(String[] args) {
		CombinationSumIII test = new CombinationSumIII();
		test.combinationSum3(3, 7);
		test.combinationSum3(3, 9);
	}
	/**
	 * best 43.75%
	 * @param k number of num
	 * @param n target sum
	 * @return
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new LinkedList<>();
		if (n <= 0 || k <=0 || n > (19-k)*k/2)
			return result;
		List<Integer> candidates = new LinkedList<>();
		for (int i =1;i<=9;i++){
			candidates.add(i);
		}
		backTrack(result, candidates, k, n, new LinkedList<>(), 0);
		return result;
	}

	private void backTrack(List<List<Integer>> result, List<Integer> candidates, int k, int n, LinkedList<Integer> list, int index) {
		if (k==0){ // no choice, if bingo record it, otherwise return
			if (n == 0)
				result.add(new LinkedList<>(list));
			return;
		}
		if (candidates.size() == 0) // no choice, return
			return;
		if (n <= 0) // no possible,return 
			return;
		
		for (int i = index; i < candidates.size(); i++){
			Integer can = candidates.get(i);
			list.add(can);
			backTrack(result, candidates, k-1, n-can, list, i+1);
			list.removeLast();
		}
		
	}
}
