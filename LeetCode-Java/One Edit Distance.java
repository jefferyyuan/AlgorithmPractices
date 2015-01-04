public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if(Math.abs(length1 - length2) > 1)
            return false;
        int diffLimit = 1;
        int diffCount = 0;
        int index1 = 0, index2 = 0;
        while(index1 < length1 || index2 < length2){
            if(index1 >= length1 || index2 >= length2){
                diffCount ++;
                break;
            }
            else if(s.charAt(index1) == t.charAt(index2)){
                index1 ++;
                index2 ++;
            }
            else{
                diffCount ++;
                if(length1 < length2)
                    index2 ++;
                else if(length2 < length1)
                    index1 ++;
                else{
                    index1 ++;
                    index2 ++;
                }
            }
            if(diffCount > diffLimit)
                return false;
        }
        return diffCount == diffLimit;
    }
}