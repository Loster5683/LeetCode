package leetcode.editor.cn;


class SellingPiecesOfWood{
    public static void main(String[] args) {
       Solution solution = new SellingPiecesOfWood().new Solution();
       BaseTest.baseTest(solution, "sellingWood", "3", "5", "[[1,4,2],[2,2,7],[2,1,3]]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long sellingWood(int m, int n, int[][] prices) {

        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i < prices.length; i++) {
            dp[prices[i][0]][prices[i][1]] = prices[i][2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int j1 = 1; j1 <= j / 2; j1++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j1] + dp[i][j - j1]);
                }
                for (int i1 = 1; i1 <= i / 2; i1++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i1][j] + dp[i - i1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}