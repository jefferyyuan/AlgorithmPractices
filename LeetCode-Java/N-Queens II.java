public class Solution {
    public int totalNQueens(int n) 
    {
        int[][] board = new int[n][n];
        for(int i = 0;i < n;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                board[i][j] = -1;
            }
        }
        return searchBoard(n,0,board);
        
    }
    public int searchBoard(int n,int row,int[][] board)
    {
        int result = 0;
        for(int column = 0;column < n;column ++)
        {
            if(board[row][column] < 0)
            {
                if(row == n - 1)
                {
                    result ++;
                }
                else
                {
                    board = disable(n,board,row,column);
                    result += searchBoard(n,row + 1,board);
                    board = recover(n,board,row,column);
                }
            }
        }
        return result;
    }
    int[][] disable(int n,int[][] board,int row,int column)
    {
        //disable row
        for(int i = 0;i < n;i ++)
        {
            if(board[row][i] < 0) board[row][i] = row;
        }
        //disable column
        for(int i = 0;i < n;i ++)
        {
            if(board[i][column] < 0) board[i][column] = row;
        }
        //disable /
        int x = row,y = column;
        while(true)
        {
            x ++;
            y --;
            if( x >= n || y < 0) break;
            if(board[x][y] < 0) board[x][y] = row;
        }
        //diable \
         x = row;
         y = column;
        while(true)
        {
            x ++;
            y ++;
            if( x >= n || y >= n) break;
            if(board[x][y] < 0) board[x][y] = row;
        }
        
        return board;
    }
    int[][] recover(int n,int[][] board,int row,int column)
    {
        //recover row
        for(int i = 0;i < n;i ++)
        {
            if(board[row][i] == row) board[row][i] = -1;
        }
        //recover column
        for(int i = 0;i < n;i ++)
        {
            if(board[i][column] == row) board[i][column] = -1;
        }
        //recover /
        int x = row,y = column;
        while(true)
        {
            x ++;
            y --;
            if( x >= n || y < 0) break;
            if(board[x][y] == row) board[x][y] = -1;
        }
        //recover \
        x = row;
        y = column;
        while(true)
        {
            x ++;
            y ++;
            if( x >= n || y >= n) break;
            if(board[x][y] == row) board[x][y] = -1;
        }
        
        return board;
    }
}