public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int result = -1;
        for(int i = 0;i < haystack.length() - needle.length() + 1;i ++)
        {
            boolean isValid = true;
            for(int j = 0;j < needle.length();j ++)
            {
                if(Character.compare(haystack.charAt(i + j), needle.charAt(j)) != 0)
                {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
            {
                result = i;
                break;
            }
        }
        return result;
    }
}

//  2nd KMP
public class Solution {
    
   //  kmp implementation
    
    //  get next array
    int[] getNext(String source){
        int[] next = new int[source.length() + 1];
        next[0] = -1;
        for(int i = 1; i <= source.length(); i++){
            char c = source.charAt(i - 1);
            int index = next[i - 1];
            while(index >= 0 && c != source.charAt(index))
                index = next[index];
            next[i] = index + 1;
        }
        return next;
    }
    
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        int searchIndex = 0;
        int[] next = getNext(needle);
        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(searchIndex)){
                searchIndex++;
                if(searchIndex == needle.length())
                    return i - needle.length() + 1;
            } else {
                while(searchIndex >= 0 && needle.charAt(searchIndex) != haystack.charAt(i))
                    searchIndex = next[searchIndex];
                searchIndex++;
            }
        }
        return -1;
    }
}