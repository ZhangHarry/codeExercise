package Algorithm.leetcode.finished;

/**
 * Created by zhanghr on 2018/8/23.

 In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

 Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

 Which nodes are eventually safe?  Return them as an array in sorted order.

 The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

 Example:
 Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 Output: [2,4,5,6]
 Here is a diagram of the above graph.

 */
import Algorithm.leetcode.util.Tool;

import java.util.*;
public class FindEventualSafeStates802 {
    // beat 22%，一个很简单的优化--将HashMap转换成数组，因为我们知道数组的大小和元素的值。
    HashMap<Integer, Boolean> map = new HashMap<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        for (int i=0; i<graph.length; i++){
            if (visit(graph,i))
                res.add(i);
        }
        return res;
    }

    public boolean visit(int[][] graph, int index){
        if(graph[index].length==0){
            map.put(index, true);
            return true;
        }else if (map.containsKey(index)){
            if (map.get(index) == null || map.get(index) == false){
                map.put(index,false);
                return false;
            }else{
                return true;
            }
        }else{
            map.put(index, null);
            for (int n : graph[index]){
                if (!visit(graph,n)){
                    map.put(index,false);
                    return false;
                }
            }
        }
        map.put(index, true);
        return true;
    }

    public static void main(String[] args){
        FindEventualSafeStates802 test = new FindEventualSafeStates802();
        int[][] graph = Tool.toIntAA("[[1,2],[2,3],[5],[0],[5],[],[]]");
        test.eventualSafeNodes(graph);
    }
}
