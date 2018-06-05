package Algorithm.aimAtOffer;

/**
 * Created by zhanghr on 2018/4/27.
 */
import java.util.*;
public class Serialize {

    String Serialize(TreeNode root) {
    if (root == null)
        return "";
    String str = "";
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()){
        TreeNode node = stack.pop();
        if (node == null)
            str += "#,";
        else {
            str += node.val+",";
            stack.push(node.right);
            stack.push(node.left);
        }
    }
    return str;
}

    TreeNode Deserialize(String str) {
        if (str.length() == 0)
            return null;
        String[] array = str.split(",");
        Pair pair = Deserialize(array, 0, array.length-1);
        return pair.node;
    }

    Pair Deserialize(String[] array, int start,int end) {
        if (array[start].equals("#"))
            return new Pair(null, start);
        TreeNode node = new TreeNode(Integer.parseInt(array[start]));
        Pair p1 = Deserialize(array, start+1, end);
        node.left = p1.node;
        if (p1.index+1 == end){
            node.right = null;
            return new Pair(node, end);
        }else {
            Pair p2 = Deserialize(array, p1.index+1, end);
            node.right = p2.node;
            return new Pair(node, p2.index);
        }
    }

    public static void main(String[] args){
        Serialize test = new Serialize();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        String str = test.Serialize(root);
        TreeNode node = test.Deserialize(str);
        System.out.println(node);
    }
}

class Pair{
    TreeNode node;
    int index;

    Pair(TreeNode node, int index){
        this.node = node;
        this.index = index;
    }
}
