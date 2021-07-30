public class q79 {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        if(m==0) return false;
        int n=board[0].length;
        int [][] used=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    if(check(board,i,j,1,word,used)) return true;
                }
            }
        }
        return false;
    }
    public boolean check(char [][] board,int i,int j,int idx,String word,int [][] used){
        if(idx==word.length()) return true;
        used[i][j]=1;
        if(i>0&&used[i-1][j]==0&&board[i-1][j]==word.charAt(idx)){
            if(check(board,i-1,j,idx+1,word,used)) return true;
        }
        if(i<board.length-1&&used[i+1][j]==0&&board[i+1][j]==word.charAt(idx)){
            if(check(board,i+1,j,idx+1,word,used)) return true;
        }
        if(j>0&&used[i][j-1]==0&&board[i][j-1]==word.charAt(idx)){
            if(check(board,i,j-1,idx+1,word,used)) return true;
        }
        if(j<board[0].length-1&&used[i][j+1]==0&&board[i][j+1]==word.charAt(idx)){
            if(check(board,i,j+1,idx+1,word,used)) return true;
        }
        used[i][j]=0;
        return false;
    }

    public static void main(String[] args) {
        q79 q = new q79();
        char [][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        boolean res=q.exist(board,word);
        System.out.println(res);
    }
}
