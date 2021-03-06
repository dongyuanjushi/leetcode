#include <bits/stdc++.h>
using namespace std;
class Node{
public:
    int val;
    Node *next;
    Node *random;
    Node(int val){
        this->val=val;
    }
};
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==nullptr) return nullptr;
        unordered_map<Node*,Node*> m;
        Node *cur=head;
        while(cur!=nullptr){
            m[cur]=new Node(cur->val);
            cur=cur->next;
        }
        cur=head;
        while(cur!=nullptr){
            m[cur]->next=m[cur->next];
            m[cur]->random=m[cur->random];
            cur=cur->next;
        }
        return m[head];
    }
};
int main(){


    return 0;
}