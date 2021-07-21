import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class q503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n * 2; i++) {
            while (!stack.empty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

    public static void main(String[] args) {
        q503 q = new q503();
        int[] nums = {100, 1, 11, 1, 120, 111, 123, 1, -1, -100};
        q.nextGreaterElements(nums);
    }
}
