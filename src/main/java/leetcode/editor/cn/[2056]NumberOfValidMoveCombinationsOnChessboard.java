package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class NumberOfValidMoveCombinationsOnChessboard{
    public static void main(String[] args) {
        Solution solution = new NumberOfValidMoveCombinationsOnChessboard
            .Solution();


        System.out.println(BaseTest.baseTest(solution, "countCombinations", "[\"bishop\",\"rook\"]", "[[8,5],[7,7]]"));
    }
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    record Move(int x0, int y0, int dx , int dy, int step) {
    }

    public int countCombinations(String[] pieces, int[][] positions) {
        int n = pieces.length;
        Move [][] records = new Move[n][];
        for (int i = 0; i < n; i++) {
            records[i] = generateMoves(positions[i][0], positions[i][1], getDir(pieces[i]));
        }
        Move[] path = new Move[8];
        return dfs(0, n, records, path);
    }

    private int dfs(int i, int n, Move[][] allMoves, Move[] path) {
        if (i == n) {
            return 1;
        }
        int res = 0;
        outer:
        // ö�ٵ�ǰ���ӵ����кϷ��ƶ�
        for (Move move1 : allMoves[i]) {
            // �жϺϷ��ƶ� move1 �Ƿ���Ч
            for (int j = 0; j < i; j++) {
                if (!isValid(move1, path[j])) {
                    continue outer; // ��Ч��ö����һ�� move1
                }
            }
            path[i] = move1; // ֱ�Ӹ��ǣ�����ָ��ֳ�
            res += dfs(i + 1, n, allMoves, path); // ö�ٺ������ӵ����кϷ��ƶ����
        }
        return res;
    }


    public boolean isValid(Move m1, Move m2) {
        int x1 = m1.x0;
        int x2 = m2.x0;
        int y1 = m1.y0;
        int y2 = m2.y0;
        for (int i = 0; i < Math.max(m1.step, m2.step); i++) {
            if (i < m1.step) {
                x1 += m1.dx;
                y1 += m1.dy;
            }
            if (i < m2.step) {
                x2 += m2.dx;
                y2 += m2.dy;
            }
            if (x1 == x2 && y1 == y2) {
                return false;
            }
        }
        return true;
    }

    private Move[] generateMoves(int x0, int y0, int[][] dirs) {
        final int SIZE = 8;
        List<Move> moves = new ArrayList<>();
        moves.add(new Move(x0, y0, 0, 0, 0)); // ԭ�ز���
        for (int[] d : dirs) {
            // �� d ������ 1,2,3,... ��
            int x = x0 + d[0], y = y0 + d[1];
            for (int step = 1; 0 < x && x <= SIZE && 0 < y && y <= SIZE; step++) {
                moves.add(new Move(x0, y0, d[0], d[1], step));
                x += d[0];
                y += d[1];
            }
        }
        return moves.toArray(Move[]::new);
    }

    public int[][] getDir(String type) {
        if (type.equals("rook")) {
            return new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        } else if (type.equals("bishop")) {
            return new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        } else if (type.equals("queen")) {
            return new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}