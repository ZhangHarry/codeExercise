package Algorithm.ProgrammerInterview;

/**
 * Created by zhanghr on 2018/7/23.
 */
import Algorithm.leetcode.util.ListNode;
import Algorithm.leetcode.util.TreeNode;

import java.util.*;
public class TreeLevel {

    public ListNode getTreeLevel(TreeNode root, int dep) {
        // write code here
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        dep--;
        while(dep>0){
            LinkedList<TreeNode> tmp = new LinkedList<>();
            while(list.size()>0){
                TreeNode cur = list.get(0);
                list.removeFirst();
                if (cur.left!=null){
                    tmp.add(cur.left);
                }
                if (cur.right!=null){
                    tmp.add(cur.right);
                }
            }
            list = tmp;
            dep--;
        }
        ListNode head = new ListNode(list.get(0).val);
        ListNode cur = head;
        list.removeFirst();
        while(!list.isEmpty()){
            ListNode next = new ListNode(list.get(0).val);
            cur.next = next;
            cur = next;
            list.removeFirst();
        }
        return head;
    }
}
