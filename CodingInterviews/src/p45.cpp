#include <bits/stdc++.h>
using namespace std;
bool cmp(int a,int b){
    string sa=to_string(a);
    string sb=to_string(b);
    return sa+sb<sb+sa;
}
class Solution {
public:
    string minNumber(vector<int>& nums) {
        sort(nums.begin(),nums.end(),cmp);
        string s;
        for(auto& n:nums) s+=(to_string(n));
        return s;
    }
};
int main(){
    Solution sol;
    vector<int> nums={121,12};
    cout<<sol.minNumber(nums);
    return 0;
}