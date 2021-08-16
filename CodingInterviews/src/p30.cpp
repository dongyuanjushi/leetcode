#include <bits/stdc++.h>
using namespace std;

class MinStack {
private:
    stack<int> data;
    stack<int> des_data;
public:
    /** initialize your data structure here. */
    MinStack() {

    }
    
    void push(int x) {
        if(des_data.empty()||des_data.top()>=x) des_data.push(x);
        data.push(x);
    }
    
    void pop() {
        int x=data.top();
        data.pop();
        if(!des_data.empty()&&x==des_data.top()) des_data.pop();
    }
    
    int top() {
        return data.top();
    }
    
    int min() {
        return des_data.top();
    }
};
int main(){
    MinStack ms;
    ms.push(-1);
    ms.push(1);
    ms.push(2);
    ms.push(-2);
    cout<<ms.min();
    return 0;
}