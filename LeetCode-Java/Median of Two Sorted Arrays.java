public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int count = m + n;
        if(count % 2 == 1)
        {
            return (double)findKthElement(A, 0, m - 1, B, 0, n - 1, count / 2 + 1);
        }
        else
        {
            double result = (double)findKthElement(A, 0, m - 1, B, 0, n - 1, count / 2);
            result += (double)findKthElement(A, 0, m - 1, B, 0, n - 1, count / 2 + 1);
            return result / 2;
        }
    }

    int binarySearch(int[] A, int start, int end, int val)
    {
        if(start == end)
        {
            if(A[start] < val) 
                return start + 1;
            else
                return start;
        }
        int mid = (start + end) / 2;
        if(A[mid] == val)
            return mid;
        else if(A[mid] > val)
            return binarySearch(A, start, mid, val);
        else
            return binarySearch(A, mid + 1, end, val);
    }
    
    int findKthElement(int[] A, int startA, int endA, int[] B, int startB, int endB, int K)
    {
        if(startA > endA) return B[startB + K - 1];
        if(startB > endB) return A[startA + K - 1];
        if(endB - startB > endA - startA)
            return findKthElement(B,startB,endB,A,startA,endA,K);
        int indexA = startA + (K - 1) / 2;
        int indexB = binarySearch(B,startB,endB,A[indexA]);
        int count = (indexA - startA) + (indexB - startB);
        if(count == K - 1) return A[indexA];
        if(count < K - 1)
            return findKthElement(A, indexA + 1,endA,B,indexB,endB, K - count - 1);
        else
            return findKthElement(A, startA, indexA - 1, B, startB, indexB - 1, K);
    }
}