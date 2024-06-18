package leetcode.editor.cn;

class VisitArrayPositionsToMaximizeScore{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "maxScore", "[9,58,17,54,91,90,32,6,13,67,24,80,8,56,29,66,85,38,45,13,20,73,16,98,28,56,23,2,47,85,11,97,72,2,28,52,33]", "90");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long[][] maxScore = new long[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            int r = v % 2;
            maxScore[i][r ^ 1] = maxScore[i + 1][r ^ 1];
            maxScore[i][r] = Math.max(maxScore[i + 1][r], maxScore[i + 1][r ^1] - x) + v;
        }
        return maxScore[0][nums[0] % 2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}