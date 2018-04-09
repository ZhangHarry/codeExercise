package Algorithm.leetcode.finished.backTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number
 * (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [2, 3, 6, 7] and target 7,
 * 
 * [ [7], [2, 2, 3] ]
 * 
 * @author zhanghr
 *
 */
public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum test = new CombinationSum();
		int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
		test.combinationSum(candidates, 8);
	}
	// beat 78.55%
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<>();
		backTrack(list, candidates, 0, target, new LinkedList<Integer>());
		return list;
	}

	public void backTrack(List<List<Integer>> list, int[] candidates, int index, int target,
			LinkedList<Integer> linkedList) {
		// end condition
		if (target == 0)
			list.add(new LinkedList<>(linkedList));
		if (index == candidates.length)
			return;
		if (target < 0)
			return;

		// for each possible choice, try it
		for (int i = index; i < candidates.length; i++) {
			// update state
			int can = candidates[i];
			linkedList.add(can);
			
			// track deeper, because could repeat again, keep index
			backTrack(list, candidates, i, target - can, linkedList);
			
			// linkedList is the recorder, restore state
			linkedList.removeLast();
		}
	}
}
