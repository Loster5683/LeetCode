package leetcode.editor.cn;

import java.util.Stack;

class MaximumScoreOfAGoodSubarray{
    public static void main(String[] args) {
       Solution solution = new MaximumScoreOfAGoodSubarray().new Solution();
       BaseTest.baseTest(solution, "maximumScore", "[6569,9667,3148,7698,1622,2194,793,9041,1670,1872]", "5");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    //双指针做法
    public int maximumScore1(int[] nums, int k) {
        int i = k;
        int j = k;
        int maxScore = nums[k];
        int height = nums[k];
        for (int z = 0; z < nums.length - 1; z++) {
            height = Math.min(Math.min(nums[i], nums[j]), height);
            maxScore = Math.max((j - i + 1) * height, maxScore);
            if (j == nums.length - 1 || i > 0 && nums[i - 1] >= nums[j + 1]) {
                height = Math.min(height, nums[--i]);
            } else {
                height = Math.min(height, nums[++j]);
            }
            maxScore = Math.max((j - i + 1) * height, maxScore);
        }
        return maxScore;
    }

    //单调栈做法
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxScore = 0;
        Stack<Integer> queue = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peek()] >= nums[i]) {
                queue.pop();
            }
            left[i] = queue.isEmpty() ? -1 : queue.peek();
            queue.add(i);
        }
        queue.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && nums[queue.peek()] >= nums[i]) {
                queue.pop();
            }
            right[i] = queue.isEmpty() ? n : queue.peek();
            queue.add(i);
        }
        for (int i = 0; i < n; i++) {
            int leftIndex = left[i];
            int rightIndex = right[i];
            if (leftIndex < k && rightIndex > k) {
                maxScore = Math.max(maxScore, (rightIndex - leftIndex - 1) * nums[i]);
            }
        }
        return maxScore;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}