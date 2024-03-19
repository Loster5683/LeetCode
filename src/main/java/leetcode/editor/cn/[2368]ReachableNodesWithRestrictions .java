package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReachableNodesWithRestrictions{
    public static void main(String[] args) {
       Solution solution = new ReachableNodesWithRestrictions().new Solution();
       BaseTest.baseTest(solution, "reachableNodes", "7", "[[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]]", "[4,5]");
       BaseTest.baseTest(solution, "reachableNodes", "7", "[[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]]", "[4,2,1]");
       BaseTest.baseTest(solution, "reachableNodes", "2", "[[0,1]]", "[1]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        Set<Integer>[] res = new Set[n];
        for (int i = 0; i < n; i++) {
            res[i] = new HashSet<>();
        }

        Set<Integer> blocks = new HashSet<>();
        for (int i : restricted) {
            blocks.add(i);
        }
        for (int[] edge : edges) {
            if (blocks.contains(edge[0]) || blocks.contains(edge[1])) {
                continue;
            }
            res[edge[0]].add(edge[1]);
            res[edge[1]].add(edge[0]);
        }
        int[] visited = new int[n];
        dfs(res, 0, visited);
        return Arrays.stream(visited).sum();
    }

    private void dfs(Set<Integer>[] res, int start, int[] visited) {
        if (visited[start] == 0) {
            visited[start] = 1;
        }
        if (res[start] == null) {
            return;
        }
        for (int next : res[start]) {
            if (visited[next] != 0) {
                continue;
            }
            dfs(res, next, visited);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}