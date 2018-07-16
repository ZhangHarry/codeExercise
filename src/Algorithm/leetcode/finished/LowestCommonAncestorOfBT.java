package Algorithm.leetcode.finished;

import java.util.*;

/**
 * Created by zhanghr on 2018/7/13.

 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

 According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants

 (where we allow a node to be a descendant of itself).”

 Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]

 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2       0       8
 /  \
 7   4

 */

public class LowestCommonAncestorOfBT {
    // beat 86%
    // 思路：搜索两次然后去交集
    // 另一种来自讨论区的思路：使用递归，递归lowestCommonAncestor(root.left, p, q)，lowestCommonAncestor(root., p, q)
    // 递归的一个终止条件是root==null||root==p||root==q，返回root。这种做法的策略是在p和q处终止，根据right左递归和有递归不为空证明共同祖先是root，否则就是非空的那个递归。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==q)
            return p;
        LinkedList<TreeNode> path1 =new LinkedList<>();
        path1.add(root);
        search(root, p, path1);
        LinkedList<TreeNode> path2 =new LinkedList<>();
        path2.add(root);
        search(root, q, path2);
        TreeNode ancestor = null;
        Iterator<TreeNode> it1 = path1.iterator();
        Iterator<TreeNode> it2 = path2.iterator();
        while (it1.hasNext() && it2.hasNext()){
            TreeNode n = it1.next();
            if (n == it2.next())
                ancestor = n;
            else
                break;

        }
        return ancestor;
    }

    public boolean search(TreeNode root, TreeNode p, LinkedList<TreeNode> path){
        if (root == p){
            return true;
        }
        if (root == null)
            return false;
        path.add(root.left);
        if (search(root.left, p, path))
            return true;
        path.removeLast();
        path.add(root.right);
        if (search(root.right, p, path))
            return true;
        path.removeLast();
        return false;
    }
}
