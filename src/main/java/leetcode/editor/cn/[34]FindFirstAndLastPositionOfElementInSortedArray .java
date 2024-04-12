package leetcode.editor.cn;

class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
       Solution solution = new Solution();
//       BaseTest.baseTest(solution, "searchRange", "[5,5,5,5,5,5]", "5");
       BaseTest.baseTest(solution, "searchRange", "[5,7,7,8,8,10]", "8");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = leftBound(nums, target);
        if (left == -1) {
            return new int[]{-1,-1};
        }
        int right = rightBound(nums, target);
        return new int[]{left, right};
    }

    private int leftBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < nums.length && nums[left] == target ? left: -1;
    }

    private int rightBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}