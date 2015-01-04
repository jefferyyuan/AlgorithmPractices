public class Solution {
    public int findMin(int[] num) {
        return findMinPart(num, 0, num.length - 1);
    }
    
    int findMinPart(int[] num, int start, int end)
    {
        if(start == end) return num[start];
        if(num[start] < num[end]) return num[start];
        int mid = (start + end) / 2;
        if(num[mid] > num[start]) return findMinPart(num,mid + 1, end);
        else if(num[mid] < num[start]) return findMinPart(num,start, mid);
        else
            return Math.min(findMinPart(num,start,mid),findMinPart(num,mid + 1, end));
    }
}