import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class q839 {
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        Map<String,Integer> table = new HashMap<>();
        int idx=0;
        for(int i=0;i<n;i++){
            if(!table.containsKey(strs[i])){
                table.put(strs[i],idx++);
            }
        }
        UnionFind unionFind = new UnionFind(table.size());
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(is_similar(strs[i],strs[j])) unionFind.union(table.get(strs[i]),table.get(strs[j]));
            }
        }
        return unionFind.get_count();
    }

    public boolean is_similar(String s1, String s2) {
        int n = s1.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if(count>2) return false;
        }
        return true;
    }

    private class UnionFind {
        private int[] parents;
        private int[] ranks;
        public int count;

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
            count = n;
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
                parents[root_y] = parents[root_x];
                if (ranks[root_x] == ranks[root_y]) ranks[root_x] += 1;
                count--;
            }
        }
        public int get_count(){
            return count;
        }
    }
}
