package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

class BestTeamWithNoConflicts{
    public static void main(String[] args) {
       Solution solution = new BestTeamWithNoConflicts().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //≈≈–Ú + DP
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        int res = 0;
        Arrays.sort(index, (i, j) -> ages[i] == ages[j] ? scores[i] - scores[j] : ages[i] - ages[j]);
        int[] F = new int[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (scores[index[i]] >= scores[index[j]]) {
                    F[i] = Math.max(F[j], F[i]);
                }
            }
            F[i] += scores[index[i]];
            res = Math.max(res, F[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}