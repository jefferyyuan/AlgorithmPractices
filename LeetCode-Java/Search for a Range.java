public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = searchStart(A, 0, A.length - 1, target);
        result[1] = searchEnd(A, 0, A.length - 1, target);
        return result;
    }
    
    public int searchStart(int[] A, int start, int end, int target)
    {
        if(A[start] > target || A[end] < target) return -1;
        else if(start == end) return start;
        else
        {
            int mid = (start + end) / 2;
            if(A[mid] > target) return searchStart(A, start, mid - 1, target);
            else if(A[mid] < target) return searchStart(A, mid + 1, end, target);
            else
            {
                if(mid == start || A[mid - 1] < target)
                    return mid;
                else
                    return searchStart(A, start, mid - 1, target);
            }
        }
    }
    public int searchEnd(int[] A, int start, int end, int target)
    {
        if(A[start] > target || A[end] < target) return -1;
        else if(start == end) return start;
        else
        {
            int mid = (start + end) / 2;
            if(A[mid] > target) return searchEnd(A, start, mid - 1, target);
            else if(A[mid] < target) return searchEnd(A, mid + 1, end, target);
            else
            {
                if(mid == end || A[mid + 1] > target)
                    return mid;
                else
                    return searchEnd(A, mid + 1, end, target);
            }
        }
    }
}