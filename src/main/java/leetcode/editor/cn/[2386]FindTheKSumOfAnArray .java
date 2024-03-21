package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class FindTheKSumOfAnArray{
    public static void main(String[] args) {
        Solution solution = new FindTheKSumOfAnArray().new Solution();
        BaseTest.baseTest(solution, "kSum", "[2,4,-2]", "5");
        BaseTest.baseTest(solution, "kSum", "[1,-2,3,4,-10,12]", "16");
        BaseTest.baseTest(solution, "kSum", "[492634335,899178915,230945927]", "2");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {



    //优先队列算法 序列生成树
    public long kSum1(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
        }
        int n = nums.length;

        Arrays.sort(nums);
        PriorityQueue<Pair<Long, Integer>> queue = new PriorityQueue<>(Comparator.comparingLong(Pair::getKey));
        queue.add(new Pair<>(0L, 0));
        while (--k > 0) {
            Pair<Long, Integer> pair = queue.poll();
            long value = pair.getKey();
            int index = pair.getValue();

            if (index < n) {

                //下一个最小的序列只会是加上左子树节点或者替换为右节点
                queue.offer(new Pair<>(value + nums[index], index + 1));

                //[0,0] 初始节点没有右节点
                if (index > 0) {
                    queue.offer(new Pair<>(value + nums[index] - nums[index - 1], index + 1));
                }
            }
        }
        return sum - queue.peek().getKey();
    }


    int tot = 0;
    //二分搜索
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long right = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                sum += nums[i];
            } else {
                nums[i] = -nums[i];
            }
            right += nums[i];
        }
        Arrays.sort(nums);

        long left = -1;

        while (left + 1 < right) {
            long mid = (right + left) / 2;
            tot = k - 1;
            dfs(0, mid, nums);
            if (tot == 0) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return sum - right;
    }

    private void dfs(int start, long mid, int[] nums) {
        if (start >= nums.length || tot <= 0 || mid < nums[start]) {
            return;
        }
        tot--;
        dfs(start + 1, mid, nums);
        dfs(start + 1, mid - nums[start], nums);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}