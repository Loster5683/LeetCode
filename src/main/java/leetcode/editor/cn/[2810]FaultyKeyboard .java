package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class FaultyKeyboard{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "finalString", "poiinter");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String finalString(String s) {
        Deque<Character> characterDeque = new ArrayDeque<>();
        boolean reverse = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'i') {
                reverse = !reverse;
            } else {
                if (reverse) {
                    characterDeque.offerFirst(s.charAt(i));
                } else {
                    characterDeque.offer(s.charAt(i));
                }
            }
        }
        StringBuilder res = new StringBuilder();
        if (reverse) {
            while (!characterDeque.isEmpty()) {
                res.append(characterDeque.pollLast());
            }
        } else {
            while (!characterDeque.isEmpty()) {
                res.append(characterDeque.pollFirst());
            }
        }
        return res.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}