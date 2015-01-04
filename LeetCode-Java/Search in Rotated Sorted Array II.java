public class Solution {
    public boolean search(int[] A, int target) {
        return !(searchPart(A, 0, A.length - 1, target) == -1);
    }
    int searchPart(int[] A,int start,int end,int target)
    {
        if(start > end) return -1;
        if(end - start <= 1)
        {
            // this will probably add one operation when end == start
            // however, code like this will look more elegant 
            if(A[start] == target)
                return start;
            else if(A[end] == target)
                return end;
            else
                return -1;
        }
        if(A[start] < A[end])
        {
            int mid = (start + end) / 2;
            if(A[mid] == target) 
                return mid;
            else if(A[mid] < target)
                return searchPart(A,mid + 1,end,target);
            else
                return searchPart(A,start, mid -1,target);
        }
        else
        {
            int mid = (start + end) / 2;
            if(A[mid] == target) 
                return mid;
            if(A[mid] > A[start])
            {
                if(A[mid] > target && A[start] <= target)
                    return searchPart(A,start,mid - 1,target);
                else
                    return searchPart(A, mid + 1, end,target);
            }
            else if(A[mid] < A[start])
            {
                if(A[mid] < target && A[end] >= target)
                    return searchPart(A, mid + 1, end,target);
                else
                    return searchPart(A,start,mid - 1,target);
            }
            else 
            // when A[mid] == target, we have to search both sides
            // this will make the time complexity to O(n) in the worst case
            // for example, when the array contains the same element in all positions
            {
                int value = searchPart(A,start,mid - 1,target);
                if(value != -1)
                    return value;
                else
                    return searchPart(A, mid + 1, end,target);
            }
        }
    }
}