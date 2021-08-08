public class q63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = obstacleGrid[0][i] == 1 ? 0 : dp[i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = obstacleGrid[i][0] == 1 ? 0 : dp[0];
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else dp[j] += obstacleGrid[i][j - 1] == 1 ? 0 : dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
