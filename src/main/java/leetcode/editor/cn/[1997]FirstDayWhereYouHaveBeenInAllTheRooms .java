package leetcode.editor.cn;

class FirstDayWhereYouHaveBeenInAllTheRooms{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "firstDayBeenInAllRooms", "[0,1,2,0]");
       BaseTest.baseTest(solution, "firstDayBeenInAllRooms", "[0,0,2]");
       BaseTest.baseTest(solution, "firstDayBeenInAllRooms", "[0,0]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * 第一次到n : f(n)
     * 第一次到n-1 : f(n-1)
     * n-1 = next[n-1] : 1
     * next[n-1]到n-1 : f(n-1) - f(next[n-1])
     * n-1到n 1
     * f(n) = f(n-1) + 1 + f(n-1) - f(next[n-1])
     *
     *
     * @param nextVisit
     * @return
     */
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int MOD = 1_000_000_000 + 7;
        int n = nextVisit.length;
        int[] f = new int[n];
        for (int i = 1; i < n; i++) {
            f[i] = (2 * f[i - 1] + 2 - f[nextVisit[i - 1]]) % MOD;
            if (f[i] < 0) {
                f[i] += MOD;
            }
        }
        return f[n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}