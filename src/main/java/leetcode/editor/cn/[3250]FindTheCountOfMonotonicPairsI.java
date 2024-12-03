package leetcode.editor.cn;

import base.DataStructBuilder;

import java.util.Arrays;

class FindTheCountOfMonotonicPairsI{
    public static void main(String[] args) {
       Solution solution = new Solution();
        System.out.printf(BaseTest.baseTest(solution, "countOfPairs", "[40,40,40,40,41,42,43,44,45,45]").toString());;
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        int m = Arrays.stream(nums).max().getAsInt();
        long[][] dp = new long[n][m + 1];
        for (int i = 0; i <= nums[0]; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int s = 0; s <= nums[i]; s++) {
                for (int z = 0; z <= s; z++) {
                    if (nums[i] - s <= nums[i - 1] - z) {
                        dp[i][s] += dp[i - 1][z];
                        dp[i][s] %= 1000000007;
                    }
                }
            }
        }
        return (int) (Arrays.stream(dp[n-1]).sum() % 1000000007);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}