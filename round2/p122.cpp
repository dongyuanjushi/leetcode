#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int maxProfit(vector<int> &prices)
    {
        int len = prices.size();
        vector<vector<int>> dp(2, vector<int>(2)); 
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++)
        {
            dp[i % 2][0] = max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] -
                                                       prices[i]);
            dp[i % 2][1] = max(dp[(i - 1) % 2][1], prices[i] + dp[(i - 1) % 2]
                                                                 [0]);
        }
        return dp[(len - 1) % 2][1];
    }
};
int main()
{

    return 0;
}