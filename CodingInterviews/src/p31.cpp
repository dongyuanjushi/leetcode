#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        stack<int> st;
        int i=0;
        for(int num:pushed){
            st.push(num);
            while(!st.empty()&&popped[i]==st.top()){
                st.pop();
                i++;
            }
        }
        return st.empty();
    }
};
int main(){


    return 0;
}