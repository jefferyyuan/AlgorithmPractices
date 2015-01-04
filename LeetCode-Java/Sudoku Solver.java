public class Solution {
    public void solveSudoku(char[][] board) {
        List<HashSet<Integer>> rowRecord = new ArrayList<HashSet<Integer>> ();
        List<HashSet<Integer>> columnRecord = new ArrayList<HashSet<Integer>> ();
        List<HashSet<Integer>> miniRecord = new ArrayList<HashSet<Integer>> ();
        for(int i = 0;i < 9;i ++)
        {
            rowRecord.add(new HashSet<Integer>());
            columnRecord.add(new HashSet<Integer>());
            miniRecord.add(new HashSet<Integer>());
        }
        for(int i = 0;i < 9;i ++)
        {
            for(int j = 0;j < 9;j ++)
            {
                char c = board[i][j];
                if(c == '.') continue;
                int val = c - '0';
                rowRecord.get(i).add(val);
                columnRecord.get(j).add(val);
                miniRecord.get((i / 3) * 3 + (j / 3)).add(val);
            }
        }
        solveSudoku(board, 0, rowRecord, columnRecord, miniRecord);
        
    }
    
    boolean solveSudoku(char[][] board, 
                        int index, 
                        List<HashSet<Integer>> rowRecord, 
                        List<HashSet<Integer>> columnRecord, 
                        List<HashSet<Integer>> miniRecord )
    {
        if(index >= 9 * 9)
            return true;
        if(board[index / 9][index % 9] != '.')
            return solveSudoku(board, index + 1, rowRecord, columnRecord, miniRecord);
        int row = index / 9;
        int column = index % 9;
        int mini = (row / 3) * 3 + (column / 3);
        boolean isValid = false;
        for(int i = 1;i <= 9;i ++)
        {
            if((!rowRecord.get(row).contains(i)) 
                && (!columnRecord.get(column).contains(i)) 
                && (!miniRecord.get(mini).contains(i)) )
            {
                board[row][column] = (char)((int)'0' + i);
                rowRecord.get(row).add(i);
                columnRecord.get(column).add(i);
                miniRecord.get(mini).add(i);
                if(solveSudoku(board, index + 1, rowRecord, columnRecord, miniRecord))
                {
                    return true;
                }
                else
                {
                    board[row][column] = '.';
                    rowRecord.get(row).remove(i);
                    columnRecord.get(column).remove(i);
                    miniRecord.get(mini).remove(i);
                }
            }
        }
        return isValid;
    }
}