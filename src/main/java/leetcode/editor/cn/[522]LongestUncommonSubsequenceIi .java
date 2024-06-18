package leetcode.editor.cn;

class LongestUncommonSubsequenceIi{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "findLUSlength", "[\"aabbcc\",\"aabbcc\",\"c\"]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            boolean hasSubSeq = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (isSubSequence(strs[i], strs[j])) {
                    hasSubSeq = true;
                    break;
                }
            }
            if (!hasSubSeq) {
                maxLen = Math.max(maxLen, strs[i].length());
            }

        }
        return maxLen;
    }

    public boolean isSubSequence(String str1, String str2) {
        int j = 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(j)) {
                j++;
            }
            if (j == str1.length()) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}