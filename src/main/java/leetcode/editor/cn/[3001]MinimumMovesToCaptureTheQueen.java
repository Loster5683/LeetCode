package leetcode.editor.cn;

class MinimumMovesToCaptureTheQueen{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToCaptureTheQueen
            .Solution();
        BaseTest.baseTest(solution, "minMovesToCaptureTheQueen", "4", "6", "1", "1", "5", "5" );
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (a == e && (c != e ||  !(d > b && d < f || d < b && d > f))) {
            return 1;
        }
        if (b == f && (d != f || !(c > a && c < e || c < a && e < c))) {
            return 1;
        }

        int dx = e - c;
        int dy = f - d;
        if (Math.abs(dx) == Math.abs(dy)) {
            if (!((a > e && a < c || a < e && a > c) && (b > f && b < d || b < f && b > d) && Math.abs(a - e) == Math.abs(b - f))) {
                return 1;
            }
        }
        return 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}