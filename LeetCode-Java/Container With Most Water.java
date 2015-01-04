public class Solution {
    public int maxArea(int[] height) {
        int max = -1;
        int start = 0,end = height.length - 1;
        while(start < end)
        {
            if(height[start] < height[end])
            {
                int tempVolume = (end - start) * height[start];
                max = Math.max(max, tempVolume);
                start ++;
            }
            else
            {
                int tempVolume = (end - start) * height[end];
                max = Math.max(max, tempVolume);
                end --;
            }
        }
        return max;
    }
}