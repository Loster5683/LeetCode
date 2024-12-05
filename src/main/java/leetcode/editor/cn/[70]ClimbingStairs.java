package leetcode.editor.cn;

class ClimbingStairs{
    public static void main(String[] args) {
        Solution solution = new ClimbingStairs
            .Solution();
        BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int memo[] = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}