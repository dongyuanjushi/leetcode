public class C250 {

    /**
     * Easy: pass
     */
    private class sol1 {
        public int canBeTypedWords(String text, String brokenLetters) {
            String[] words = text.split(" ");
            int count = 0;
            for (String w : words) {
                if (!isBroken(w, brokenLetters)) count++;
            }
            return count;
        }

        public boolean isBroken(String text, String brokenLetters) {
            char[] letters = brokenLetters.toCharArray();
            for (char c : letters) {
                for (char t : text.toCharArray()) {
                    if (c == t) return true;
                }
            }
            return false;
        }
    }

    /**
     * Medium: Pass
     */
    private class sol2 {
        public int addRungs(int[] rungs, int dist) {
            int d = rungs[0];
            int count = (d - 1) / dist;
            for (int i = 1; i < rungs.length; i++) {
                count += (rungs[i] - rungs[i - 1] - 1) / dist;
            }
            return count;
        }
    }

    /**
     * Medium: TLE? 155/157
     */
    private class sol3 {
        public long maxPoints(int[][] points) {
            int m = points.length;
            int n = points[0].length;
            int[][] dp = new int[2][n];
            for (int i = 0; i < n; i++) {
                dp[0][i] = points[0][i];
            }
            for (int i = 1; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        dp[1][j] = Math.max(dp[1][j], dp[0][k] + points[i][j] - Math.abs(k - j));
                    }
                    dp[0][j] = dp[1][j];
                }
            }
            int idx = m > 1 ? 1 : 0;
            int res = dp[idx][0];
            for (int i = 1; i < n; i++) {
                res = Math.max(res, dp[idx][i]);
            }
            System.out.println(res);
            return res;
        }
    }

    /**
     * Hard: TLE, 56/58
     */
    private class sol4 {
        public int[] maxGeneticDifference(int[] parents, int[][] queries) {
            int n = queries.length;
            int[] res = new int[n];
            for (int i = 0; i < queries.length; i++) {
                int current = queries[i][0];
                int x = queries[i][1];
                int tmp = 0;
                while (current != -1) {
                    tmp = Math.max(tmp, current ^ x);
                    current = parents[current];
                }
                res[i] = tmp;
            }
            return res;
        }
    }

    public void get_sol(int[][] points) {
        sol3 s = new sol3();
        s.maxPoints(points);
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0, 0}, {0, 1}, {0, 2}};
        C250 c = new C250();
        c.get_sol(points);
    }
}
