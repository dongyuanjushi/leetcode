#include <bits/stdc++.h>
using namespace std;

class MedianFinder {
private:
    priority_queue<double,vector<double>,greater<double>> a;
    priority_queue<double,vector<double>,less<double>> b;

public:
    /** initialize your data structure here. */
    MedianFinder() {

    }
    
    void addNum(int num) {
        if(a.size()!=b.size()){
            a.push(num);
            b.push(a.top());
            a.pop();
        }else{
            b.push(num);
            a.push(b.top());
            b.pop();
        }
    }
    
    double findMedian() {
        return a.size()!=b.size()?a.top():(a.top()+b.top())/2;
    }
};
int main(){


    return 0;
}