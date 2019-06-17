package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/9/6.
 */
import java.util.*;
public class InOrderVisit {
    // 这里没有使用visited的结构来表示Stack里面的元素是否被访问过，因为Stack里面的都没被访问过，通过cur来表示可以直接添加的元素，Stack里的元素全部都需要取出left、right进行处理。
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null){
            if (cur.left == null){
                list.add(cur.val);
                cur = cur.right;
                while (cur==null && !stack.isEmpty()){
                    cur=stack.pop();
                    list.add(cur.val);
                    cur = cur.right;
                }
            }else{
                stack.push(cur);
                cur = cur.left;
            }
        }
        return list;
    }
}
