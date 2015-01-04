public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int count = 9;
        HashMap<Character,Boolean> rowRecord = new HashMap<Character,Boolean>();
        HashMap<Character,Boolean> columnRecord = new HashMap<Character,Boolean>();
        // check every row and column
        for(int i = 0;i < count;i ++)
        {
            rowRecord.clear();
            columnRecord.clear();
            boolean isValid = true;
            for(int j = 0;j < count;j ++)
            {
                if(board[i][j] != '.')
                {
                    if(rowRecord.containsKey(board[i][j]))
                    {
                        isValid = false;
                        break;
                    }
                    else
                    {
                        rowRecord.put(board[i][j],true);
                    }
                }
                if(board[j][i] != '.')
                {
                    if(columnRecord.containsKey(board[j][i]))
                    {
                        isValid = false;
                        break;
                    }
                    else
                    {
                        columnRecord.put(board[j][i],true);
                    }
                }
            }
            if(!isValid) return false;
        }
        // check every square
        HashMap<Character,Boolean> squareRecord = rowRecord;
        for(int x = 0;x < count; x += 3)
        {
            for(int y = 0;y < count;y += 3)
            {
                squareRecord.clear();
                boolean isValid = true;
                //(x,y) is the leftmost and upmost cell of each square
                for(int i = 0;i < 3;i ++)
                {
                    for(int j = 0;j < 3;j ++)
                    {
                        if(board[x + i][y + j] != '.')
                        {
                            if(rowRecord.containsKey(board[x + i][y + j]))
                            {
                                isValid = false;
                                break;
                            }
                            else
                            {
                                rowRecord.put(board[x + i][y + j],true);
                            }
                        }
                    }
                }
                if(!isValid) return false;
            }
        }
        return true;
    }
}