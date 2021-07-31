import java.util.*;

public class q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        Queue<String> frontQueue = new LinkedList<>();
        Queue<String> backQueue = new LinkedList<>();
        wordSet.remove(beginWord);
        frontQueue.add(beginWord);
        backQueue.add(endWord);
        Map<String, Integer> frontMap = new HashMap<>();
        Map<String, Integer> backMap = new HashMap<>();
        frontMap.put(beginWord, 1);
        backMap.put(endWord, 1);
        while (!frontQueue.isEmpty() && !backQueue.isEmpty()) {
            int ans;
            if (frontQueue.size() <= backQueue.size()) {
                ans = update(wordSet,frontQueue,frontMap,backMap);
            } else {
                ans = update(wordSet,backQueue,backMap,frontMap);
            }
            if (ans != 0) return ans;
        }
        return 0;
    }

    private int update(Set<String> wordSet, Queue<String> currentQueue, Map<String, Integer> currentMap, Map<String, Integer> otherMap) {
        String currentWord = currentQueue.poll();
        int step = currentMap.get(currentWord);
        assert currentWord != null;
        char[] letters = currentWord.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            char current = letters[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == current) continue;
                letters[i] = c;
                String next = String.valueOf(letters);
                if (wordSet.contains(next)) {
                    if (currentMap.containsKey(next)) continue;
                    if (otherMap.containsKey(next)) return step + otherMap.get(next);
                    currentQueue.add(next);
                    currentMap.put(next, step + 1);
                }
            }
            letters[i] = current;
        }
        return 0;
    }
}
