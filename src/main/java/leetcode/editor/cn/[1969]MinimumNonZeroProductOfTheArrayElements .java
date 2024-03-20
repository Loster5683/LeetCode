package leetcode.editor.cn;

class MinimumNonZeroProductOfTheArrayElements{
    public static void main(String[] args) {
       Solution solution = new MinimumNonZeroProductOfTheArrayElements().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minNonZeroProduct(int p) {
        int mod = 1000000000 + 7;
        long tmp = (1L << p) - 1;

        //传p-1因为2^（p-1) - 1所有位都是1，而且长度为p-1;
        return (int) (((tmp % mod) * quickMul(tmp - 1, p - 1, mod)) % mod);
    }

    private long quickMul(long x, int n, int mod) {
        if (n == 0) {
            return 1;
        }
        x %= mod;
        long res = 1;
        while (n-- > 0) {
            res = res * x % mod;
            x = x * x % mod;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}