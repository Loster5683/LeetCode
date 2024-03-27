package leetcode.editor.cn;

class PrimePalindrome{
    public static void main(String[] args) {
       Solution solution = new Solution();
       BaseTest.baseTest(solution, "primePalindrome", "6");
       BaseTest.baseTest(solution, "primePalindrome", "8");
       BaseTest.baseTest(solution, "primePalindrome", "13");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int primePalindrome(int n) {
        for (int i = 1; i <= 5; i++) {
            for (int z = 1; z >= 0; z--) {
                for (int j = (int) Math.pow(10, i - 1); j < Math.pow(10, i); j++) {
                    StringBuilder sb = new StringBuilder(String.valueOf(j));
                    int l = sb.length();
                    for (int k = l - 1 - z; k >= 0; k--) {
                        sb.append(sb.charAt(k));
                    }
                    if (sb.length() <= 0) {
                        continue;
                    }
                    int s = Integer.parseInt(sb.toString());
                    if (s < n) {
                        continue;
                    }
                    if (isPrime(s)) {
                        return s;
                    }
                }
            }

        }


        return 0;
    }

    public boolean isPrime(int m) {
        if (m < 2) {
            return false;
        }
        int sq = (int) Math.sqrt(m);
        for (int i = 2; i <= sq; i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}