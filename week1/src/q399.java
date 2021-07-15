import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind unionFind = new UnionFind(2 * n);
        Map<String, Integer> table = new HashMap<>(2 * n);
        int idx = 0;
        for (int i = 0; i < equations.size(); i++) {
            for (String s : equations.get(i)) {
                if (!table.containsKey(s)) {
                    table.put(s, idx);
                    idx++;
                }
            }
            unionFind.union(table.get(equations.get(i).get(0)), table.get(equations.get(i).get(1)), values[i]);
        }
        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; i++) {
            if (!table.containsKey(queries.get(i).get(0))
                    || !table.containsKey(queries.get(i).get(1))) res[i] = -1.0d;
            else {
                int x = table.get(queries.get(i).get(0));
                int y = table.get(queries.get(i).get(1));
                res[i] = unionFind.isConnected(x,y);
            }
        }
        return res;
    }

    private class UnionFind {
        private int[] parents;
        private double[] weights;

        public void init() {
            int n = parents.length;
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                weights[i] = 1.0d;
            }
        }

        public UnionFind(int n) {
            parents = new int[n];
            weights = new double[n];
            init();
        }

        public int find(int x) {
            if (x != parents[x]) {
                int origin = parents[x];
                parents[x] = find(parents[x]);
                weights[x] *= weights[origin];
            }
            return parents[x];
        }

        public void union(int x, int y, double value) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x != root_y) {
                parents[root_x] = root_y;
                weights[root_x] = weights[y] * value / weights[x];
            }
        }

        public double isConnected(int x, int y) {
            int root_x = find(x);
            int root_y = find(y);
            if (root_x != root_y) return -1.0d;
            return weights[x] / weights[y];
        }
    }

    public static void main(String[] args) {
        List<List<String>> es = new ArrayList<List<String>>(){{
            add(new ArrayList<String>(){{
                add("a");add("b");
            }});
            add(new ArrayList<String>(){{
                add("b");add("c");
            }});
        }};
        double [] values = new double[]{2.0,3.0};
        List<List<String>> qs = new ArrayList<List<String>>(){{
            add(new ArrayList<String>(){{
                add("a");add("c");
            }});
            add(new ArrayList<String>(){{
                add("b");add("a");
            }});
            add(new ArrayList<String>(){{
                add("a");add("e");
            }});
            add(new ArrayList<String>(){{
                add("a");add("a");
            }});
            add(new ArrayList<String>(){{
                add("x");add("x");
            }});
        }};
        q399 q = new q399();
        for(double d:q.calcEquation(es,values,qs)){
            System.out.println(d);
        }
    }
}
