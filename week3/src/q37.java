import java.util.ArrayList;
import java.util.List;

public class q37 {
    int[] rows = new int[9];
    int[] cols = new int[9];
    int[][] blocks = new int[3][3];
    List<int[]> pos = new ArrayList<>();
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') pos.add(new int[]{i, j});
                else {
                    int value = board[i][j] - '0' - 1;
                    flip(i, j, value);
                }
            }
        }
        dfs(board, 0);
    }

    public void dfs(char[][] board, int idx) {
        if (idx == this.pos.size()) {
            valid = true;
            return;
        }
        int[] p = this.pos.get(idx);
        int i = p[0], j = p[1];
        int mask = ~(rows[i] | cols[j] | blocks[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, idx + 1);
            flip(i, j, digit);
        }
    }

    public void flip(int i, int j, int value) {
        rows[i] ^= (1 << value);
        cols[j] ^= (1 << value);
        blocks[i / 3][j / 3] ^= (1 << value);
    }
}
