import java.util.*;

public class q752 {
    public int openLock(String[] deadends, String target) {
        String zero = "0000";
        if (target.equals(zero)) return 0;
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains(zero)) return -1;
        Queue<String> frontQueue = new LinkedList<>();
        Queue<String> backQueue = new LinkedList<>();
        Map<String, Integer> frontMap = new HashMap<>();
        Map<String, Integer> backMap = new HashMap<>();
        frontQueue.add(zero);
        backQueue.add(target);
        frontMap.put(zero, 0);
        backMap.put(target, 0);
        while (!frontQueue.isEmpty() && !backQueue.isEmpty()) {
            int ans = -1;
            if (frontQueue.size() <= backQueue.size()) {
                ans = update(set, frontQueue, frontMap, backMap);
            } else {
                ans = update(set, backQueue, backMap, frontMap);
            }
            if (ans != -1) return ans;
        }
        return -1;
    }

    public int update(Set<String> set, Queue<String> currentQueue, Map<String, Integer> currentMap, Map<String, Integer> otherMap) {
        String currentWord = currentQueue.poll();
        int step = currentMap.get(currentWord);
        char[] word = currentWord.toCharArray();
        for (int i = 0; i < 4; i++) {
            for (int j = -1; j <= 1; j++) {
                if (j == 0) continue;
                int origin = word[i] - '0';
                int next = (origin + j) % 10;
                if (next == -1) next = 9;
                char[] clone = word.clone();
                clone[i] = (char) (next + '0');
                String str = String.valueOf(clone);
                if (set.contains(str)) continue;
                if (currentMap.containsKey(str)) continue;
                if (otherMap.containsKey(str)) {
                    return step + 1 + otherMap.get(str);
                } else {
                    currentQueue.add(str);
                    currentMap.put(str, step + 1);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        q752 q = new q752();
        String [] deadends={"0201","0101","0102","1212","2002"};
        String target="0202";
        System.out.println(q.openLock(deadends,target));
    }
}
