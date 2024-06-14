package leetcode.editor.cn;


import java.util.*;

class MaximumEleganceOfAKLengthSubsequence{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "findMaximumElegance", "[[[5,4],[6,6],[8,4],[6,6],[7,6],[1,6],[4,2]]", "5");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findMaximumElegance(int[][] items, int k) {
        Arrays.sort(items, (a, b) -> b[0] - a[0]);
        Set<Integer> types = new HashSet<>();
        long ans = 0;
        long tmp = 0;
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            types.add(items[i][1]);
            tmp += items[i][0];
            index.add(i);
        }
        ans = tmp + (long) types.size() * types.size();

        for (int i = k; i < items.length; i++) {
            if (types.contains(items[i][1])) {
                continue;
            }
            if (types.size() == k) {
                continue;
            }
            Set<Integer> ttt = new HashSet<>();
            int remove = 0;
            for (int i1 = 0; i1 <= index.size() - 1; i1++) {
                if (ttt.contains(items[index.get(i1)][1])) {
                    remove = i1;
                }
                ttt.add(items[index.get(i1)][1]);
            }
            int removeIndex = index.remove(remove);
            index.add(i);
            tmp += items[i][0] - items[removeIndex][0];
            types.add(items[i][1]);
            ans = Math.max(ans, tmp + (long) types.size() * types.size());
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}