package leetcode.editor.cn;

import java.util.*;

class ArithmeticSubarrays{
    public static void main(String[] args) {
       Solution solution = new ArithmeticSubarrays().new Solution();
       BaseTest.baseTest(solution, "checkArithmeticSubarrays", "[10,-10,-5,12,8,-16,-4,-12,-8,12,9,-3]", "[1,7,3,2,6,5]", "[2,10,6,3,9,8]");
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
            List<Integer> subList = new ArrayList<>(ttt.subList(l[i], r[i] + 1));
            Set<Integer> tmp = new HashSet<>();
            if (subList.size() == 1 || subList.size() == 2) {
                res.add(Boolean.TRUE);
                continue;
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (Integer num : subList) {
                max = Math.max(num, max);
                min = Math.min(min, num);
                tmp.add(num);
            }
            int len = subList.size() - 1;
            if ((max - min) % len != 0) {
                res.add(Boolean.FALSE);
                continue;
            }
            int gap = (max - min) / len;

            boolean sss = true;
            for (int j = 0; j < subList.size(); j++) {
                int t = gap * j + min;
                if (!tmp.contains(t)) {
                    sss = false;
                    break;
                }
            }
            res.add(sss);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}