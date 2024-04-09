package leetcode.editor.cn;

class MaximumCountOfPositiveIntegerAndNegativeInteger{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumCount(int[] nums) {
        int[] res = maxCount(nums, 0, nums.length - 1);
        return Math.max(res[0], res[1]);
    }

    private int[] maxCount(int[] nums, int start, int end) {
        if (start == end) {
            if (nums[start] < 0) {
                return new int[]{1,0};
            } else if (nums[start] > 0) {
                return new int[]{0,1};
            } else {
                return new int[2];
            }
        } else {
            int mid = (start + end) / 2;
            int[] left = maxCount(nums, start, mid);
            int[] right = maxCount(nums, mid + 1, end);
            left[0] += right[0];
            left[1] += right[1];
            return left;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}