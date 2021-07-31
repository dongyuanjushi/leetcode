import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    mat[i][j] = -1;
                }
            }
        }
        int depth = 0;
        int[][] d = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int x = pos[0], y = pos[1];
                res[x][y] = depth;
                for (int j = 0; j < 4; j++) {
                    int newX = x + d[j][0], newY = y + d[j][1];
                    if (inArea(newX, newY, m, n) && mat[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY});
                        mat[newX][newY] = -1;
                    }
                }
            }
            depth++;
        }
        return res;
    }

    public boolean inArea(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        q542 q = new q542();
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        q.updateMatrix(mat);
    }

}
