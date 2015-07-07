class Solution {
public:
    int reverse(int x) 
    {
        bool isPositive = x > 0;
        if(!isPositive) x = -x;
        int result = 0;
        while(x != 0)
        {
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        return isPositive ? result : -result;
    }
};
