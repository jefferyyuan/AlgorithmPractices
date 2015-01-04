public class Solution {
    public int maxProduct(int[] A) {
        int negativeProduct = 0;
        boolean isSetNegative = false;
        boolean isPositive = true;
        int result = A[0];
        int product = 1;
        for(int i = 0;i < A.length;i ++)
        {
            if(A[i] < 0)
            {
                product *= (-A[i]);
                isPositive = !isPositive;
                if(!isSetNegative)
                {
                    isSetNegative = true;
                    negativeProduct = product;
                }
                else
                {
                    if(isPositive)
                        result = Math.max(result, product);
                    else
                        result = Math.max(result, product / negativeProduct);
                }
            }
            else if(A[i] > 0)
            {
                product *= A[i];
                if(isPositive)
                    result = Math.max(result, product);
                else
                    result = Math.max(result, product / negativeProduct);
            }
            else
            {
                result = Math.max(result, 0);
                isSetNegative = false;
                isPositive = true;
                product = 1;
            }
        }
        return result;
    }
}