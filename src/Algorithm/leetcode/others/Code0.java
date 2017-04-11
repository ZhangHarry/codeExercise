package Algorithm.leetcode.others;

/**
 * Created by zhanghr on 2017/3/31.
 */
public class Code0 {
    int nodeNum, depth, leavesNum;
    int[] depthSet; // 每一层的节点个数
    int[][] nodeSet; // 每一层的节点集合（从左往右）
    int[] leavesSet; // 叶子节点集合（从左往右）
    int[][] dijMatrix; // 节点间的距离（横纵顺序就是上面的叶子节点顺序）
    public void solution(int[] set, int[] depthSet, int[][] nodeSet, int[] leavesSet, int[][] dijMatrix){
        this.nodeNum = set[0];
        this.depth = set[1];
        this.leavesNum = set[2];
        int[] parent = new int[nodeNum];
        parent[0] = 0;
        for (int i = depth-1; i > 0 ; i--) {
            int[] innerNodes = innerNodes(nodeSet[i], leavesSet);
            int innerNodeIndex = 0;
            for (int j = 0; j < dijMatrix.length; j++) {
                for (int k = j+1; k < dijMatrix.length; k++) {
                    if (dijMatrix[j][k] == 2){
                        if (parent[leavesSet[j]] == 0){
                            parent[leavesSet[j]] = innerNodes[innerNodeIndex];
                            parent[leavesSet[k]] = parent[leavesSet[j]];
                            innerNodeIndex++;
                        }else {
                            parent[leavesSet[k]] = parent[leavesSet[j]];
                        }
                    }
                }
            }
            dijMatrix = update(dijMatrix);
        }
    }

    private int[][] update(int[][] dijMatrix) {
        for (int i = 0; i < dijMatrix.length; i++) {
            for (int j = 0; j < dijMatrix.length; j++) {
                if (dijMatrix[i][j] == 2)
                    dijMatrix[i][j] = 0;
                else if (dijMatrix[i][j] > 2)
                    dijMatrix[i][j] = dijMatrix[i][j]-1;
            }
        }
        return dijMatrix;
    }

    private int[] innerNodes(int[] ints, int[] leavesSet) {
        return new int[0];
    }
}
