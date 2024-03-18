package leetcode.editor.cn;

import base.DataStructBuilder;

class RangeSumQueryImmutable{
    public static void main(String[] args) {
        NumArray solution = new RangeSumQueryImmutable().new NumArray(DataStructBuilder.initIntArray("[-2, 0, 3, -5, 2, -1]"));
        System.out.println(solution.sumRange(0,2));
        System.out.println(solution.sumRange(2,5));
        System.out.println(solution.sumRange(0,5));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

    int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}