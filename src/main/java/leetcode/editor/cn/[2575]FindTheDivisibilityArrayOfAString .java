package leetcode.editor.cn;

class FindTheDivisibilityArrayOfAString{
    public static void main(String[] args) {
       Solution solution = new FindTheDivisibilityArrayOfAString().new Solution();
       BaseTest.baseTest(solution, "");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] res = new int[word.length()];
        long value = 0;
        for (int i = 0; i < word.length(); i++) {
            value = word.charAt(i) - '0' + value * 10;
            value = value % m;
            if (value == 0) {
                res[i] = 1;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}