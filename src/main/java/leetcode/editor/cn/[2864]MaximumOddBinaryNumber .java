package leetcode.editor.cn;

class MaximumOddBinaryNumber{
    public static void main(String[] args) {
       Solution solution = new MaximumOddBinaryNumber.Solution();
       BaseTest.baseTest(solution, "maximumOddBinaryNumber", "0101");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] charArray = s.toCharArray();
        int st = 0;
        int end = charArray.length - 1;
        while (charArray[charArray.length - 1] != '1') {
            if (charArray[end] == '1') {
                charArray[charArray.length - 1] = '1';
                charArray[end] = '0';
                break;
            }
            end--;
        }
        end--;
        while (st < end) {
            if (charArray[end] == '0') {
                end--;
            } else if (charArray[st] == '1') {
                st++;
            } else {
                charArray[st] = '1';
                charArray[end] = '0';
            }
        }
        return new String(charArray);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}