package Algorithm.leetcode.repeat;

import java.util.HashMap;

/**
 * Contains Duplicate III
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * @author zhanghr
 *
 */
public class Code220 {
	// time limit exceeded
	public boolean containsNearbyAlmostDuplicate(int[] nums, int distance, int absoluteD) {
		int length = nums.length;
		if (distance == 0 || nums == null || absoluteD < 0) {
			return false;
		}
		for (int i = 1; i < length; i++) {
			int j = Math.max(0, i-distance);
			for ( ; j < i; j++) {
				if (less(nums[i], nums[j],absoluteD)) {
					return true;
				}
			}
		}
		return false;
	}
	

	/**
	 * beat 88.68%
	 * 22ms
	 * @param nums
	 * @param indexDistance
	 * @param valueDistance
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate1(int[] nums, int indexDistance, int valueDistance) {
		int length = nums.length;
		if (indexDistance <= 0 || nums == null || valueDistance < 0) {
			return false;
		}
		HashMap<Long, Integer> set = new HashMap<>(indexDistance);
		int dividor = Math.max(1, valueDistance);
		for (int i = 0; i < length; i++) {
			long value = nums[i]/dividor;
			if ((set.containsKey(value) && Math.abs((long) nums[i] - (long)set.get(value))<= valueDistance)
					|| (set.containsKey(value-1) && Math.abs((long) nums[i] - (long)set.get(value-1))<= valueDistance)
					|| (set.containsKey(value+1)) && Math.abs((long) nums[i] - (long)set.get(value+1))<= valueDistance	) {
				return true;
			}
			if (set.size() == indexDistance) {
				long temp = nums[i-indexDistance]/dividor;
				set.remove(temp);
			}
			set.put(value, nums[i]);
		}
		return false;
	}

	public boolean less(int n, int m, int t) {
		if ( ((n>>31) < 0 || (m>>31) < 0)
				&& ((n>>31) * (m>>31)) == 0 ) {
			if (n > Integer.MAX_VALUE + m || 
					n <= Integer.MIN_VALUE + m) {
				return false;
			}
		}
		return Math.abs(n - m) <= t;
	}

	public static void main(String[] args) {
		Code220 code = new Code220();
		code.test1();
		code.test2();
		code.test3();
		code.test7();
	}
	
	public void test1() {
		int[] nums = new int[] { -1, -1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 0)+","+true);
	}
	
	public void test2() {
		int[] nums = new int[] { -2147483648, 3 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 0)+","+ false);
	}
	

	public void test3() { 
		int[] nums = new int[] { 2147483647, -1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 2147483647)+","+ false);
	}
	
	public void test4() { 
		int[] nums = new int[] { 1, 3, 1 };
		System.out.println(containsNearbyAlmostDuplicate(nums, 1, 1)+","+ false);
	}
	
	public void test5() { 
		int[] nums = new int[] { 1, 3, 1 };
		if (containsNearbyAlmostDuplicate(nums, 2, 1) != true) {
			System.out.println("error");			
			
		}
	}
		
	public void test6() { 
		int[] nums = new int[] { 1, 3, 6, 2 };
		if (containsNearbyAlmostDuplicate(nums, 1, 2) != true) {
			System.out.println("error");			
			
		}
	}
	
	public void test7() { 
		int[] nums = new int[] { 4, 2 };
		if (containsNearbyAlmostDuplicate(nums, 2, 1) != false) {
			System.out.println("error");			
			
		}
	}
}
