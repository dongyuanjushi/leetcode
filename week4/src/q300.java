import java.util.Arrays;

public class q300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        tails[0] = nums[0];
        int end = 0;
        for (int num : nums) {
            if (num > tails[end]) tails[++end] = num;
            else {
                int i = 0, j = end;
                while (i < j) {
                    int m = i + (j - i) / 2;
                    if (tails[m] < num) i = m + 1;
                    else j = m;
                }
                tails[i] = num;
            }
        }
        return end + 1;
    }

    public static void main(String[] args) {
        q300 q = new q300();
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(q.lengthOfLIS(nums));
    }
}
