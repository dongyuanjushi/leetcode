public class q03 {
    public int findRepeatNumber(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        q03 q = new q03();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(q.findRepeatNumber(nums));
    }
}
