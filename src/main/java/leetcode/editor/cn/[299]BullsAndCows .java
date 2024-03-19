package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

class BullsAndCows{
    public static void main(String[] args) {
       Solution solution = new BullsAndCows().new Solution();
       BaseTest.baseTest(solution, "getHint", "1123", "0111");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String getHint(String secret, String guess) {
        int s = secret.length();
        int[] countA = new int[10];
        int[] countB = new int[10];

        int a = 0;
        for (int i = 0; i < s; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                countA[secret.charAt(i) - '0']++;
                countB[guess.charAt(i) - '0']++;
            }
        }
        int b = 0;
        for (int i = 0; i < 10; i++) {
            b += Math.min(countA[i], countB[i]);
        }
        String res = a + "A" + b + "B";
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}