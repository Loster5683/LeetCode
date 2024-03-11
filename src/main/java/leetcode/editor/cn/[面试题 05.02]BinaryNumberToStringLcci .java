package leetcode.editor.cn;
class BinaryNumberToStringLcci {
    public static void main(String[] args) {
        Solution solution = new BinaryNumberToStringLcci().new Solution();
        BaseTest.baseTest(solution, "printBin", "0.1");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String printBin(double num) {
            double i = 1;
            StringBuilder sb = new StringBuilder("0.");
            while (num > (Double.MIN_NORMAL)) {
                i = i / 2;
                if (num >= i) {
                    sb.append(1);
                    num -= i;
                } else {
                    sb.append(0);
                }
                if (sb.length() > 32) {
                    return "ERROR";
                }
            }
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}