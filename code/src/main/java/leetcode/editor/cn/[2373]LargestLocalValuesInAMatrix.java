package leetcode.editor.cn;

import java.util.*;

class LargestLocalValuesInAMatrix{
    public static void main(String[] args) {
       Solution solution = new LargestLocalValuesInAMatrix().new Solution();
       BaseTest.baseTest(solution, "largestLocal", "[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //暴力枚举
    public int[][] largestLocal1(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        for (int i = 0; i < n-2; i++){
            for (int t = 0; t < n-2; t++) {
                int tmp = 0;
                for (int j = i; j < i + 3; j++) {
                    for (int k = t; k < t + 3; k++) {
                        tmp = Math.max(tmp, grid[j][k]);
                    }
                }
                res[i][t] = tmp;
            }
        }
        return res;
    }

    //单调队列
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n-2][n-2];
        int[][] resTmp = new int[n][n-2];
        for (int i = 0; i < n; i++) {
            resTmp[i] = maxSlidingWindow(grid[i], 3);
        }

        for (int i = 0; i < n - 2; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            int [] max = new int[n];
            for (int j = 0; j < n; j++) {
                while (!deque.isEmpty() && deque.peekFirst() <= j - 3 ) {
                    deque.pollFirst();
                }
                while (!deque.isEmpty() && resTmp[deque.peekLast()][i] <= resTmp[j][i]) {
                    deque.pollLast();
                }
                deque.addLast(j);
                max[j] = resTmp[deque.peekFirst()][i];
            }
            for (int i1 = 2; i1 < max.length; i1++) {
                res[i1 - 2][i] = max[i1];
            }
        }
        return res;
    }

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