#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int integerBreak(int n) {
        if(n<=3) return n-1;
        if(n%3==0) return (int)fast_pow(3,n/3);
        else if(n%3==1) return (int)fast_pow(3,n/3-1)*4;
        else return (int)fast_pow(3,n/3)*2;
    }

    long fast_pow(int x,int n){
        long res = 1;
        long t=x;
        while(n){
            if(n&1) res*=t;
            t*=t;
            n>>=1;
        }
        return res;
    }
};
int main(){


    return 0;
}