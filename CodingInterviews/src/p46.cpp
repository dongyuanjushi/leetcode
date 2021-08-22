#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int res=0;
public:
    int translateNum(int num) {
        string s=to_string(num);
        int l=s.length();
        if(l<2) return 1;
        int m=1,n=1;
        for(int i=1;i<=l;i++){
            int value=10*(s[i-2]-'0')+s[i-1]-'0';
            if(value>=10&&value<=26){
                int t=n;
                n=m+n;
                m=t;
            }
            else{
                m=n;
            }
        }
        return n;
    }
};
int main(){
    Solution sol;
    int n;
    cin>>n;
    cout<<sol.translateNum(n);
    return 0;
}