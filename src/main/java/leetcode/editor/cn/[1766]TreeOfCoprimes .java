package leetcode.editor.cn;

import java.util.*;

class TreeOfCoprimes{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "getCoprimes", "[2,3,3,2]", "[[0,1],[1,2],[1,3]]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    static int[][] gcdMemo = new int[51][51];
    static {
        for (int i = 1; i <= 50; i++) {
            int k = 0;
            for (int j = 1; j <= 50; j++) {
                if (gcd(i, j) == 1) {
                    gcdMemo[i][k++] = j;
                }
            }
        }
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        List<Integer>[] index = new ArrayList[nums.length];
        Arrays.setAll(index, i -> new ArrayList<>());
        for (int[] edge : edges) {
            index[edge[0]].add(edge[1]);
            index[edge[1]].add(edge[0]);
        }

        int[] depth = new int[51];
        int[] nodes = new int[51];
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        dfs(0, -1, 1, res, nums, index, depth, nodes);
        return res;
    }

    private void dfs(int cur, int bef, int d,  int[] res, int[] nums,List<Integer>[] index, int[] depths, int[] nodes) {
        int value = nums[cur];

        int maxD = 0;
        for (int i : gcdMemo[value]) {
            if (i == 0) {
                break;
            }
            if (depths[i] > maxD) {
                maxD = depths[i];
                res[cur] = nodes[i];
            }
        }

        int dtmp = depths[value];
        int ctmp = nodes[value];

        depths[value] = d;
        nodes[value] = cur;

        for (Integer i : index[cur]) {
            if (i != bef) {
                dfs(i, cur, d + 1, res, nums, index, depths, nodes);
            }
        }
        depths[value] = dtmp;
        nodes[value] = ctmp;

    }
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}