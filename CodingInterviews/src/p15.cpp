#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int hammingWeight(uint32_t n) {
        int res=0;
        while(n!=0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
};

int main(){
    uint32_t n;
    Solution s;
    cin>>n;
    cout<<s.hammingWeight(n);
    return 0;
}