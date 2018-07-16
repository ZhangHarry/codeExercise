package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/7/15.
 *
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

 Formally the function should:
 Return true if there exists i, j, k
 such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 Your algorithm should run in O(n) time complexity and O(1) space complexity.

 Examples:
 Given [1, 2, 3, 4, 5],
 return true.

 Given [5, 4, 3, 2, 1],
 return false.

 */

public class IncreasingTripletSubsequence {
    // beat 100%
    // 思路：题目只需要找出一个符合条件的三元组，如果找一个二元组，一次遍历即可，可以认为在遍历过程中传递了大小关系。
    // 值得注意的地方，一方面是遇到小的值进行替换，另一方面，解法和二元组的一样，我们看到可能存在n1<n2，但n1的index大于n2的index的情况，但是不影响我们的结论，
    // 因为第三个值大于前两个值，如果n3>n2>n1，即使n1的index大于n2的index，我们也可以找到一个n1的index小于n2。
    // 在计算过程中n1\n2的index顺序遭到破坏，但是不影响最终结论，因为n3是最值，大于前面所有值，可以允许index顺序被破坏，
    // 另外n2的出现已经保证了一个可选的n1，更新次序保证了这点
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<=2)
            return false;
        int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
        for (int num : nums){
            if (num <= n1){
                n1 = num;
            }else if(num <=n2){
                n2 = num;
            }else
                return true;
        }
        return false;
    }
}
