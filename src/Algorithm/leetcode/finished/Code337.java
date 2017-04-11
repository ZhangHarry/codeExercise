package Algorithm.leetcode.finished;

import java.util.HashMap;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 *
 * Created by zhanghr on 2016/12/14.
 */
public class Code337 {

    /**
     * out of time
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int sum1 = rob(root, false);
        int sum2 = rob(root, true) ;
        return sum1 > sum2 ? sum1 : sum2;
    }

    private int rob(TreeNode root, boolean tag){
        if (root == null)
            return 0;
        if (tag){
            return root.val + rob(root.left, false) + rob(root.right, false);
        }else
            return rob(root.left) + rob(root.right);
    }

    /**
     * 124 / 124 test cases passed.
     * Status: Accepted
     * Runtime: 1161 ms
     * beats 3.19%
     * @param root
     * @return
     */
    public int rob1(TreeNode root) {
        if (root == null)
            return 0;
        int sum1 = root.val + (root.left == null ? 0:rob(root.left.left)+rob(root.left.right)) +
                (root.right == null ? 0:rob(root.right.left)+rob(root.right.right));
        int sum2 = rob(root.left) + rob(root.right);
        return sum1 > sum2 ? sum1 : sum2;
    }

    /**
     * 124 / 124 test cases passed.
     * Status: Accepted
     * Runtime: 13 ms
     * beats 29.47%
     */
    HashMap<TreeNode, Integer> map = new HashMap<>();
    public int rob2(TreeNode root) {
        if (root == null)
            return 0;
        Integer left,right;
        if ((left = map.get(root.left)) == null){
            left = rob(root.left);
            map.put(root.left, left);
        }
        if ((right = map.get(root.right)) == null){
            right = rob(root.right);
            map.put(root.right, right);
        }
        int sum1 = root.val + (root.left == null ? 0:rob(root.left.left)+rob(root.left.right)) +
                (root.right == null ? 0:rob(root.right.left)+rob(root.right.right));
        int sum2 = left + right;
        return sum1 > sum2 ? sum1 : sum2;
    }


    /**
     * 124 / 124 test cases passed.
     * Status: Accepted
     * Runtime: 12 ms
     * beats 30.47%
     */
    HashMap<TreeNode, Integer> mapInclude = new HashMap<>();
    HashMap<TreeNode, Integer> mapExclude = new HashMap<>();
    public int rob3(TreeNode root) {
        if (root == null)
            return 0;
        Integer leftIn,rightIn, leftEx, rightEx;
        leftIn = getIn(root.left);
        rightIn = getIn(root.right);
        leftEx = getEx(root.left);
        rightEx = getEx(root.right);
        int sum1 = root.val + (root.left == null ? 0:leftEx) +
                (root.right == null ? 0:rightEx);
        int sum2 = leftIn + rightIn;
        return sum1 > sum2 ? sum1 : sum2;
    }

    private Integer getEx(TreeNode node) {
        if (node == null)
            return 0;
        Integer ex;
        if ((ex = mapExclude.get(node)) == null) {
            ex = getIn(node.left) + getIn(node.right);
            mapExclude.put(node, ex);
        }
        return ex;
    }

    private Integer getEx1(TreeNode node) {
        if (node == null)
            return 0;
        Integer ex;
        if (!mapExclude.containsKey(node)) {
            ex = getIn(node.left) + getIn(node.right);
            mapExclude.put(node, ex);
            return ex;
        }else
            return mapExclude.get(node);
    }

    private Integer getIn(TreeNode node) {
        Integer in;
        if ((in = mapInclude.get(node)) == null){
            in = rob(node);
            mapInclude.put(node, in);
        }
        return in;
    }

    private Integer getIn1(TreeNode node) {
        Integer in;
        if (!mapInclude.containsKey(node)){
            in = rob(node);
            mapInclude.put(node, in);
            return in;
        }else
            return mapInclude.get(node);
    }

    public static void main(String[] args){
        new Code337().case3();
        new Code337().case2();
        new Code337().case1();
    }

    public void case1(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(rob3(root));
    }

    public void case2(){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        System.out.println(rob3(root));
    }

    public void case3(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(3);
        System.out.println(rob3(root));
    }
}
