#include <bits/stdc++.h>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
TreeNode* generateByLC(vector<string> list){
    queue<TreeNode*> path;
    if(list[0]=="NULL") return nullptr;
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
    bool isSubStructure(TreeNode* A, TreeNode* B) {
        if(A==nullptr||B==nullptr) return false;
        return dfs(A,B)||isSubStructure(A->left,B)||isSubStructure(A->right,B);
    }
    bool dfs(TreeNode *A,TreeNode *B){
        if(B==nullptr) return true;
        if(A==nullptr||A->val!=B->val) return false;
        return dfs(A->left,B->left)&&dfs(A->right,B->right);
    }
};
int main(){
    vector<string> node_a={"1","2","3","4","NULL","NULL","NULL"};
    vector<string> node_b={"3"};
    TreeNode *a=generateByLC(node_a);
    TreeNode *b=generateByLC(node_b);
    Solution sol;
    cout<<sol.isSubStructure(a,b);
    return 0;
}