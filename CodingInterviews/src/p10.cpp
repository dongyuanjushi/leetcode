#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    int rectCover(int number) {
        if(number<=2) return number;
        int pre=1,res=2;
        for(int i=3;i<=number;i++){
            int tmp=pre;
            pre=res;
            res+=tmp;
        }
        return res;
    }
};