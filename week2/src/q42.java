public class q42 {
    /**
     * 动态规划: 三次遍历
     * 时间开销: O(n) 27%, 空间开销: O(n) 19%
     */
    public int trap1(int [] height){
        int n = height.length;
        if (n == 0) return 0;
        int[][] dp = new int[2][n];
        dp[0][0] = height[0];
        for (int i = 1; i < n; i++) dp[0][i] = Math.max(dp[0][i - 1], height[i]);
        dp[1][n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) dp[1][i] = Math.max(dp[1][i + 1], height[i]);
        int res = 0;
        for (int i = 0; i < n; i++) {
            int bound = Math.min(dp[0][i], dp[1][i]);
            res += (bound > height[i] ? bound - height[i] : 0);
        }
        return res;
    }

    /**
     * 双指针 一次遍历
     * 时间开销: O(n) 97%, 空间开销: O(1) 83%
     */
    public int trap2(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += rightMax - height[right];
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        q42 q = new q42();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        q.trap2(height);
    }
}
