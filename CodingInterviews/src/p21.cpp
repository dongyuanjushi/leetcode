#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int l=0,r=nums.size()-1;
        while(l<r){
            if(nums[l]%2==0){
                while(l<r&&nums[r]%2==0){
                    r--;
                }
                int t=nums[l];
                nums[l]=nums[r];
                nums[r]=t;
            }
            l++;
        }
        return nums;
    }
};

int main(){
    Solution sol;
    vector<int> res={1,4,2,3,5,6};
    vector<int> ans=sol.exchange(res);
    for(auto& a:ans) cout<<a<<" ";
    cout<<endl;
    return 0;
}