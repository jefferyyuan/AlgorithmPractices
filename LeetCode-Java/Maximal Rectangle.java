public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = 0;
        if(m > 0)
            n = matrix[0].length;
        int[][] maxHeightRecord = new int[m][n];
        for(int j = 0;j < n;j ++)
        {
            int height = 0;
            for(int i = 0;i < m;i ++)
            {
                if(matrix[i][j] == '1')
                {
                    height ++;
                    maxHeightRecord[i][j] = height;
                }
                else
                {
                    height = 0;
                    maxHeightRecord[i][j] = height;
                }
            }
        }
        
        int result = 0;
        for(int i = 0;i < m;i ++)
        {
            int tempResult = largestRectangleArea(maxHeightRecord[i]);
            result = Math.max(result, tempResult);
        }
        return result;
    }
    
    public int largestRectangleArea(int[] height) {
        int result = 0;
        Stack<Integer> record = new Stack<Integer>();
        for(int i = 0;i < height.length;i ++)
        {
            if(record.empty() || height[i] > height[record.peek()])
                record.push(i);
            else if(height[i] == height[record.peek()])
                continue;
            else if(height[i] < height[record.peek()])
            {
                int newIndex = i;
                while(!record.empty())
                {
                    int index = record.peek();
                    if(height[index] < height[i])
                    {
                        height[newIndex] = height[i];
                        record.push(newIndex);
                        break;
                    }
                    else if(height[index] > height[i])
                    {
                        int val = height[index] * (i - index);
                        result = Math.max(result, val);
                        record.pop();
                        newIndex = index;
                    }
                    else
                    {
                        break;
                    }
                }
                if(record.empty())
                {
                    height[newIndex] = height[i];
                    record.push(newIndex);
                }
            }
        }
        int index1 = height.length;
        while(!record.empty())
        {
            int index2 = record.pop();
            result = Math.max(result, height[index2] * (index1 - index2));
        }
        return result;
    }
}