public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = 0;
        if(m > 0) n = matrix[0].length;
        return searchMatrixPart(matrix, 0 , m * n - 1, target);
    }
    
    public boolean searchMatrixPart(int[][] matrix,int start,int end,int target)
    {
        int m = matrix.length;
        int n = 0;
        if(m > 0) n = matrix[0].length;
        
        if(start > end) return false;
        if(start == end) return matrix[start / n][start % n] == target;
        
        int mid = (start + end) / 2;
        int midValue = matrix[mid / n][mid % n];
        if(midValue == target) return true;
        else if(midValue < target) return searchMatrixPart(matrix, mid + 1, end, target);
        else return searchMatrixPart(matrix, start, mid - 1, target);
    }
}