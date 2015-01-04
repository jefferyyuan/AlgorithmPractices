public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = 0;
        if(m > 0) n = board[0].length;
        Stack<Integer> xStack = new Stack<Integer>();
        Stack<Integer> yStack = new Stack<Integer>();
        for(int i = 0;i < n;i ++)
        {
            xStack.push(0);
            yStack.push(i);
            
            xStack.push(m - 1);
            yStack.push(i);
        }
        for(int i = 0;i < m;i ++)
        {
            xStack.push(i);
            yStack.push(0);
            
            xStack.push(i);
            yStack.push(n - 1);
        }
        
        while(!xStack.empty() && !yStack.empty())
        {
            int x = xStack.pop();
            int y = yStack.pop();
            if(x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if(board[x][y] == 'X' || board[x][y] == 't')
                continue;
            board[x][y] = 't';
            
            xStack.push(x - 1);
            yStack.push(y);
            xStack.push(x + 1);
            yStack.push(y);
            xStack.push(x);
            yStack.push(y - 1);
            xStack.push(x);
            yStack.push(y + 1);
        }
        for(int i = 0;i < m;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                if(board[i][j] == 't')
                    board[i][j] = 'O';
                else
                    board[i][j] = 'X';
            }
        }
        return;
    }
}