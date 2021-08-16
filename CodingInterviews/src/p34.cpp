#include <bits/stdc++.h>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
class Solution {
private:
    vector<vector<int>> paths;
    vector<int> path;
public:
    vector<vector<int>> pathSum(TreeNode* root, int target) {
        if(root==nullptr) return paths;
        dfs(root,target);
        return paths;
    }
    void dfs(TreeNode *root,int target){
        if(!root->left&&!root->right){
            if(root->val==target){
                path.push_back(root->val);
                paths.push_back(vector<int>(path));
                path.pop_back();
            }
            return;
        }
        path.push_back(root->val);
        if(root->left) dfs(root->left,target-root->val);
        if(root->right) dfs(root->right,target-root->val);
        path.pop_back();
    }
};
int main(){


    return 0;
}