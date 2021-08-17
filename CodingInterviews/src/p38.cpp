#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    vector<string> res;
    string s;
    string t;
public:
    vector<string> get_res(){
        return this->res;
    }
    vector<string> permutation(string s) {
        sort(s.begin(),s.end());
        this->s=s;
        vector<bool> visited(s.length(),false);
        dfs(visited);
        return res;
    }
    void dfs(vector<bool> visited){
        if(t.length()==s.length()){
            res.push_back(t);
            return;
        }
        for(int i=0;i<s.length();i++){
            if(visited[i]) continue;
            if(i>0&&s[i]==s[i-1]&&!visited[i-1]) continue;
            visited[i]=true;
            t.push_back(s[i]);
            dfs(visited);
            t.pop_back();
            visited[i]=false;
        }
    }
};
int main(){
    Solution sol;
    string s="aac";
    sol.permutation(s);
    for(auto& r:sol.get_res()) cout<<r<<endl;
    return 0;
}