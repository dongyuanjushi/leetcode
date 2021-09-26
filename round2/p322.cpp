#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        vector<int> dp(amount+1,INT32_MAX);
        dp[0]=0;
        for(int c:coins) dp[c]=1;
        for(int c:coins){
            for(int i=c;i<=amount;i++){
                if(dp[i-c]!=INT32_MAX) dp[i]=min(dp[i],dp[i-c]);
            }
        }
        return dp[amount];
    }
};
int main(){


    return 0;
}