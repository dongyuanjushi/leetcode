#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int nthUglyNumber(int n) {
        int a=0,b=0,c=0;
        vector<int> dp(n,0);
        dp[0]=1;
        for(int i=1;i<n;i++){
            int n2=dp[a]*2,n3=dp[b]*3,n5=dp[c]*5;
            int t=min(n2,min(n3,n5));
            dp[i]=t;
            if(n2<=t) a++;
            if(n3<=t) b++;
            if(n5<=t) c++;
        }
        return dp[n-1];
    }
};
int main(){
    Solution sol;
    int n;
    cin>>n;
    cout<<sol.nthUglyNumber(n);
    return 0;
}