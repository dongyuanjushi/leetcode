#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findMaxForm(vector<string>& strs, int m, int n) {
        vector<vector<int>> dp(m+1,vector<int>(n+1,0));
        for(string s:strs){
            int zeros=0,ones=0;
            for(char c:s){
                if(c=='0') zeros++;
                else ones++;
            }
            for(int j=m;j>=zeros;j--){
                for(int k=n;k>=ones;k--){
                    dp[j][k]=max(dp[j][k],dp[j-zeros][k-ones]+1);
                }
            }
        }
        return dp[m][n];
    }
    
};
int main(){


    return 0;
}