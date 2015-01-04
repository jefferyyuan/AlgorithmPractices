// it should be called 杨辉三角 instead of Pascal's Triangle
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows <= 0) return result;
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        result.add(row1);
        for(int i = 1;i < numRows;i ++)
        {
            List<Integer> tempRow = new ArrayList<Integer>();
            for(int j = 0;j <= i; j ++)
            {
                if(j == 0 || j == i) 
                    tempRow.add(1);
                else
                    tempRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            result.add(tempRow);
        }
        return result;
    }
}