package leetcode.editor.cn;

import java.util.Arrays;

class MaximumBinaryStringAfterChange{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "maximumBinaryString", "000110");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumBinaryString(String binary) {
        char[] charArray = binary.toCharArray();
        int i = binary.indexOf('0');
        if (i == -1) {
            return binary;
        }
        int cnt = 0;
        for (int j = i; j < binary.length(); j++) {
            if (charArray[j] == '1') {
                cnt++;
            }
        }
        Arrays.fill(charArray,'1');
        charArray[binary.length() - cnt - 1] = '0';
        return new String(charArray);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}