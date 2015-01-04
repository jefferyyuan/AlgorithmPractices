public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null) return 0;
        int val1 = 0;
        String next1 = null;
        if(version1 == null || version1.length() == 0)
            val1 = 0;
        else
        {
            int index1 = version1.indexOf('.');
            if(index1 < 0)
                index1 = version1.length();
            else
            {
                if(index1 + 1 < version1.length())
                    next1 = version1.substring(index1 + 1);
            }
            val1 = Integer.valueOf(version1.substring(0,index1));
        }
        
        int val2 = 0;
        String next2 = null;
        if(version2 == null || version2.length() == 0)
            val2 = 0;
        else
        {
            int index2 = version2.indexOf('.');
            if(index2 < 0)
                index2 = version2.length();
            else
            {
                if(index2 + 1 < version2.length())
                    next2 = version2.substring(index2 + 1);
            }
            val2 = Integer.valueOf(version2.substring(0,index2));
        }
        
        if(val1 < val2) return -1;
        else if(val1 > val2) return 1;
        else return compareVersion(next1, next2);
    }
}