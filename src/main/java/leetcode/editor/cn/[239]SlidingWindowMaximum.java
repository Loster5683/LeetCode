package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class SlidingWindowMaximum{
    public static void main(String[] args) {
       Solution solution = new SlidingWindowMaximum().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int [] max = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k ) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
            max[i] = nums[deque.peekFirst()];
        }
        return Arrays.copyOfRange(max, k - 1, nums.length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}