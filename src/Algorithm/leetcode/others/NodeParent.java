package Algorithm.leetcode.others;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhanghr on 2017/4/13.
 */
public class NodeParent {

    public int[] solution(int[] set, int[][] nodeSet, int[] leavesSet, int[][] dijMatrix){
        int nodeNum = set[0];
        int depth = set[1];
        int leavesNum = set[2];
        int[] parent = new int[nodeNum+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }
        parent[0] = 0;
        parent[1] = 0;
        boolean[] visit = new boolean[dijMatrix.length];
        List<Integer> updateIndeies;
        for (int i = depth-1; i > 0 ; i--) {
            updateIndeies = new LinkedList<>();
            int[] upNodes = innerNodes(nodeSet[i-1], leavesSet);
            List<List<Integer>> groups = new ArrayList<>();
            for (int j = 0; j < dijMatrix.length; j++) {
                List<Integer> group = new ArrayList<>();
                if (!visit[j]) {
                    group.add(actualNode(parent, j));
                    for (int k = j+1; k < dijMatrix.length; k++) {
                        if (dijMatrix[j][k] == 2){
                            group.add(actualNode(parent, k));
                            dijMatrix[j][k] = 0;
                            dijMatrix[k][j] = 0;
                            visit[k] = true;
                        }
                    }
                    updateIndeies.add(j);
                    groups.add(group);
                }
            }
            for (int j = 0; j < upNodes.length; j++) {
                List<Integer> group = groups.get(j);
                for (int k = 0; k < group.size(); k++) {
                    parent[group.get(k)] = upNodes[j];
                }
            }
            updateMatrix(dijMatrix, updateIndeies);
        }
        return parent;
    }

    private void updateMatrix(int[][] dijMatrix, List<Integer> updateIndeies) {
        for (int i = 0; i < updateIndeies.size(); i++) {
            for (int j = 0; j < updateIndeies.size(); j++) {
                if (i != j && dijMatrix[i][j] != 0) {
                    dijMatrix[i][j] = dijMatrix[i][j] - 1;
                    dijMatrix[j][i] = dijMatrix[i][j];
                }
            }
        }
    }

    private Integer actualNode(int[] parent, int j) {
        int index = j;
        while (parent[index] != -1)
            index = parent[index];
        return index;
    }

    private int[] innerNodes(int[] nodes, int[] leavesSet) {
        List<Integer> list = new ArrayList<>(nodes.length);
        for (int i = 0; i < nodes.length; i++) {
            boolean out = false;
            for (int j = 0; j < leavesSet.length; j++) {
                if (nodes[i] == leavesSet[j]) {
                    out = true;
                    break;
                }
            }
            if (!out)
                list.add(nodes[i]);
        }
        int[] innerNodes = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            innerNodes[i] = list.get(i);
        }
        return innerNodes;
    }

    public static void main(String[] args){

        NodeParent main = new NodeParent();
        int[] set = new int[]{9,3,5};
        int[][] nodeSet = new int[][]{
                {1},
                {2,3,4},
                {5,6,7,8,9}
        };
        int[] leavesSet = new int[]{5,6,7,8,9};
        int[][] dijMatrix = new int[][]{
                {0,2,4,4,4},
                {2,0,4,4,4},
                {4,4,0,2,4},
                {4,4,2,0,4},
                {4,4,4,4,0}
        };
        int[] parent = main.solution(set, nodeSet, leavesSet, dijMatrix); // 0 1 1 1 2 2 4 4
        for (int i = 1; i < parent.length; i++) {
            System.out.format("%d -> %d%n", i, parent[i]);
        }
    }
}
