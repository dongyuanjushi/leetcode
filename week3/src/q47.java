import java.util.*;

public class q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.fill(used, 0);
        dfs(res, new ArrayDeque<Integer>(), nums.length, nums, used);
        return res;
    }

    public void dfs(List<List<Integer>> res, ArrayDeque<Integer> cur, int k, int[] nums, int[] used) {
        if (cur.size() == k) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < k; i++) {
            if (used[i] == 1) continue;
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) continue;
            used[i] = 1;
            cur.add(nums[i]);
            dfs(res, cur, k, nums, used);
            used[i] = 0;
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        int [] nums={1,1,2};
        q47 q = new q47();
        q.permuteUnique(nums);
    }
}
