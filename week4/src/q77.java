import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class q77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(1,n,k,new ArrayDeque<Integer>(),res);
        return res;
    }
    public void dfs(int start, int n, int k, Deque<Integer> tmp, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(tmp));
        }
        for(int i=start;i<=n;i++){
            tmp.add(i);
            dfs(i+1,n,k-1,tmp,res);
            tmp.removeLast();
        }
    }

    public static void main(String[] args) {
        q77 q = new q77();
        q.combine(1,1);
    }
}
