#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool isMatch(string s, string p) {
        int m=s.length();
        int n=p.length();
        vector<vector<bool>> dp(m+1,vector<bool>(n+1,false));
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j==0) dp[i][0]=i==0;
                else{
                    if(p[j-1]=='*'){
                        if(j>1){
                            dp[i][j]=dp[i][j-2]|dp[i][j];
                            char c=p[j-2];
                            if(i>0&&(s[i-1]==c||c=='.')){
                                dp[i][j]=dp[i-1][j]|dp[i][j];
                            }
                        }
                    }
                    else{
                        if(i>0&&(s[i-1]==p[j-1]||p[j-1]=='.')) dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        return dp[m][n];
    }
};