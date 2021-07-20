import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 单调栈：用于寻找局部最值
 * 执行用时：3 ms 97.79%
 * 内存消耗：38.6 MB 59.43%
 */
public class q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len2 = nums2.length;
        for (int i = 0; i < len2; i++) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int len1 = nums1.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
