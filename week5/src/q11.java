public class q11 {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] <= height[right]) left++;
            else right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        q11 q = new q11();
        System.out.println(q.maxArea(height));
    }
}
