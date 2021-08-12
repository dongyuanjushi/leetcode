#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int movingCount(int m, int n, int k) {
        queue<vector<int>> que;
        vector<vector<bool>> visited(m,vector<bool>(n,0));
        que.push({0,0,0,0});
        int res=0;
        while (!que.empty())
        {
            vector<int> cur=que.front();
            que.pop();
            int i=cur[0],j=cur[1],si=cur[2],sj=cur[3];
            if(i>=m||j>=n||si+sj>k||visited[i][j]) continue;
            visited[i][j]=true;
            res++;
            if(i<m-1) que.push({i+1,j,(i+1)%10==0?si-8:si+1,sj});
            if(j<n-1) que.push({i,j+1,si,(j+1)%10==0?sj-8:sj+1});
        }
        return res;
    }
};

int main(){
    return 0;
}