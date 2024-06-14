package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Queue;

class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "findTheCity", "4", "[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]", "4");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int [][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dis[i][j] = i == j ? 0 : 0x3f3f3f3f;
            }
        }
        for (int[] edge : edges) {

            if (dis[edge[0]][edge[1]] > edge[2]) {
                dis[edge[0]][edge[1]] = edge[2];
                dis[edge[1]][edge[0]] = edge[2];
            }
        }

        //floyd计算最短路
        floyd(dis);

        //dijkstra计算最短路
        for (int i = 0; i < n; i++) {
            dijkstra(dis, i);
        }

        int minNum = Integer.MAX_VALUE;
        int maxId = 0;
        for (int i = 0; i < n; i++) {
            int t = 0;
            for (int k = 0; k < n; k++) {
                if (i != k && dis[i][k] <= distanceThreshold) {
                    t++;
                }
            }
            if (t <= minNum) {
                minNum = t;
                maxId = i;
            }
        }
        return maxId;
    }

    private void dijkstra(int[][] dis, int i) {
        int n = dis.length;
        int[] vis = new int[n];
        int[] distTmp = new int[n];
        Arrays.fill(distTmp, 0x3f3f3f3f);
        distTmp[i] = 0;
        for (int j = 0; j < n; j++) {
            int t = -1;
            for (int z = 0; z < n; z++) {
                if (vis[z] == 0 && (t == -1 || distTmp[z] < distTmp[t])) {
                    t = z;
                }
            }
            vis[t] = 1;
            for (int l = 0; l < n; l++) {
                distTmp[l] = Math.min(distTmp[l], distTmp[t] + dis[t][l]);
            }
        }
        dis[i] = distTmp;
    }

    private void floyd(int[][] dis) {
        int n = dis.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                    dis[k][j] = dis[j][k];
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}