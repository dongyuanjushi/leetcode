import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class q216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        int [] used=new int[10];
        Arrays.fill(used,0);
        dfs(1,new LinkedList<Integer>(),res,used,k,n);
        return res;
    }
    public void dfs(int start, LinkedList<Integer> cur, List<List<Integer>> res, int [] used, int k, int n){
        if(n==0&&cur.size()==k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<=9;i++){
            if(i>n) return;
            if(used[i]==1) continue;
            cur.add(i);
            used[i]=1;
            dfs(i+1,cur,res,used,k,n-i);
            used[i]=0;
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        q216 q = new q216();
        q.combinationSum3(3,7);
    }
}
