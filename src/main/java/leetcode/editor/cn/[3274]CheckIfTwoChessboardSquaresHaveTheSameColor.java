package leetcode.editor.cn;

class CheckIfTwoChessboardSquaresHaveTheSameColor{
    public static void main(String[] args) {
       Solution solution = new CheckIfTwoChessboardSquaresHaveTheSameColor.Solution();
       BaseTest.baseTest(solution, "");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a = coordinate1.charAt(0) - coordinate2.charAt(0) +
                coordinate1.charAt(1) - coordinate2.charAt(1);
        return a % 2 == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}