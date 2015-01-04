public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for(int i = 0;i < num.length - 2;i ++)
        {
            if(i > 0 && num[i] == num[i - 1])
            {
                continue;
            }
            int startIndex = i + 1, endIndex = num.length - 1;
            while(startIndex < endIndex)
            {
                if(num[i] + num[startIndex] + num[endIndex] == 0)
                {
                    List<Integer> tempResult = new ArrayList<Integer>();
                    tempResult.add(num[i]);
                    tempResult.add(num[startIndex]);
                    tempResult.add(num[endIndex]);
                    result.add(tempResult);
                    startIndex ++;
                    while(startIndex  < endIndex && num[startIndex] == num[startIndex - 1])
                        startIndex ++;
                    endIndex --;
                    while(endIndex > startIndex && num[endIndex] == num[endIndex + 1])
                        endIndex --;
                }
                else if(num[i] + num[startIndex] + num[endIndex] < 0)
                    startIndex ++;
                else
                    endIndex --;
            }
        }
        return result;
    }
}