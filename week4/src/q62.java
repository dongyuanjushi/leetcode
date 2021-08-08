public class q62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) dp[j] += dp[j - 1];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        q62 q = new q62();
        System.out.println(q.uniquePaths(3, 7));
    }
}
