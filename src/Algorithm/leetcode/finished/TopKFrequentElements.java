package Algorithm.leetcode.finished;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * 
 * For example, Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is
 * the array's size.
 * 
 * @author zhanghr
 *
 */
public class TopKFrequentElements {
	// beat 98.57%
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new List[nums.length + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (Integer key : map.keySet()) {
			int count = map.get(key);
			if (bucket[count] == null)
				bucket[count] = new LinkedList<Integer>();
			bucket[count].add(key);
		}

		List<Integer> result = new ArrayList<Integer>(k);
		for (int i = nums.length; i >= 0 && k > 0; i--) {
			if (bucket[i] != null) {
				result.addAll(bucket[i]);
				k -= bucket[i].size();
			}
		}
		return result;
	}
}
