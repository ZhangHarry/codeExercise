package Algorithm.ProgrammerInterview;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by zhanghr on 2018/7/25.
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。

 给定图中的两个结点的指针DirectedGraphNode* a, DirectedGraphNode* b(请不要在意数据类型，图是有向图),请返回一个bool，
 代表两点之间是否存在一条路径(a到b或b到a)。
 */

public class Path {
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        if (a == b)
            return true;
        return checkPathOneDirection(a, b) || checkPathOneDirection(b, a);
    }

    public boolean checkPathOneDirection(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        if (a == null)
            return false;
        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.add(a);
        HashSet<UndirectedGraphNode> visited = new HashSet<>();
        while (!stack.isEmpty()){
            UndirectedGraphNode cur = stack.pop();
            if ( cur == b)
                return true;
            if (!visited.contains(cur)){
                visited.add(cur);
                for (UndirectedGraphNode next : cur.neighbors){
                    if (!visited.contains(next))
                        stack.push(next);
                }
            }
        }
        return false;
    }
}
