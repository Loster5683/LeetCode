package leetcode.editor.cn;

import java.text.Format;

class ApplyDiscountToPrices{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "discountPrices", "$7383692 5q $5870426", "64");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] strs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(modify(strs[i], discount));
            if (i != strs.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    private String modify(String str, int dis) {
        if (!str.startsWith("$")) {
            return str;
        }
        if (str.length() <2 || str.length() > 11) {
            return str;
        }
        double x = 0.0000f;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return str;
            }
            x = x * 10 + str.charAt(i) - '0';
        }
        double a = x  * (100.0f - dis) / 100.0f;
        return "$" + String.format("%.2f", a);
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}