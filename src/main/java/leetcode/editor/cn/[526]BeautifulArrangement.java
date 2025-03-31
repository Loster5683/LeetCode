package leetcode.editor.cn;

import java.util.Arrays;

class BeautifulArrangement{
    public static void main(String[] args) {
        Solution solution = new BeautifulArrangement
            .Solution();
        System.out.println(BaseTest.baseTest(solution, "countArrangement", "2"));
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countArrangement(int n) {
        int memo[] = new int[1 << n];
        Arrays.fill(memo, -1);
        return dfs(0, n, memo);
    }

     public int dfs(int mask, int n, int[] memo) {
        if (mask == (1 << n) - 1) {
            return 1;
        }
        if (memo[mask] != -1) {
            return memo[mask];
        }
        int res = 0;
        int pos = Integer.bitCount(mask) + 1;
        for (int i = 1; i <= n; i++) {
            if (((mask >> i - 1) & 1) == 0 && (i % pos == 0 || pos % i == 0)) {
                res += dfs(mask | 1 << (i - 1), n, memo);
            }
        }
        memo[mask] = res;
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}