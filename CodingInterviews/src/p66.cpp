#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> constructArr(vector<int>& a) {
        int len = a.size();
        if(len == 0) return {};
        vector<int> b(len, 1);
        b[0] = 1;
        int tmp = 1;
        for(int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for(int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
};
int main(){
    Solution sol;
    vector<int> nums={1,2,3,4,5};
    vector<int> res=sol.constructArr(nums);
    for(auto& r:res) cout<<r<<" ";
    return 0;
}