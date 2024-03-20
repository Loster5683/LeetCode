package leetcode.editor.cn;

class FindTheKOrOfAnArray{
    public static void main(String[] args) {
       Solution solution = new FindTheKOrOfAnArray().new Solution();
       BaseTest.baseTest(solution, "findKOr", "[10,8,5,9,11,6,8]", "1");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKOr(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            int c = 0;
            for (int j = 0; j < nums.length; j++) {
                c += nums[j] >> i & 1;
            }
            if (c >= k) {
                res += (1 << i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}