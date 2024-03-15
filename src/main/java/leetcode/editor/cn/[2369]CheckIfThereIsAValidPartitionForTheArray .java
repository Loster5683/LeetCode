package leetcode.editor.cn;

class CheckIfThereIsAValidPartitionForTheArray{
    public static void main(String[] args) {
       Solution solution = new CheckIfThereIsAValidPartitionForTheArray().new Solution();
       BaseTest.baseTest(solution, "validPartition", "[4,4,4,5,6]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] validate = new boolean[nums.length + 1];
        validate[0] = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                validate[i + 1] |= validate[i - 1];
                if (i >= 2 && nums[i] == nums[i - 2]) {
                    validate[i + 1] |= validate[i - 2];
                }
            } else if (i >= 2 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
                    validate[i + 1] |= validate[i - 2];
            }
        }
        return validate[nums.length];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}