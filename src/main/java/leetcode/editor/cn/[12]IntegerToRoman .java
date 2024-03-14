package leetcode.editor.cn;

class IntegerToRoman{
    public static void main(String[] args) {
       Solution solution = new IntegerToRoman().new Solution();
       BaseTest.baseTest(solution, "intToRoman", "1994");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    char[] chars = new char[]{'M','D', 'C', 'L','X','V','I'};
    int[] value = new int[]{1000, 500, 100, 50, 10, 5, 1};
    public String intToRoman(int num) {
        StringBuffer s = new StringBuffer();
        while (num > 0) {
            for (int i = 0; i < value.length;) {
                if (num >= value[i]) {
                    num -= value[i];
                    s.append(chars[i]);
                } else {
                    int next = i % 2 == 0 ? i + 2 : i + 1;
                    if (next < chars.length && num + value[next] >= value[i]) {
                        num -= value[i] - value[next];
                        s.append(chars[next]).append(chars[i]);
                    }
                    i++;
                }
            }
        }
        return s.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}