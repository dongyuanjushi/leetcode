#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lastStoneWeightII(vector<int>& stones) {
        int sum=0;
        for(int n:stones) sum+=n;
        int target=sum/2;
        vector<int> dp(target,0);
        for(int i=0;i<stones.size();i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }
};
int main(){


    return 0;
}