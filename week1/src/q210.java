import java.util.*;

public class q210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> table = new HashMap<>();
        for (int[] pre : prerequisites) {
            in[pre[0]]++;
            if (!table.containsKey(pre[1])) {
                table.put(pre[1], new ArrayList<>());
            }
            table.get(pre[1]).add(pre[0]);
        }
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            res.add(current);
            if (table.containsKey(current)) {
                for (int i : table.get(current)) {
                    in[i]--;
                    if (in[i] == 0) queue.add(i);
                }
            }
        }
        if (res.size() < numCourses) return new int[0];
        else {
            int[] r = new int[numCourses];
            for (int i = 0; i < res.size(); i++) {
                r[i] = res.get(i);
            }
            return r;
        }
    }
}
