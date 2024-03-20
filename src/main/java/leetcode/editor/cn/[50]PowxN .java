package leetcode.editor.cn;

import java.math.BigDecimal;

class PowxN{
    public static void main(String[] args) {
       Solution solution = new PowxN().new Solution();
       BaseTest.baseTest(solution, "myPow", "2.00000", "10");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        return n < 0 ? (1 / quickMul(x, n)) : quickMul(x, n);
    }

    private double quickMul(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}