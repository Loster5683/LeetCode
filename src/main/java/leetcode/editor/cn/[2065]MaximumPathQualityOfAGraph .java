package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.*;

class MaximumPathQualityOfAGraph{
    public static void main(String[] args) {
       Solution solution = new MaximumPathQualityOfAGraph().new Solution();
       BaseTest.baseTest(solution, "maximalPathQuality", "[95]", "[]", "83");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int max = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        Map<Integer, Integer>[] next = new HashMap[values.length];
        int n = values.length;
        for (int i = 0; i < n; i++) {
            next[i] = new HashMap<>();
        }
        for (int[] edge : edges) {
            next[edge[0]].put(edge[1], edge[2]);
            next[edge[1]].put(edge[0], edge[2]);
        }

        int[] djsLen = djs(next);
        int[] visit = new int[n];
        Queue<Integer> path = new ArrayDeque<>();
        dfs(0, maxTime, next, values, visit, 0, djsLen);
        return max;
    }

    public void dfs(int start, int leftTimes, Map<Integer, Integer>[] next, int[] values, int[] visit, int ans, int[] djsLen) {
        if (visit[start] == 0) {
            ans += values[start];
        }
        if (start == 0) {
            max = Math.max(ans, max);
        }
        visit[start]++;
        for (Integer sub : next[start].keySet()) {
            if (djsLen[sub] > leftTimes - next[start].get(sub)) {
                continue;
            }
            dfs(sub, leftTimes - next[start].get(sub), next, values, visit, ans, djsLen);
            visit[sub]--;
        }
    }

    private int[] djs(Map<Integer, Integer>[] next) {

        int[] djsLen = new int[next.length];
        for (int i = 0; i < djsLen.length; i++) {
            djsLen[i] = -1;
        }

        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));

        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int id = pair.getKey();
            int dis = pair.getValue();
            if (djsLen[id] != -1) {
                continue;
            }
            djsLen[id] = dis;
            for (Integer nextNode : next[id].keySet()) {
                if (djsLen[nextNode] != -1) {
                    continue;
                }
                queue.offer(new Pair<>(nextNode, next[id].get(nextNode) + dis));
            }
        }
        return djsLen;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}