package Algorithm.leetcode.finished;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *         1
 *       / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 *   But the following [1,2,2,null,3,null,3] is not:
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *   Note:
 *   Bonus points if you could solve it both recursively and iteratively.

 * Created by zhanghr on 2016/12/19.
 */
public class Code101 {

    /**
     * 2ms
     * beat 12.4%
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> leftList = new LinkedList<>();
        Queue<TreeNode> rightList = new LinkedList<>();
        if (compare(root.left, root.right)){
            TreeNode left = root.left, right = root.right;
            if (left != null)
                leftList.add(left);
            if (right != null)
                rightList.add(right);
            while (leftList.size() > 0 && rightList.size() > 0) {
                LinkedList<TreeNode> lefts = new LinkedList<>();
                LinkedList<TreeNode> rights = new LinkedList<>();
                while (leftList.size() > 0 && rightList.size() > 0) {
                    left = leftList.poll();
                    right = rightList.poll();
                    if (!compare(left, right))
                        return false;
                    else {
                        if (left != null) {
                            if (!compare(left.left, right.right) || !compare(left.right, right.left))
                                return false;
                            lefts.add(left.left);
                            lefts.add(left.right);
                            rights.add(right.right);
                            rights.add(right.left);
                        }
                    }
                }
                if (leftList.size() != 0  || rightList.size() != 0)
                    return false;
                else {
                    leftList = lefts;
                    rightList = rights;
                }
            }
            if (leftList.size() == 0  && rightList.size() == 0)
                return true;
            else
                return false;
        }else
            return false;
    }


    /**
     * 1ms
     * beats 24%
     * 改进的地方可能在于减少调用函数
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (!compare(left, right))
            return false;
        else if (left != null){
            return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }else
            return true;
    }


    /**
     * 2ms
     * 改进的地方在于只用一个List就可以
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return true;
        if (!compare(root.left, root.right))
            return false;
        else if (root.left != null){
            LinkedList<TreeNode> lefts = new LinkedList<>();
            LinkedList<TreeNode> rights = new LinkedList<>();
            lefts.add(root.left.left);
            lefts.add(root.left.right);
            rights.add(root.right.right);
            rights.add(root.right.left);
            return isSymmetricIte(lefts, rights);
        }
        else
            return true;
    }

    private boolean isSymmetricIte(LinkedList<TreeNode> leftList, LinkedList<TreeNode> rightList) {
        LinkedList<TreeNode> lefts = new LinkedList<>();
        LinkedList<TreeNode> rights = new LinkedList<>();
        while (leftList.size() > 0 && rightList.size() > 0) {
            TreeNode left = leftList.poll();
            TreeNode right = rightList.poll();
            if (!compare(left, right))
                return false;
            else {
                if (left != null) {
                    if (!compare(left.left, right.right) || !compare(left.right, right.left))
                        return false;
                    if (left.left != null) {
                        lefts.add(left.left);
                        rights.add(right.right);
                    }
                    if (left.right != null) {
                        lefts.add(left.right);
                        rights.add(right.left);
                    }
                }
            }
        }
        if (leftList.size() != 0  || rightList.size() != 0)
            return false;
        else if (lefts.size()>0){
            return isSymmetricIte(lefts, rights);
        }else
            return true;
    }

    private boolean compare(TreeNode left, TreeNode right){
        if (left == null && right == null){
            return true;
        }else if (left != null && right != null){
            if (left.val == right.val)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        Code101 obj = new Code101();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);


        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.right = new TreeNode(4);
        root1.right.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(4);

        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(3);
        root3.right = new TreeNode(3);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        root3.right.left = new TreeNode(5);
        root3.right.right = new TreeNode(4);
        root3.left.right.left = new TreeNode(8);
        root3.left.right.right = new TreeNode(9);
        root3.right.left.left = new TreeNode(9);
        root3.right.left.right = new TreeNode(8);

//        System.out.println(obj.isSymmetric2(root));
//        System.out.println(obj.isSymmetric2(root1));
        System.out.println(obj.isSymmetric2(root2));
//        System.out.println(obj.isSymmetric2(root3));
    }
}

