package Algorithm.ProgrammerInterview;

import java.util.ArrayList;

/**
 * Created by zhanghr on 2018/7/25.
 */

public class UndirectedGraphNode {
    int label = 0;
    UndirectedGraphNode left = null;
    UndirectedGraphNode right = null;
    ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

    public UndirectedGraphNode(int label) {
        this.label = label;
    }
}
