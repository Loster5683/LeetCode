package leetcode.editor.cn;

class FindTheMinimumPossibleSumOfABeautifulArray{
    public static void main(String[] args) {
       Solution solution = new FindTheMinimumPossibleSumOfABeautifulArray().new Solution();
       BaseTest.baseTest(solution, "minimumPossibleSum", "3", "3");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //数学题，推公式
    public int minimumPossibleSum(int n, int target) {
        int mod = 1_000_000_000 + 7;
        long m = Math.min(target / 2, n);
        return (int) ((m * (m + 1)  + (n - m - 1 + 2 * target) * (n - m)) / 2 % mod);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}