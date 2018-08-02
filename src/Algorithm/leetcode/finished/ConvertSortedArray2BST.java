package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/2.
 Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

 For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

 Example:

 Given the sorted array: [-10,-3,0,5,9],

 One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

 0
 / \
 -3   9
 /   /
 -10  5
 */

public class ConvertSortedArray2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start,int end) {
        if (start > end || start < 0)
            return null;
        if (start == end)
            return new TreeNode(nums[start]);
        int mid = start + (end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, end);
        return node;
    }
}
