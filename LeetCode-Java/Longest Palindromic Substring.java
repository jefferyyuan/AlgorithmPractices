//  1st : O(n^2) space
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() <= 1) return s;
        int m = s.length();
        boolean[][] record = new boolean[m][m];
        int maxStart = 0, maxEnd = 0;
        for(int i = 0;i < m;i ++)
        {
            for(int j = 0;j + i < m;j ++)
            {
                if(s.charAt(j) == s.charAt(j + i))
                {
                    if( j + i - 1 <= j + 1)
                        record[j][j + i] = true;
                    else
                        record[j][j + i] = record[j + 1][j + i - 1];
                }
                else
                {
                    record[j][j + i] = false;
                }
                if(record[j][j + i])
                {
                    maxStart = j;
                    maxEnd = j + i;
                }
                hasChange = hasChange || record[j][j + i];
                
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }  
}

//  2nd : O(1) space
public class Solution {
    public String longestPalindrome(String s) {
        if(s == null)
            return null;
        else if(s.length() <= 1)
            return s;
        int maxLength = 1;
        int startIndex = 0, endIndex = 0;
        for(int i = 0; i <= s.length() - 1; i++){
            // i is the center
            int leftIndex = i, rightIndex = i;
            while(leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            if(rightIndex - leftIndex - 1 > maxLength){
                maxLength = rightIndex - leftIndex - 1;
                startIndex = leftIndex + 1;
                endIndex = rightIndex - 1;
            }
            // i is the left center
            leftIndex = i;
            rightIndex = i + 1;
            while(leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)){
                leftIndex--;
                rightIndex++;
            }
            if(rightIndex - leftIndex - 1 > maxLength){
                maxLength = rightIndex - leftIndex - 1;
                startIndex = leftIndex + 1;
                endIndex = rightIndex - 1;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }
}