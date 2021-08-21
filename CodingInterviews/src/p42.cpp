#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res=INT32_MIN;
        int t=0;
        for(int num:nums){
            t+=num;
            res=max(res,t);
            if(t<0) t=0;
        }
        return res;
    }
};
int main(){
    vector<int> nums={-2,1,-3,4,-1,2,1,-5,4};
    Solution sol;
    cout<<sol.maxSubArray(nums);
    return 0;
}