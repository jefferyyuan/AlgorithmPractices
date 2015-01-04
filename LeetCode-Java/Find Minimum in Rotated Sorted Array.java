public class Solution {
    public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        if(num[start] < num[end]) return num[start];
        while(end - start > 1)
        {
            int mid = (start + end) / 2;
            if(num[mid] > num[start]) start = mid;
            else end = mid;
        }
        return num[end];
    }
}