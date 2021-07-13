import java.util.*;

public class q1202 {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind unionSet = new UnionFind(n);
        for (List<Integer> pair : pairs) {
            unionSet.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Integer>> sets = unionSet.getUnionSets();
        char[] full_chars = new char[n];
        for (List<Integer> elements : sets.values()) {
            char[] chars = new char[elements.size()];
            for (int i = 0; i < elements.size(); i++) {
                chars[i] = s.charAt(elements.get(i));
            }
            Arrays.sort(chars);
            for (int i = 0; i < elements.size(); i++) {
                full_chars[elements.get(i)] = chars[i];
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : full_chars) {
            stringBuilder.append(c);
        }
        String res = stringBuilder.toString();
        System.out.println(res);
        return res;
    }

    private class UnionFind {
        private int[] parents;
        private int[] ranks;

        public void init() {
            for (int i = 0; i < parents.length; i++) parents[i] = i;
            for (int i = 0; i < parents.length; i++) ranks[i] = 0;
        }

        public UnionFind(int n) {
            parents = new int[n];
            ranks = new int[n];
            init();
        }

        /**
         * 优化搜索路径
         * @param x 子节点
         * @return  子节点所在树的根节点
         */

        public int find(int x) {
            if (x != parents[x]) parents[x] = find(parents[x]);
            return parents[x];
        }

        /**
         * 按秩合并
         * @param x
         * @param y
         */

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

        public Map<Integer, List<Integer>> getUnionSets() {
            Map<Integer, List<Integer>> sets = new HashMap<>();
            for (int i = 0; i < parents.length; i++) {
                parents[i] = find(i);
                int root = parents[i];
                if (!sets.containsKey(root)) {
                    List<Integer> elements = new ArrayList<>();
                    sets.put(root, elements);
                }
                sets.get(root).add(i);
            }
            System.out.println(sets.size());
            return sets;
        }
    }

    public static void main(String[] args) {
        q1202 q = new q1202();
        String s = "dcab";
        List<List<Integer>> pos = new ArrayList<List<Integer>>() {{
            add(new ArrayList<Integer>() {{
                add(0);
                add(3);
            }});
            add(new ArrayList<Integer>() {{
                add(1);
                add(2);
            }});
            add(new ArrayList<Integer>() {{
                add(0);
                add(2);
            }});
        }};
        q.smallestStringWithSwaps(s, pos);
    }
}
