package leetcode.editor.cn;
class TheEmployeeThatWorkedOnTheLongestTask{
    public static void main(String[] args) {
       Solution solution = new TheEmployeeThatWorkedOnTheLongestTask().new Solution();
       BaseTest.baseTest(solution, "hardestWorker", "26", "[[1,1],[3,7],[2,12],[7,17]]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int s = logs.length;
        int maxCostTime = 0;
        int minCostId = n - 1;
        for (int i = 0; i < s; i++) {
            int costTime = (i == 0) ? logs[i][1] : logs[i][1] - logs[i-1][1];
            if (costTime > maxCostTime) {
                maxCostTime = costTime;
                minCostId = logs[i][0];
            } else if (costTime == maxCostTime) {
                minCostId = Math.min(logs[i][0], minCostId);
            }
        }
        return minCostId;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}