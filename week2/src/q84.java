import java.util.Stack;

/**
 * 单调栈
 * AC 单调栈(Hard) without seeing solutions at first time o(*￣▽￣*)ブ
 */
public class q84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (!stack.empty() && heights[stack.peek()] > heights[i]) {
                int right_bound = stack.peek();
                while (!stack.empty() && heights[stack.peek()] > heights[i]) {
                    int left_bound = stack.pop();
                    if (!stack.empty()) {
                        res = Math.max(res, heights[left_bound] * (right_bound - stack.peek()));
                    } else res = Math.max(res, heights[left_bound] * (right_bound + 1));
                }
            }
            stack.push(i);
        }
        if (!stack.empty()) {
            int right_bound = stack.peek();
            while (!stack.empty()) {
                int left_bound = stack.pop();
                if (!stack.empty()) {
                    res = Math.max(res, heights[left_bound] * (right_bound - stack.peek()));
                } else res = Math.max(res, heights[left_bound] * (right_bound + 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        q84 q = new q84();
        int[] heights = new int[]{2, 1, 2};
        q.largestRectangleArea(heights);
    }
}
