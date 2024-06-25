package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class MaximumStrictlyIncreasingCellsInAMatrix{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "maxIncreasingCells", "[[0,-1],[-6,-6],[-1,8]]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max = 0;
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(mat[i][j], new ArrayList<>());
                map.get(mat[i][j]).add(new int[]{i, j});
            }
        }

        int res = 0;
        int[] rolMax = new int[m];
        int[] colMax = new int[n];
        for (Map.Entry<Integer, List<int[]>> entryList : map.entrySet()) {
            int[] f = new int[entryList.getValue().size()];
            for (int pos = 0; pos < entryList.getValue().size(); pos++) {
                int[] entry = entryList.getValue().get(pos);
                int i = entry[0];
                int j = entry[1];
                f[pos] = Math.max(rolMax[i], colMax[j]) + 1;
                res = Math.max(f[pos], res);
            }

            for (int pos = 0; pos < entryList.getValue().size(); pos++) {
                int[] entry = entryList.getValue().get(pos);
                int i = entry[0];
                int j = entry[1];
                rolMax[i] = Math.max(rolMax[i], f[pos]);
                colMax[j] = Math.max(colMax[j], f[pos]);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}