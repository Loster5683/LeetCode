package leetcode.editor.cn;

import java.util.*;

class MinimumHeightTrees{
    public static void main(String[] args) {
       Solution solution = new MinimumHeightTrees().new Solution();
       BaseTest.baseTest(solution, "findMinHeightTrees", "6", "[[3,0],[3,1],[3,2],[3,4],[5,4]]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        Map<Integer, Set<Integer>> len = new HashMap<>();
        Set<Integer> allNode = new HashSet<>();
        int[] index = new int[n];
        for (int[] edge : edges) {
            len.putIfAbsent(edge[0], new HashSet<>());
            len.putIfAbsent(edge[1], new HashSet<>());
            len.get(edge[0]).add(edge[1]);
            len.get(edge[1]).add(edge[0]);
            allNode.add(edge[0]);
            allNode.add(edge[1]);
            index[edge[0]]++;
            index[edge[1]]++;
        }

        Queue<Integer> removeNodes = new ArrayDeque<>();
        for (Integer addNode : allNode) {
            if (index[addNode] == 1) {
                removeNodes.offer(addNode);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!removeNodes.isEmpty()) {
            ans.clear();
            int nnn = removeNodes.size();
            for (int i = 0; i < nnn; i++) {
                Integer removeNode = removeNodes.poll();
                ans.add(removeNode);
                for (Integer integer : len.get(removeNode)) {
                    if (--index[integer] == 1) {
                        removeNodes.offer(integer);
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}