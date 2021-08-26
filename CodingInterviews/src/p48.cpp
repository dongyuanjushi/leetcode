#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n=s.length();
        if(n==0) return 0;
        int res=0,tmp=0;
        unordered_map<char,int> m;
        for(int i=0;i<n;i++){
            int j;
            if(m.find(s[i])==m.end()) j=-1;
            else j=m[s[i]];
            m[s[i]]=i;
            tmp=tmp<i-j?tmp+1:i-j;
            res=max(tmp,res);
        }
        return res;
    }
};
int main(){
    Solution sol;
    string s;
    cin>>s;
    cout<<sol.lengthOfLongestSubstring(s);
    return 0;
}