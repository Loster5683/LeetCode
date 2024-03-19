package leetcode.editor.cn;

import java.util.ArrayDeque;

class LargestRectangleInHistogram{
    public static void main(String[] args) {
       Solution solution = new LargestRectangleInHistogram().new Solution();
       BaseTest.baseTest(solution, "largestRectangleArea", "[2,1,5,6,2,3]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxScore = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            left[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(i);
        }
        deque.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && heights[deque.peek()] >= heights[i]) {
                deque.pop();
            }
            right[i] = deque.isEmpty() ? n : deque.peek();
            deque.push(i);
        }
        for (int i = 0; i < n; i++) {
            int leftIndex = left[i];
            int rightIndex = right[i];
            maxScore = Math.max(maxScore, (rightIndex - leftIndex - 1) * heights[i]);
        }
        return maxScore;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}