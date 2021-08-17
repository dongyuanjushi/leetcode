#include <bits/stdc++.h>
using namespace std;
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};
TreeNode* generateByLC(vector<string> list){
    if(list.size()==0||list[0]=="NULL") return nullptr;
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
            if(i<list.size()){
                if(list[i]=="NULL")
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
void preorder(TreeNode *root){
    if(root==nullptr) return;
    cout<<root->val<<" ";
    preorder(root->left);
    preorder(root->right);
}
class Codec {
private:
    vector<string> nodes;
public:
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string s="";
        queue<TreeNode *> q;
        s+="[";
        if(root!=nullptr){
            q.push(root);
            bool is_valid=true;
            while(!q.empty()){
                if(!is_valid) break;
                is_valid=false;
                int size=q.size();
                for(int i=0;i<size;i++){
                    TreeNode *cur=q.front();
                    q.pop();
                    if(cur==nullptr) s+="NULL,";
                    else{
                        s+=(to_string(cur->val)+",");
                        q.push(cur->left);
                        q.push(cur->right);
                        if(cur->left||cur->right) is_valid=true;
                    }
                }
            }
            s.erase(s.length()-1);
        }
        s+="]";
        return s;
    }

    void split(string s,string spacer)
    {
        int pos1,pos2;
        int len=spacer.length();     //记录分隔符的长度
        pos1=0;
        pos2=s.find(spacer);
        while( pos2 != string::npos )
        {
            nodes.push_back( s.substr(pos1,pos2-pos1) );
            pos1 = pos2 + len;
            pos2 = s.find(spacer,pos1);    // 从str的pos1位置开始搜寻spacer
        }
        if(pos1 != s.length()) //分割最后一个部分
        nodes.push_back(s.substr(pos1));
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data=="[]") return nullptr;
        data=data.substr(1,data.length()-2);
        split(data,",");
        TreeNode *root;
        if(nodes.size()==0||nodes[0]=="NULL") return root;
        root=new TreeNode(stoi(nodes[0]));
        queue<TreeNode *> q;
        q.push(root);
        int j=1;
        while(j<nodes.size()){
            int size=q.size();
            for(int i=0;i<size&&j<nodes.size();i++){
                TreeNode *cur=q.front();
                q.pop();
                if(nodes[j]=="NULL") cur->left=nullptr;
                else{
                    cur->left=new TreeNode(stoi(nodes[j]));
                    q.push(cur->left);
                }
                j++;
                if(j<nodes.size()){
                    if(nodes[j]=="NULL") cur->right=nullptr;
                    else{
                        cur->right=new TreeNode(stoi(nodes[j]));
                        q.push(cur->right);
                    }
                }
                j++;
            }
        }
        return root;
    }
};
int main(){
    vector<string> nodes={"NULL"};
    TreeNode *root=generateByLC(nodes);
    Codec cc;
    string data=cc.serialize(root);
    cout<<data;
    preorder(cc.deserialize(data));
    return 0;
}