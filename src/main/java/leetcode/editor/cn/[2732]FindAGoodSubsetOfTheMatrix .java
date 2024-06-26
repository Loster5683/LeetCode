package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FindAGoodSubsetOfTheMatrix{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "goodSubsetofBinaryMatrix", "[[0,1,1,0],[0,0,0,1],[1,1,1,1]]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    /**
     * ж╩сп
     */
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                tmp = (tmp << 1) + grid[i][j];
            }
            if (tmp == 0) {
                return Collections.singletonList(i);
            }
            v[i] = tmp;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if ((v[i] & v[j]) == 0) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return Collections.emptyList();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}