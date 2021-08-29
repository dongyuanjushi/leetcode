#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        return helper(nums,target)-helper(nums,target-1);
    }
    int helper(vector<int>& nums,int target){
        int left=0,right=nums.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]<=target) left=mid+1;
            else right=mid-1;
        }
        return left;
    }
};
int main(){
    Solution sol;
    vector<int> nums={2,3,3,5,6};
    cout<<sol.search(nums,3);
    return 0;
}