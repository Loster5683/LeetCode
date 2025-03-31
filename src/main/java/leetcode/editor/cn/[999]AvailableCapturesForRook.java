package leetcode.editor.cn;

class AvailableCapturesForRook{
    public static void main(String[] args) {
        Solution solution = new AvailableCapturesForRook
            .Solution();
        BaseTest.baseTest(solution, "numRookCaptures", "[[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\"p\",\"p\",\".\",\"R\",\".\",\"p\",\"B\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"B\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\"p\",\".\",\".\",\".\",\".\"],[\".\",\".\",\".\",\".\",\".\",\".\",\".\",\".\"]]");
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRookCaptures(char[][] board) {

        int res = 0;
        int x = 0, y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    x = i;
                    y = j;
                }
            }
        }
        for (int x0 = x - 1; x0 >= 0; x0--) {
            if (board[x0][y] == 'p') {
                res++;
                break;
            }
            if (board[x0][y] == 'B') {
                break;
            }
        }
        for (int x0 = x + 1; x0 < board.length; x0++) {
            if (board[x0][y] == 'p') {
                res++;
                break;
            }
            if (board[x0][y] == 'B') {
                break;
            }
        }
        for (int y0 = y - 1; y0 >= 0; y0--) {
            if (board[x][y0] == 'p') {
                res++;
                break;
            }
            if (board[x][y0] == 'B') {
                break;
            }
        }
        for (int y0 = y + 1; y0 < board[0].length; y0++) {
            if (board[x][y0] == 'p') {
                res++;
                break;
            }
            if (board[x][y0] == 'B') {
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}