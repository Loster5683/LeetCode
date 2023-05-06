package leetcode.editor.cn;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

class MinimumNumberOfFrogsCroaking{
    public static void main(String[] args) {
       Solution solution = new MinimumNumberOfFrogsCroaking().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minNumberOfFrogs(String croakOfFrogs) {
        char [] prev = new char['s'];
        String s = "croakc";
        for (int i = 1; i < s.length(); i++) {
            prev[s.charAt(i)] = s.charAt(i - 1);
        }
        int [] cnt = new int['s'];
        for (char aChar : croakOfFrogs.toCharArray()) {
            char prevc = prev[aChar];
            if (cnt[prevc] > 0) {
                cnt[prevc] --;
            } else if (aChar != 'c') {
                return -1;
            }
            cnt[aChar]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'k' && cnt[s.charAt(i)] > 0) {
                return -1;
            }
        }
        return cnt['k'];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}