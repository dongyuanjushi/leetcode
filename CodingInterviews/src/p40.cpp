#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> getLeastNumbers(vector<int>& arr, int k) {
        quicksort(arr,0,arr.size());
        vector<int> res;
        for(int i=0;i<k;i++) res.push_back(arr[i]);
        return res;
    }
    void quicksort(vector<int>& arr,int left,int right){
        if(left>=right) return;
        int p=partition(arr,left,right);
        quicksort(arr,left,p);
        quicksort(arr,p+1,right);
    }
    int partition(vector<int>& arr,int left,int right){
        int t=arr[left];
        int idx=left;
        for(int i=left+1;i<right;i++){
            if(arr[i]<t){
                int tmp=arr[++idx];
                arr[idx]=arr[i];
                arr[i]=tmp;
            }
        }
        arr[left]=arr[idx];
        arr[idx]=t;
        return idx;
    }
};
int main(){
    Solution sol;
    vector<int> arr={0,0,1,2,4,2,2,3,1,4};
    sol.quicksort(arr,0,arr.size());
    for(auto &a:arr) cout<<a<<" ";
    return 0;
}