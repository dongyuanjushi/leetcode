public class q952 {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        UnionFind unionFind = new UnionFind(max + 1);
        for (int num : nums) {
            double up_bound = Math.sqrt(num);
            for (int i = 2; i <= up_bound; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }
        int res = 1;
        int [] count = new int[max+1];
        for(int num:nums){
            int root = unionFind.find(num);
            count[root]++;
            res = Math.max(res,count[root]);
        }
        return res;
    }

    private class UnionFind {
        private int[] parents;
        private int[] ranks;

        public void init() {
            int n = parents.length;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 0;
            }
        }

        public UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            init();
        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x != root_y) {
                if (ranks[root_x] < ranks[root_y]) {
                    root_x = root_x ^ root_y;
                    root_y = root_x ^ root_y;
                    root_x = root_x ^ root_y;
                }
                parents[root_y] = root_x;
                if (ranks[root_x] == ranks[root_y]) ranks[root_x] += 1;
            }
        }
    }
}
