package leetcode.editor.cn;
import java.util.AbstractMap;

import java.util.ArrayDeque;
import java.util.Deque;

class ShortestSubarrayWithSumAtLeastK{
    public static void main(String[] args) {
        Solution solution = new ShortestSubarrayWithSumAtLeastK().new Solution();
        BaseTest.baseTest(solution, "shortestSubarray", "[2,-1,2]", "3");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            long [] sums = new long[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    sums[i] = nums[i];
                } else {
                    sums[i] = sums[i - 1] + nums[i];
                }
            }
            int minLen = nums.length + 1;
            Deque<AbstractMap.SimpleEntry<Integer, Long>> deque = new ArrayDeque<>();
            deque.add(new AbstractMap.SimpleEntry<>(-1, 0L));
            for (int i = 0; i < sums.length; i++) {

                while (!deque.isEmpty() && sums[i] - deque.peekFirst().getValue() >= k) {
                    minLen = Math.min(i - deque.pollFirst().getKey(), minLen);
                }

                while (!deque.isEmpty() && deque.peekLast().getValue() >= sums[i]) {
                    deque.pollLast();
                }

                deque.addLast(new AbstractMap.SimpleEntry<>(i, sums[i]));
            }
            return minLen > nums.length ? -1 : minLen;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}