import java.util.*;

/**
 * 执行用时：
 * 32 ms 89.73%
 * 内存消耗：
 * 43.4 MB 55.45%
 */
public class q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<Integer>> mapIndex = new ArrayList<>();
        Map<String, Integer> emailMap = new HashMap<>();
        List<String> emails = new ArrayList<>();
        int idx = 0;
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                if (!emailMap.containsKey(a.get(i))) {
                    emailMap.put(a.get(i), idx++);
                    emails.add(a.get(i));
                }
            }
        }
        UnionFind unionFind = new UnionFind(idx);
        idx = 0;
        List<String> names = new ArrayList<>();
        for (List<String> a : accounts) {
            List<Integer> temp = new ArrayList<>(2);
            temp.add(idx++);
            temp.add(emailMap.get(a.get(1)));
            mapIndex.add(temp);
            names.add(a.get(0));
            String first = a.get(1);
            for (int i = 1; i < a.size(); i++) {
                unionFind.union(emailMap.get(first), emailMap.get(a.get(i)));
            }
        }
        Map<Integer, List<Integer>> sets = unionFind.get_sets();
        List<Integer> used = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (List<Integer> pairs : mapIndex) {
            String name = names.get(pairs.get(0));
            int root = unionFind.find(pairs.get(1));
            if (!used.contains(root)) {
                List<String> r = new ArrayList<>();
                List<String> temp = new ArrayList<>();
                r.add(name);
                for (int i : sets.get(root)) {
                    temp.add(emails.get(i));
                }
                Collections.sort(temp);
                for (String t : temp) r.add(t);
                used.add(root);
                res.add(r);
            }
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
                if (ranks[root_x] == ranks[root_y]) ranks[root_x]++;
            }
        }

        public Map<Integer, List<Integer>> get_sets() {
            Map<Integer, List<Integer>> sets = new HashMap<>();
            for (int i = 0; i < parents.length; i++) {
                int root_i = find(i);
                if (!sets.containsKey(root_i)) sets.put(root_i, new ArrayList<>());
                sets.get(root_i).add(i);
            }
            return sets;
        }
    }

    public static void main(String[] args) {
        q721 q = new q721();
        List<List<String>> accounts = new ArrayList<List<String>>() {{
            add(new ArrayList<String>() {{
                add("John");
                add("johnsmith@mail.com");
                add("john_newyork@mail.com");
            }});
            add(new ArrayList<String>() {{
                add("John");
                add("johnsmith@mail.com");
                add("john00@mail.com");
            }});
            add(new ArrayList<String>() {{
                add("Mary");
                add("mary@mail.com");
            }});
            add(new ArrayList<String>() {{
                add("John");
                add("johnnybravo@mail.com");
            }});
        }};
        q.accountsMerge(accounts);
    }
}
