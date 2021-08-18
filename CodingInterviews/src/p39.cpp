#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int x=0,count=0,i=0;
        for(int num:nums){
            if(i==0) x=num;
            i+=num==x?1:-1;
        }
        for(int num:nums){
            if(num==x) count++;
        }
        return count>nums.size()/2?x:0;
    }
};
int main(){


    return 0;
}