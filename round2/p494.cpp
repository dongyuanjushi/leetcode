#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findTargetSumWays(vector<int>& nums, int target) {
        int sum=0;
        for(int n:nums) sum+=n;
        if((sum+target)%2==1) return 0;
        int obj = (sum+target)/2;
        vector<int> dp(obj+1,1);
        for(int i=0;i<nums.size();i++){
            for(int j=obj;j>=nums[i];j--){
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[obj];
    }
};
int main(){


    return 0;
}