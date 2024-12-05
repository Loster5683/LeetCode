package leetcode.editor.cn;

class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix
            .Solution();
        BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            if (strs[0].length() <= i) {
                return sb.toString();
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}