/**
 * 执行用时: 1 ms 100%
 * 内存消耗: 38 MB 69%
 */
public class q990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String e : equations) {
            char a = e.charAt(0);
            char b = e.charAt(3);
            char sig = e.charAt(1);
            if (sig == '=') unionFind.union(a - 'a', b - 'a');
        }
        for (String e : equations) {
            char a = e.charAt(0);
            char b = e.charAt(3);
            char sig = e.charAt(1);
            if (sig == '!') {
                int root_a = unionFind.find(a - 'a');
                int root_b = unionFind.find(b - 'a');
                if (root_a == root_b) return false;
            }
        }
        return true;
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
                if (ranks[root_x] == ranks[root_y]) ranks[root_x]++;
            }
        }
    }
}
