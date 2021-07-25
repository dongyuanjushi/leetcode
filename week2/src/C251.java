import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C251 {
    private class Sol1 {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(c - 'a' + 1);
            }
            String res = sb.toString();
            for (int i = 0; i < k; i++) {
                res = sum(res);
            }
            return Integer.parseInt(res);
        }

        public String sum(String s) {
            int sum = 0;
            for (char c : s.toCharArray()) {
                sum += c - '0';
            }
            return String.valueOf(sum);
        }
    }

    private class Sol2 {
        public String maximumNumber(String num, int[] change) {
            StringBuilder sb = new StringBuilder();
            int n = num.length();
            int left = n;
            char[] nums = num.toCharArray();
            for (int i = 0; i < n; i++) {
                int cur = nums[i] - '0';
                if (change[cur] > cur) {
                    left = i;
                    break;
                }
            }
            int right = left;
            while (right < n) {
                int cur = nums[right] - '0';
                if (change[cur] < cur) break;
                right++;
            }
            for (int i = 0; i < left; i++) sb.append(nums[i] - '0');
            for (int i = left; i < right; i++) sb.append(change[nums[i] - '0']);
            for (int i = right; i < n; i++) sb.append(nums[i] - '0');
            return sb.toString();
        }
    }

    private class Sol3 {
        public int maxCompatibilitySum(int[][] students, int[][] mentors) {
            int m = students.length;
            int[][] weight = new int[m][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) weight[i][j] = getC(students[i], mentors[j]);
            }
            int[] used = new int[8];
            Arrays.fill(used, 0);
            int[] res = new int[1];
            dfs(weight, 0, used, 0, res);
            return res[0];
        }

        public void dfs(int[][] weights, int start, int[] used, int sum, int[] res) {
            if (start == weights.length) {
                res[0] = Math.max(res[0], sum);
            }
            for (int i = start; i < weights.length; i++) {
                for (int j = 0; j < weights.length; j++) {
                    if (used[j] == 0) {
                        used[j] = 1;
                        dfs(weights, i + 1, used, sum + weights[i][j], res);
                        used[j] = 0;
                    }
                }
            }
        }

        public int getC(int[] num1, int[] num2) {
            int res = 0;
            for (int i = 0; i < num1.length; i++) res += (num1[i] == num2[i] ? 1 : 0);
            return res;
        }
    }

    private class Sol4 {

    }

    public void sol() {

    }

    public static void main(String[] args) {
        C251 c = new C251();
        c.sol();
    }
}
