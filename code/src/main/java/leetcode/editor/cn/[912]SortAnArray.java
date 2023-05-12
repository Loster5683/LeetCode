package leetcode.editor.cn;

import java.util.Arrays;

class SortAnArray{
    public static void main(String[] args) {
       Solution solution = new SortAnArray().new Solution();
       BaseTest.baseTest(solution, "sortArray", "[5,2,3,1]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] temp;
    public int[] sortArray(int[] nums) {
        temp = new int[nums.length];
        sortArrayA(nums, 0, nums.length - 1);
        return nums;
    }

    private int[] sortArrayA(int[] nums, int s, int t) {
        if (t == s) {
            return nums;
        }
        int mid = s + (t - s) / 2;
        sortArrayA(nums, s, mid);
        sortArrayA(nums, mid + 1, t);
        mergeArray(nums, s, mid, t);
        return nums;
    }

    private void mergeArray(int[] nums, int s, int mid, int t) {
        int index = s;
        for (int i = s, j = mid + 1; s <= mid && j <= t;) {
            if (nums[i] >= nums[j]) {
                temp[index++] = nums[j++];
            } else {
                temp[index++] = nums[i++];
            }
            if (i == mid + 1) {
                while (j <= t) {
                    temp[index++] = nums[j++];
                }
            }

            if (j == t + 1) {
                while (i <= mid) {
                    temp[index++] = nums[i++];
                }
            }

        }
        for (int i = s; i <= t; i++) {
            nums[i] = temp[i];
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}