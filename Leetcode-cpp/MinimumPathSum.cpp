class Solution {
public:
    int minPathSum(vector<vector<int> > &grid) {
        int m = grid.size();
        if(m <= 0) return 0;
        int n = grid[0].size();
        vector<int> record = grid[0];
        for(int i = 1;i < n;i ++) record[i] += record[i - 1];
        for(int i = 1;i < m;i ++)
        {
            record[0] += grid[i][0];
            for(int j = 1;j < n;j ++)
            {
                record[j] = grid[i][j] + (record[j - 1] < record[j] ? record[j - 1] : record[j]); 
            }
        }
        return record[n - 1];
    }
};
