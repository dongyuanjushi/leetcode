#include <bits/stdc++.h>
using namespace std;

class Solution{
public:
    vector<double> dicesProbability(int n) {
        vector<double> dp(6,1.0/6);
        for(int i=2;i<=n;i++){
            vector<double> tmp(5*i+1,0);
            int size=dp.size();
            for(int j=0;j<size;j++){
                for(int k=0;k<6;k++){
                    tmp[j+k]+=dp[j]/6.0;
                }
            }
            dp=tmp;
        }
        return dp;
    }
};


int main(){
    Solution sol;
    int n;
    cin>>n;
    vector<double> res=sol.dicesProbability(n);
    for(auto& r:res) cout<<r<<" ";
    return 0;
}