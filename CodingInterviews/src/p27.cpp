#include <bits/stdc++.h>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
void preorder(TreeNode *root){
    if(root==nullptr) return;
    cout<<root->val<<" ";
    preorder(root->left);
    preorder(root->right);
}
TreeNode* generateByLC(vector<string> list){
    queue<TreeNode*> path;
    TreeNode* root=new TreeNode(stoi(list[0]));
    path.push(root);
    int i=1;
    while(i<list.size()){
        int size=path.size();
        for(int j=0;j<size&&i<list.size();++j){
        TreeNode* node=path.front();
        path.pop();
        if(list[i]=="NULL"){
        node->left=NULL;
        }else{
            TreeNode* newNode=new TreeNode(stoi(list[i]));
            node->left=newNode;
            path.push(newNode);
        }
        ++i;
        if(i<list.size()&&list[i]=="NULL"){
        node->right==NULL;
        }else{
            TreeNode* newNode=new TreeNode(stoi(list[i]));
            node->right=newNode;
            path.push(newNode);
        }
        ++i;
        }
    }
    return root;
}
class Solution {
public:
    TreeNode* mirrorTree(TreeNode* root) {
        if(root==nullptr) return nullptr;
        TreeNode *t=root->left;
        root->left=root->right;
        root->right=t;
        mirrorTree(root->left);
        mirrorTree(root->right);
        return root;
    }
};
int main(){
    Solution sol;
    vector<string> node_a={"1","2","3","4","5","6","NULL"};
    TreeNode *a=generateByLC(node_a);
    a=sol.mirrorTree(a);
    preorder(a);
    return 0;
}