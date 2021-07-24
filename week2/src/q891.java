import java.util.Arrays;

public class q891 {
    public int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long bound = (long) 1e9 + 7;
        long[] pow = new long[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) pow[i] = (pow[i - 1] << 1) % bound;
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + (pow[i] - pow[n - i - 1]) * nums[i]) % bound;
        }
        return (int) res;
    }
}
