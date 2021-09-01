#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n=prices.size();
        if(n==0) return 0;
        int res=0,cur=0;
        for(int i=1;i<n;i++){
            cur+=(prices[i]-prices[i-1]);
            if(cur<0) cur=0;
            res=max(res,cur);
        }  
        return res; 
    }
};
int main(){


    return 0;
}