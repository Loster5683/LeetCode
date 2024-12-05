package leetcode.editor.cn;

import java.util.AbstractMap;

import java.util.*;

class MinimumNumberOfVisitedCellsInAGrid{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "minimumVisitedCells", "[[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]");
       BaseTest.baseTest(solution, "minimumVisitedCells", "[[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]");
       BaseTest.baseTest(solution, "minimumVisitedCells", "[[2,1,0],[1,0,0]]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int f = 0;
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> rowQueue = new PriorityQueue<>(Comparator.comparingInt(AbstractMap.SimpleEntry::getKey));
        PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>>[] colQueues = new PriorityQueue[n];
        Arrays.setAll(colQueues, i -> new PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>>(Comparator.comparingInt(AbstractMap.SimpleEntry::getKey)));
        for (int i = 0; i < m; i++) {
            rowQueue.clear();
            for (int j = 0; j < n; j++) {
                while (!rowQueue.isEmpty() && rowQueue.peek().getValue() < j) {
                    rowQueue.poll();
                }
                PriorityQueue<AbstractMap.SimpleEntry<Integer, Integer>> colQueue = colQueues[j];
                while (!colQueue.isEmpty() && colQueue.peek().getValue() < i) {
                    colQueue.poll();
                }
                f = i > 0 || j > 0 ? Integer.MAX_VALUE : 1;
                if (!rowQueue.isEmpty()) {
                    f = rowQueue.peek().getKey() + 1;
                }
                if (!colQueue.isEmpty()) {
                    f = Math.min(f, colQueue.peek().getKey() + 1);
                }
                int g = grid[i][j];
                if (g > 0 && f < Integer.MAX_VALUE) {
                    rowQueue.offer(new AbstractMap.SimpleEntry<>(f, j + g));
                    colQueue.offer(new AbstractMap.SimpleEntry<>(f, i + g));
                }
            }
        }
        return f == Integer.MAX_VALUE ? -1 : f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}