#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int numTrees(int n) {
        vector<int> dp(n+1,0);
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
            // cout<<dp[i]<<endl;
        }
        return dp[n];
    }
};
int main(){
    int n;
    cin>>n;
    Solution s;
    s.numTrees(n);
    return 0;
}