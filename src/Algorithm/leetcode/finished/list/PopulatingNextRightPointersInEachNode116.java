package Algorithm.leetcode.finished.list;

import Algorithm.leetcode.util.TreeLinkNode;

/**
 * Created by zhanghr on 2018/9/26.

 Given a binary tree

 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }
 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

 Initially, all next pointers are set to NULL.

 Note:

 You may only use constant extra space.
 Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 Example:

 Given the following perfect binary tree,

 1
 /  \
 2    3
 / \  / \
 4  5  6  7
 After calling your function, the tree should look like:

 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

public class PopulatingNextRightPointersInEachNode116 {

    // beat 100%
    // 看上去很像层次遍历，因为是完全二叉树，所以其实上层和下层是可以同时知道的
    // （在这里的表现就是层次遍历我们需要额外的变量来存储层次信息，如果涉及到上下层消息交换，
    // 比如如果不是完全二叉树就需要额外信息表示上层节点是哪个，但是这里只需要一个变量即可，
    // 因为两层的移动是同时的或者说可以预测的）
    public void connect(TreeLinkNode root) {
        if (root== null)
            return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left !=null){
            TreeLinkNode tmp = pre;
            cur = pre.left;
            while (pre != null){
                cur.next = pre.right;
                pre = pre.next;
                if (pre != null){
                    cur.next.next = pre.left;
                    cur = pre.left;
                }
            }
            pre = tmp.left;
        }
    }
}
