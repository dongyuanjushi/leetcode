#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> singleNumbers(vector<int>& nums) {
        int x=0,y=0,m=1,n=0;
        for(int num:nums){
            n^=num;
        }
        while((n&m)==0){
            m<<=1;
        }
        for(int num:nums){
            if(num&m) x^=num;
            else y^=num;
        }
        return vector<int>{x,y};
    }
};
int main(){
    Solution sol;
    vector<int> nums={4,1,4,6};
    vector<int> res=sol.singleNumbers(nums);
    for(auto &r:res) cout<<r<<" ";
    return 0;
}