#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res;
        int left=0,right=nums.size()-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                res.push_back(nums[left]);
                res.push_back(nums[right]);
            }else if(nums[left]+nums[right]>target) right--;
            else left++;
        }
        return res;
    }
};
int main(){


    return 0;
}