package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

class BestTeamWithNoConflicts{
    public static void main(String[] args) {
       Solution solution = new BestTeamWithNoConflicts().new Solution();
       BaseTest.baseTest(solution, "bestTeamScore2", "[4,5,6,5]", "[2,1,2,1]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //排序 + DP
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

    //基于值域计算（适用于值域范围较小的问题）
    public int bestTeamScore2(int[] scores, int[] ages) {
        int n = scores.length;
        int res = Integer.MIN_VALUE;
        Integer [] index = new Integer[n];
        int maxAge = 0;
        for (int i = 0; i < n; i++) {
            index[i] = i;
            maxAge = Math.max(maxAge, ages[i]);
        }
        Arrays.sort(index, (a, b) -> scores[a] == scores[b] ? ages[a] - ages[b] : scores[a] - scores[b]);
        int [] maxSum = new int[maxAge + 1];
        for (Integer id : index) {
            int age = ages[id];
            for (int j = 1; j <= age; j++) {
                maxSum[age] = Math.max(maxSum[age], maxSum[j]);
            }
            maxSum[age] += scores[id];
            res = Math.max(res, maxSum[age]);
        }
        return res;
    }

    //todo 树状数组优化
    public int bestTeamScore3(int[] scores, int[] ages) {
        int n = scores.length;
        int res = Integer.MIN_VALUE;
        Integer [] index = new Integer[n];
        int maxAge = 0;
        for (int i = 0; i < n; i++) {
            index[i] = i;
            maxAge = Math.max(maxAge, ages[i]);
        }
        Arrays.sort(index, (a, b) -> scores[a] == scores[b] ? ages[a] - ages[b] : scores[a] - scores[b]);
        int [] maxSum = new int[maxAge + 1];
        for (Integer id : index) {
            int age = ages[id];
            for (int j = 1; j <= age; j++) {
                maxSum[age] = Math.max(maxSum[age], maxSum[j]);
            }
            maxSum[age] += scores[id];
            res = Math.max(res, maxSum[age]);
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}