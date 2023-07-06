package leetcode.editor.cn;
class CountOfRangeSum{
    public static void main(String[] args) {
       Solution solution = new CountOfRangeSum().new Solution();
       BaseTest.baseTest(solution, "countRangeSum", "[-2,5,-1]", "-2", "2");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        return countRangeSum1(preSum, lower, upper, 0, preSum.length - 1);
    }

    //归并排序
    public int countRangeSum1(long[] nums, int lower, int upper, int left, int right) {
        int sum = 0;
        if (left == right) {
            return sum;
        }
        int mid = left + (right - left) / 2;
        int lc = countRangeSum1(nums, lower, upper, left, mid);
        int rc = countRangeSum1(nums, lower, upper, mid + 1, right);
        sum += lc;
        sum += rc;
        int start = mid + 1;
        int end = mid + 1;
        for (int z = left; z <= mid; z++) {
            while (start <= right && nums[start] - nums[z] < lower) {
                start++;
            }
            while (end <= right && nums[end] - nums[z] <= upper) {
                end++;
            }
            sum += (end - start);
        }
        // 数组双指针技巧，合并两个有序数组
        long [] temp = new long[right - left + 1];

        int i = left, j = mid + 1;
        int p = 0;
        while (i <= mid || j <= right) {
            if (i == mid + 1) {
                temp[p++] = nums[j++];
            } else if (j == right + 1) {
                temp[p++] = nums[i++];
            } else if (nums[i] > nums[j]) {
                temp[p++] = nums[j++];
            } else {
                temp[p++] = nums[i++];
            }
        }

        System.arraycopy(temp, 0, nums, left, temp.length);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}