import java.util.*;

public class q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet=new HashSet<>(wordList);
        if(wordSet.size()==0||!wordSet.contains(endWord)) return 0;
        Queue<String> queue=new LinkedList<>();
        Set<String> visited=new HashSet<>();
        int step=1;
        wordSet.remove(beginWord);
        queue.add(beginWord);
        while (!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String current=queue.poll();
                if(change(current,endWord,wordSet,queue,visited)) return step+1;
            }
            step++;
        }
        return 0;
    }
    private boolean change(String current,String end,Set<String> wordSet,Queue<String> queue,Set<String> visited){
        char [] word=current.toCharArray();
        for(int i=0;i<word.length;i++){
            char c=word[i];
            for(char j='a';j<='z';j++){
                if(j==c) continue;
                word[i]=j;
                String next=String.valueOf(word);
                if(wordSet.contains(next)){
                    if(next.equals(end)) return true;
                    if(!visited.contains(next)){
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            word[i]=c;
        }
        return false;
    }
}
