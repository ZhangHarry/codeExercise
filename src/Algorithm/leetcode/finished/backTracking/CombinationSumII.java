package Algorithm.leetcode.finished.backTracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note: All numbers (including target) will be positive integers. The solution
 * set must not contain duplicate combinations. For example, given candidate set
 * [10, 1, 2, 7, 6, 1, 5] and target 8, A solution set is: 
 * [ [1, 7], [1, 2, 5],
 * [2, 6], [1, 1, 6] ]
 * 
 * 
 * @author zhanghr
 *
 */
public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII test = new CombinationSumII();
		int[] candidates = new int[] { 10, 1, 2, 7, 6, 1, 5, 1 };
		test.combinationSum2(candidates, 8);
	}

	// beat 33%
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<>();
		Arrays.sort(candidates);
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
			// candidates is sorted, for the same index, repeat choice should be skipped
			if (i > index && candidates[i] == candidates[i - 1])
				continue;
			
			// update state
			int can = candidates[i];
			linkedList.add(can);
			
			// track deeper
			backTrack(list, candidates, i + 1, target - can, linkedList);
			
			// restore state
			linkedList.removeLast();
		}
	}
}
