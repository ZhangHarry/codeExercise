package Algorithm.leetcode.finished.dp;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 * 
 * For example, Given [10, 9, 2, 5, 3, 7, 101, 18], The longest increasing
 * subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may
 * be more than one LIS combination, it is only necessary for you to return the
 * length.
 * 
 * Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 * 
 * @author zhanghr
 *
 */
public class LongestIncreasingSubsequence {
	// beat 99.57%, nlogn
	public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length]; // tail[i]存储了所有长度为i+1的路径的最后一项中的最小值
        int size = 0;
        for (int i=0;i<nums.length;i++){
        	 //tail是个从小到大的数组，所以可以二分查找：遇到一个新值，判断它在tail中的位置，如果它比最大值大，表示找到一个长度加1的路径；
        	 // 如果tail[i-1]<value<=tail[i], 则tail[i]=value，保证了tail的大小顺序
            int index = binarySearch(tail, 0, size-1, nums[i]);
            if (index == size) // 比所有原来的路径都大，所以长度加1，tail[length]的值已经在binarySearch中设置
                size++;
        }
        return size;
    }
    
    public int binarySearch(int[]tail, int start, int end, int value){
        if (end<0 || value > tail[end]){
            end++;
            tail[end] = value;
            return end;
        }
        if (value <= tail[start]){
            tail[start] = value;
            return start;
        }
        while (start < end-1){
            int median = (start+end)/2;
            if (tail[median] ==  value)
                return median;
            if (tail[median] < value)
                start = median;
            else
                end = median;
        }
        if (tail[end] >= value){
            tail[end] = value;
        }
        return end;
            
    }
}
