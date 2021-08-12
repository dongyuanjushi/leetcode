#include <bits/stdc++.h>
using namespace std;
class Solution
{
private:
    int d[4][2] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    string word;
    vector<vector<char>> board;
public:
    bool exist(vector<vector<char>> &board, string word)
    {
        this->board=board;
        this->word=word;
        int m = board.size();
        if (m == 0) return false;
        int n = board[0].size();
        if (n == 0) return false;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (board[i][j] == word[0])
                {
                    this->board[i][j]='\0';
                    if (dfs(i, j, m, n, 1)) return true;
                    this->board[i][j]=word[0];
                }
            }
        }
        return false;
    }
    bool dfs(int i, int j, int m, int n, int idx)
    {
        if (idx == word.length()) return true;
        for (int k = 0; k < 4; k++)
        {
            int x = i + d[k][0];
            int y = j + d[k][1];
            if (inArea(x, y, m, n) && board[x][y] == word[idx])
            {
                board[x][y]='\0';
                if (dfs(x, y, m, n, idx + 1)) return true;
                board[x][y]=word[idx];
            }
        }
        return false;
    }

    bool inArea(int i, int j, int m, int n)
    {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
};

int main()
{
    return 0;
}