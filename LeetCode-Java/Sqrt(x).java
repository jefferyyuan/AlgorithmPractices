public class Solution {
    public int sqrt(int x) {
        if(x == 0) return x;
        double result = 1;
        for(int i = 1;i <= 100;i ++)
        {
            result = (result + x / result) / 2;
        }
        int test = (int) result;
        while(test * test >= 0 && test * test <= x) 
            test ++;
        return test - 1;
    }
}