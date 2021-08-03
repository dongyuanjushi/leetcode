import java.util.Arrays;

public class q45 {
    public int jump(int[] nums) {
        int n = nums.length;
        int step = 0;
        int end = 0;
        int maxPos = 0;
        for (int i = 0; i < n - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        q45 q = new q45();
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(q.jump(nums));
    }
}
