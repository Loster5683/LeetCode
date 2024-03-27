package leetcode.editor.cn;

import base.DataStructBuilder;

import java.util.Arrays;

class DesignGraphWithShortestPathCalculator{
    public static void main(String[] args) {
        Graph solution = new Graph(4, DataStructBuilder.init2DIntArray("[[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]"));
        System.out.println(solution.shortestPath(3,2));
        System.out.println(solution.shortestPath(0,3));
        solution.addEdge(DataStructBuilder.initIntArray("[1,3,4]"));
        System.out.println(solution.shortestPath(0, 3));
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Graph {

    int[][] len;
    final static int INF = Integer.MAX_VALUE / 3;
    public Graph(int n, int[][] edges) {
        len = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(len[i], INF);
            len[i][i] = 0;
        }
        for (int[] edge : edges) {
            len[edge[0]][edge[1]] = edge[2];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (len[j][i] == INF) {
                    continue;
                }
                for (int z = 0; z < n; z++) {
                    len[j][z] = Math.min(len[j][z], len[j][i] + len[i][z]);
                }
            }
        }
    }
    public void addEdge(int[] edge) {
        int n = len.length;
        int start = edge[0];
        int end = edge[1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                len[i][j] = Math.min(len[i][j], len[i][start] + edge[2] + len[end][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return len[node1][node2] == INF ? -1 : len[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}