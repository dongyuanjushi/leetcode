#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    char firstUniqChar(string s) {
        vector<int> dict(128,0);
        for(char c:s){
            dict[c-'0']++;
        }
        for(char c:s){
            if(dict[c-'0']==1) return c;
        }
        return ' ';
    }
};
int main(){
    Solution sol;
    string s;
    cin>>s;
    cout<<sol.firstUniqChar(s);
    return 0;
}