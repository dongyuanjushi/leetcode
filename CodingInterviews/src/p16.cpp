#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    double myPow(double x, int n) {
        long b=n;
        if(n<0){
            x=1/x;
            b=-b;
        }
        double res=1;
        while(b!=0){
            if(b&1==1){
                res*=x;
            }
            x*=x;
            b=b>>1;
        }
        return res;
    }
};

int main(){
    Solution s;
    double x;
    int n;
    cin>>x>>n;
    cout<<s.myPow(x,n);
    return 0;
}