import java.lang.reflect.Array;
import java.util.*;

public class q802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> table = new HashMap<>();
        int[] in = new int[n];
        for (int i = 0; i < n; i++) {
            in[i] = graph[i].length;
            for (int j : graph[i]) {
                if (!table.containsKey(j)) {
                    table.put(j, new ArrayList<>());
                }
                table.get(j).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) queue.add(i);
        }
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            temp.add(current);
            if (table.containsKey(current)) {
                for (int i : table.get(current)) {
                    in[i]--;
                    if (in[i] == 0) queue.add(i);
                }
            }
        }
        Collections.sort(temp);
        return temp;
    }

}
