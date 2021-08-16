#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool verifyPostorder(vector<int>& postorder) {
        stack<int> st;
        int root=INT32_MAX;
        st.push(root);
        for(int i=postorder.size()-1;i>=0;i--){
            if(postorder[i]>root) return false;
            while(!st.empty()&&st.top()>postorder[i]){
                root=st.top();
                st.pop();
            }
            st.push(postorder[i]);
        }
        return true;
    }
};
int main(){


    return 0;
}