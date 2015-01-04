public class Solution {
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