package leetcode.editor.cn;

import java.util.*;

class ArithmeticSubarrays{
    public static void main(String[] args) {
       Solution solution = new ArithmeticSubarrays().new Solution();
       BaseTest.baseTest(solution, "checkArithmeticSubarrays", "[4,6,5,9,3,7]", "[0,0,2]", "[2,3,5]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> res = new ArrayList<>();
        List<Integer> ttt = new ArrayList<>();
        for (int num : nums) {
            ttt.add(num);
        }
        for (int i = 0; i < n; i++) {
            res.add(checkArithmeticSubarrays(new ArrayList<>(ttt.subList(l[i], r[i] + 1))));
        }
        return res;
    }

    private Boolean checkArithmeticSubarrays(List<Integer> nums) {
        Collections.sort(nums);
        if (nums.size() == 1 || nums.size() == 2) {
            return true;
        }
        int gap = nums.get(1) - nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) - nums.get(i - 1) != gap) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}