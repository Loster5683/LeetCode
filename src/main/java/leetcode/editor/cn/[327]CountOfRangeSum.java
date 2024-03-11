package leetcode.editor.cn;

class CountOfRangeSum{
    public static void main(String[] args) {
       Solution solution = new CountOfRangeSum().new Solution();
       BaseTest.baseTest(solution, "countRangeSum", "[0,0]", "0", "0");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] preSum = new long[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            preSum[i] = sum;
        }
        int res = countRangeSum1(preSum, 0, preSum.length - 1, lower, upper);
        return res;
    }

    private int countRangeSum1(long[] preSum, int start, int end, int lower, int upper) {
        int mid = start + (end - start) / 2;
        if (start == end) {
            return 0 >= lower && 0 <= upper ? 1 : 0;
        }

        int left = countRangeSum1(preSum, start, mid, lower, upper);
        int hight = countRangeSum1(preSum, mid + 1, end, lower, upper);
        int i = start;
        int j = mid + 1;
        int count = left + hight;
        while (i <= mid && j <= end) {
            if (preSum[j] - preSum[i] < lower) {
                j++;
            } else if (preSum[j] - preSum[i] > upper) {
                i++;
            } else {
                count++;
                j++;
            }
        }
        long []tmp = new long[end - start + 1];
        i = start;
        j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (preSum[j] <= preSum[i]) {
                tmp[t++] = preSum[j++];
            } else {
                tmp[t++] = preSum[i++];
            }
        }
        while (i <= mid) {
            tmp[t++] = preSum[i++];
        }
        while (j <= end) {
            tmp[t++] = preSum[j++];
        }
        System.arraycopy(tmp, 0, preSum, start, end - start + 1);
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}