// dfs
public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = 0;
        if(m > 0) n = board[0].length;
        int[][] record = new int[m][n];
        for(int i = 0;i < m;i ++)
            for(int j = 0;j < n;j ++)
                record[i][j] = -1;
        boolean result = false;
        for(int i = 0;i < m;i ++)
        {
            for(int j = 0;j < n;j ++)
            {
                if(findPart(board,word,record,i,j,0))
                    return true;
            }
        }
        return false;
    }
    boolean findPart(char[][] board, String word, int[][] record,int x, int y, int index)
    {
        int m = board.length;
        int n = 0;
        if(m > 0) n = board[0].length;
        if(x >= m || x < 0 || y >= n || y < 0) return false;
        if(record[x][y] >= 0) return false;
        if(board[x][y] != word.charAt(index)) return false;
        if(index == word.length() - 1) return true;
        record[x][y] = index + 1;
        boolean result = findPart(board,word,record,x - 1, y, index + 1)
                        || findPart(board,word,record,x + 1, y, index + 1)
                        || findPart(board,word,record,x, y + 1, index + 1)
                        ||  findPart(board,word,record,x, y - 1, index + 1);
        record[x][y] = -1;
        return result;
    }
}
