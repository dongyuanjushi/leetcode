#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int findNthDigit(int n) {
        int digit=1;
        long count=9,start=1;
        while(n>count){
            n-=count;
            digit+=1;
            start*=10;
            count=9*digit*start;
        }
        long t=(n-1)/digit+start;
        int offset=(n-1)%digit;
        return to_string(t)[offset]-'0';
    }
};

int main(){
    Solution sol;
    int n;
    cin>>n;
    cout<<sol.findNthDigit(n);
    return 0;
}