package leetcode.editor.cn;

import java.util.*;

class CountDistinctNumbersOnBoard{
    public static void main(String[] args) {
       Solution solution = new CountDistinctNumbersOnBoard().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distinctIntegers(int n) {
        return Math.max(n - 1, 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}