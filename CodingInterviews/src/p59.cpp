#include <bits/stdc++.h>
using namespace std;
class MaxQueue {
public:
    queue<int> queue;
    deque<int> maxqueue; 
    MaxQueue() {

    }
    
    int max_value() {
        int max;
        if(!maxqueue.empty()) {
            max = maxqueue.front();
        }else {
            max = -1;
        }
       return max;
    }
    
    void push_back(int value) {
        queue.push(value);
        while(!maxqueue.empty() && value > maxqueue.back()){
            maxqueue.pop_back(); 
        }
        maxqueue.push_back(value);
    }
    
    int pop_front() {
        int p;
        if(!queue.empty()) {
            p = queue.front();
            queue.pop();
        }else{
            return -1;
        }
        if(!maxqueue.empty() && p == maxqueue.front()){
            maxqueue.pop_front(); 
        }
        return p;
    }
};

int main(){


    return 0;
}