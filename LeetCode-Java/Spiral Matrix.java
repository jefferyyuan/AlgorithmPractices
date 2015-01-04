public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int[] addX = { 0, 1, 0, -1};
        int[] addY = { 1, 0, -1, 0};
        int mod = 4;
        int start = 0;
        int x = 0,y = 0;
        int m = matrix.length;
        int n = 0;
        if(m > 0) n = matrix[0].length;
        int[] upbound = {n , m};
        int count = 0;
        for(int i = 0;i < m * n;i ++)
        {
            result.add(matrix[x][y]);
            count ++;
            if( count ==  upbound[start % 2] )
            {
                int tempIndex = (start + 1) % 2;
                upbound[tempIndex] --;
                start = (start + 1) % mod;
                count = 0;
            }
            x += addX[start];
            y += addY[start];
        }
        return result;
    }
}