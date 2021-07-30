import java.util.ArrayList;
import java.util.List;

public class q212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        int m = board.length;
        if (m == 0) return res;
        int n = board[0].length;
        for (String word : words) {
            int[][] used = new int[m][n];
            boolean find = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word.charAt(0) == board[i][j]) {
                        if (check(board, i, j, 1, word, used)) {
                            res.add(word);
                            find = true;
                            break;
                        }
                    }
                }
                if (find) break;
            }
        }
        return res;
    }

    public boolean check(char[][] board, int i, int j, int idx, String word, int[][] used) {
        if (idx == word.length()) return true;
        used[i][j] = 1;
        if (i > 0 && used[i - 1][j] == 0 && board[i - 1][j] == word.charAt(idx)) {
            if (check(board, i - 1, j, idx + 1, word, used)) return true;
        }
        if (i < board.length - 1 && used[i + 1][j] == 0 && board[i + 1][j] == word.charAt(idx)) {
            if (check(board, i + 1, j, idx + 1, word, used)) return true;
        }
        if (j > 0 && used[i][j - 1] == 0 && board[i][j - 1] == word.charAt(idx)) {
            if (check(board, i, j - 1, idx + 1, word, used)) return true;
        }
        if (j < board[0].length - 1 && used[i][j + 1] == 0 && board[i][j + 1] == word.charAt(idx)) {
            if (check(board, i, j + 1, idx + 1, word, used)) return true;
        }
        used[i][j] = 0;
        return false;
    }
}
