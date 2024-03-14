package leetcode.editor.cn;

class RegularExpressionMatching{
    public static void main(String[] args) {
       Solution solution = new RegularExpressionMatching().new Solution();
       BaseTest.baseTest(solution, "isMatch", "abcdede", "ab.*de");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                match[0][i + 1] = match[0][i - 1];
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '*') {
                    char lastC = p.charAt(j - 1);
                    if (lastC == '.' || s.charAt(i) == lastC) {
                        int t = i;
                        while (t >= 0 && (lastC == '.' || s.charAt(t) == lastC)) {
                            if (match[t][j + 1]) {
                                match[i + 1][j + 1] = true;
                                break;
                            }
                            t--;
                        }
                    } else {
                        match[i + 1][j + 1] = match[i + 1][j - 1];
                    }
                    match[i + 1][j + 1] = match[i + 1][j + 1] | match[i + 1][j - 1];
                } else if (p.charAt(j) == '.') {
                    match[i + 1][j + 1] = match[i][j];
                } else {
                    if (s.charAt(i) != p.charAt(j)) {
                        match[i + 1][j + 1] = false;
                    } else {
                        match[i + 1][j + 1] = match[i][j];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}