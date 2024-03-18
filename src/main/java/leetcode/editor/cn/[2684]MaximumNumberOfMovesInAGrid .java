package leetcode.editor.cn;

class MaximumNumberOfMovesInAGrid{
    public static void main(String[] args) {
       Solution solution = new MaximumNumberOfMovesInAGrid().new Solution();
       BaseTest.baseTest(solution, "maxMoves", "[[187,167,209,251,152,236,263,128,135],[267,249,251,285,73,204,70,207,74],[189,159,235,66,84,89,153,111,189],[120,81,210,7,2,231,92,128,218],[193,131,244,293,284,175,226,205,245]]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                for (int z = i - 1; z <= i + 1; z++) {
                    if (z < 0 || z >= m ) {
                        continue;
                    }
                    if (dp[z][j - 1] != -1 && grid[z][j - 1] < grid[i][j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[z][j - 1] + 1);
                    } else {
                        dp[z][j] = Math.max(dp[z][j], -1);
                    }
                }
            }
        }
        int maxValue = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}