#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return 0;
        if(n==1) return nums[0];
        int r1=subRob(nums,0,n-1);
        int r2=subRob(nums,1,n);
        return max(r1,r2);
    }
    int subRob(vector<int> &nums,int start,int end){
        vector<int> dp(end,0);
        int a=nums[start];
        if(end-start==1) return nums[start];
        int b=max(nums[start],nums[start+1]);
        int c=b;
        for(int i=start+2;i<end;i++) {
            c=max(a+nums[i],b);
            a=b;
            b=c;
        }
        return c;
    }
};
int main(){


    return 0;
}