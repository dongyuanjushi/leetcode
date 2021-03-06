#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        vector<int> dp(target+1,0);
        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int n:nums){
                if(i>=n&&dp[i]<INT32_MAX-dp[i-n]) dp[i]+=dp[i-n];
            }
        }
        return dp[target];
    }
};
int main(){


    return 0;
}