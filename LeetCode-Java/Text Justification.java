public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if(words == null || words.length <= 0) return result;
        int index = 0;
        while(index < words.length)
        {
            int endIndex = index;
            int count = words[endIndex].length();
            int clearCount = words[endIndex].length();
            endIndex ++;
            while(endIndex < words.length && count + words[endIndex].length() + 1 <= L)
            {
                count += words[endIndex].length() + 1;
                clearCount += words[endIndex].length();
                endIndex ++;
            }
            if(endIndex == index + 1 || endIndex == words.length) // last line or 1 word, left assign
            {
                char[] tempResult = new char[L];
                int tempIndex = 0;
                for(int i = index;i < endIndex;i ++)
                {
                    if(i > index)
                        tempResult[tempIndex ++] = ' ';
                    for(int j = 0;j < words[i].length();j ++)
                        tempResult[tempIndex ++] = words[i].charAt(j);
                }
                while(tempIndex < L)
                    tempResult[tempIndex ++] = ' ';
                result.add(String.valueOf(tempResult));
            }
            else
            {
                int spaceCount = L - clearCount;
                char[] tempResult = new char[L];
                int tempIndex = 0;
                for(int i = index;i < endIndex;i ++)
                {
                    if(i > index)
                    {
                        int tempSpace = spaceCount / (endIndex - i);
                        if(spaceCount % (endIndex - i) > 0) tempSpace ++;
                        while(tempSpace > 0)
                        {
                            tempResult[tempIndex ++] = ' ';
                            tempSpace --;
                            spaceCount --;
                        }
                    }
                    for(int j = 0;j < words[i].length();j ++)
                        tempResult[tempIndex ++] = words[i].charAt(j);
                }
                result.add(String.valueOf(tempResult));
            }
            index = endIndex;
        }
        return result;
    }
}