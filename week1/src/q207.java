import java.util.*;

class q207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] in = new int[numCourses];
        Map<Integer, List<Integer>> table = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int[] pre : prerequisites) {
            in[pre[0]] += 1;
            if (!table.containsKey(pre[1])) {
                table.put(pre[1], new ArrayList<>());
            }
            table.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) queue.add(i);
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count += 1;
            if(table.containsKey(current)){
                for (int i : table.get(current)) {
                    in[i] -= 1;
                    if (in[i] == 0) {
                        queue.add(i);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {

    }
}
