public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int result = 0;
        int index = 0;
        int lastIndex = 0;
        int value = 1;
        boolean isUp = true;
        index ++;
        result += value;
        while(index < ratings.length)
        {
            if(isUp)
            {
                if(ratings[index] > ratings[index - 1])
                {
                    value ++;
                }
                else if(ratings[index] < ratings[index - 1])
                {
                    lastIndex = index - 1;
                    value --;
                    isUp = false;
                }
                else
                {
                    value = 1;
                    isUp = true;
                }
                result += value;
            }
            else
            {
                if(ratings[index] < ratings[index - 1])
                {
                    value --;
                }
                else if(ratings[index] >= ratings[index - 1])
                {
                    if(value > 1)
                    {
                        result -= (index - lastIndex - 1) * (value - 1);
                    }
                    else if(value < 1)
                    {
                        result += (index - lastIndex) * (1 - value);
                    }
                    
                    if(ratings[index] > ratings[index - 1])
                    {
                        value = 2;
                        isUp = true;
                    }
                    else
                    {
                        value = 1;
                        isUp = true;
                    }
                }
                result += value;
            }
            index ++;
        }
        if(!isUp)
        {
            if(value > 1)
            {
                 result -= (index - 1 - lastIndex) * (value - 1);
            }
            else if(value < 1)
            {
                result += (index - 1 - lastIndex + 1) * (1 - value);
            }
        }
        return result;
    }
}