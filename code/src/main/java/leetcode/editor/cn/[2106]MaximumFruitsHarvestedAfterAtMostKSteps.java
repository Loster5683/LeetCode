package leetcode.editor.cn;
class MaximumFruitsHarvestedAfterAtMostKSteps{
    public static void main(String[] args) {
       Solution solution = new MaximumFruitsHarvestedAfterAtMostKSteps().new Solution();
       BaseTest.baseTest(solution, "maxTotalFruits", "[[20000,10000]]", "20000", "0");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = leftBound(fruits, startPos - k);
        int n = fruits.length;
        int max = 0;
        int sum = 0;
        for (int right = left; right < n && fruits[right][0] <= startPos + k; right++) {
            sum += fruits[right][1];
            while (2 * fruits[right][0] - startPos - fruits[left][0] > k
                    && startPos - 2 * fruits[left][0] + fruits[right][0] > k) {
                sum -= fruits[left++][1];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    private int leftBound(int[][] fruits, int i) {
        int left = -1;
        int right = fruits.length;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (fruits[mid][0] >= i) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}