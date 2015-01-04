public class Solution {
    public List<String[]> solveNQueens(int n) {
        char[][] record = new char[n][n];
        for(int i = 0;i < n;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                record[i][j] = '.';
            }
        }
        List<String[]> result = new ArrayList<String[]>();
        solveNQueensPart(record,result,0,n);
        return result;
    }
    
    void solveNQueensPart(char[][] record,List<String[]> result, int row, int n)
    {
        for(int col = 0; col < n;col ++)
        {
            if(isLegal(record,row,col))
            {
                record[row][col] = 'Q';
                if(row == n - 1)
                {
                    String[] tempResult = new String[n];
                    for(int i = 0;i < n;i ++)
                    {
                        tempResult[i] = String.valueOf(record[i]);
                    }
                    result.add(tempResult);
                }
                else
                {
                    solveNQueensPart(record,result,row + 1,n);
                }
                record[row][col] = '.';
            }
        }
        return;
    }
    
    boolean isLegal(char[][] record,int row,int column)
    {
        int n = record.length;
        for(int i = 0;i < n;i ++)
        {
            if(record[row][i] == 'Q' || record[i][column] == 'Q')
                return false;
        }
        int i = 1;
        while(row - i >= 0 && column - i >= 0)
        {
            if(record[row - i][column - i] == 'Q')
                return false;
            i ++;
        }
        i = 1;
        while(row + i < n && column + i < n)
        {
            if(record[row + i][column + i] == 'Q')
                return false;
            i ++;
        }
        i = 1;
        while(row - i >= 0 && column + i < n)
        {
            if(record[row - i][column + i] == 'Q')
                return false;
            i ++;
        }
        i = 1;
        while(row + i < n && column - i >= 0)
        {
            if(record[row + i][column - i] == 'Q')
                return false;
            i ++;
        }
        return true;
    }
}