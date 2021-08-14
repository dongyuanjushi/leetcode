#include <bits/stdc++.h>
using namespace std;
class Solution {
public:
    bool isNumber(string s) {
        int l=0,r=s.length()-1;
        while(l<s.length()&&s[l]==' ') l++;
        while(r>=0&&s[r]==' ') r--;
        if(r<l) return false;
        bool has_num=false,has_dot=false,has_e=false;
        for(int i=l;i<r+1;i++){
            if(is_num(s[i])) has_num=true;
            else if(s[i]=='+'||s[i]=='-'){
                if(i>l||(s[i-1]!='e'&&s[i-1]!='E')) return false;
            }
            else if(s[i]=='.'){
                if(has_dot) return false;
                if(i>l&&!is_num(s[i-1])) return false;
                if(i<r&&!is_num(s[i+1])) return false;
                has_dot=true;
            }
            else if(s[i]=='e'||s[i]=='E'){
                if(has_e) return false;
                if(i==l||!is_num(s[i-1])) return false;
                if(i==r||!(is_num(s[i+1])||s[i+1]=='-'||s[i+1]=='+')) return false;
                has_e=true;
            }
            else return false;
        }
        return has_num;
    }
    bool is_num(char c){
        return c>='0'&&c<='9';
    }
};
int main(){
    string s="-1E-16";
    Solution sol;
    cout<<sol.isNumber(s)<<endl;
    return 0;
}