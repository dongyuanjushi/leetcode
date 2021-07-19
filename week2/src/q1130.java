import java.util.Stack;

public class q1130 {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= stack.peek()) {
                res += stack.pop() * Math.min(stack.peek(), arr[i]);
            }
            stack.push(arr[i]);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
