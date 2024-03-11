package leetcode.editor.cn;

import java.util.Arrays;

class CapitalizeTheTitle {
    public static void main(String[] args) {
        Solution solution = new CapitalizeTheTitle().new Solution();
        BaseTest.baseTest(solution, "capitalizeTitle", "capiTalIze tHe titLe");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String capitalizeTitle(String title) {
            int s = 0;
            int len = title.length();
            char[] titles = title.toLowerCase().toCharArray();
            while (s < len) {
                if (title.charAt(s) != ' ') {
                    int t = s;
                    while (t < len && title.charAt(t) != ' ') {
                        t++;
                    }
                    int subLen = t - s;
                    if (subLen > 2) {
                        titles[s] = (char) ('A' - 'a' + titles[s]);
                    }
                    s = t;
                }
                s++;
            }
            return new String(titles);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
