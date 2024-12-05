package leetcode.editor.cn;

import java.util.AbstractMap;

import java.util.*;

class CountWaysToGroupOverlappingRanges{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<AbstractMap.SimpleEntry<Integer, Integer>> sub = new ArrayList<>();
    public int countWays(int[][] ranges) {

        //Ì°ÐÄ
        Arrays.sort(ranges, Comparator.comparing(o -> o[0]));
        int max = -1;
        int res = 1;
        for (int[] range : ranges) {
            if (range[0] > max) {
                res = res * 2 % (1_000_000_000 + 7);
            }
            max = Math.max(max, range[1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}