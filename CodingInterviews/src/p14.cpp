#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int cuttingRope(int n) {
        int d=1000000007;
        if(n<=3) return n-1;
        if(n%3==0) return fast_pow(3,n/3,d);
        else if(n%3==1) return (fast_pow(3,n/3-1,d)*4)%d;
        else return (fast_pow(3,n/3,d)*2)%d;
    }
    long fast_pow(int x,int n,int d){
        long res=1;
        long t=x;
        while(n>0){
            if(n&1) res=(res*t)%d;
            t=(t*t)%d;
            n=n/2;
        }
        cout<<res<<endl;
        return res;
    }
};

int main(int argc, char const *argv[])
{
    Solution s;
    int n;
    cin>>n;
    cout<<s.cuttingRope(n);
    return 0;
}
