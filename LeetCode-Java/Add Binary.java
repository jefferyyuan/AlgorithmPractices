public class Solution {
    public String addBinary(String a, String b) {
        String stringResult = "";
        boolean isUp = false;
        int length = Math.max(a.length(),b.length());
        char[] record = new char[length];
        int aIndex = a.length() - 1, bIndex = b.length() - 1;
        int index = length - 1;
        while(aIndex >= 0 || bIndex >= 0)
        {
            int tempA = 0, tempB = 0;
            if(bIndex >= 0)
                tempB = Character.compare(b.charAt(bIndex),'0');
            if(aIndex >= 0)
                tempA = Character.compare(a.charAt(aIndex),'0');
            
            int result = tempA + tempB;
            if(isUp) result ++;
            if(result > 1) isUp = true;
            else isUp = false;
            result = result % 2;
            
            if(result == 0) record[index] = '0';
            else record[index] = '1';
            aIndex --;
            bIndex --;
            index --;
        }
        if(isUp) 
            stringResult += "1";
        stringResult += String.valueOf(record);
        return stringResult;
    }
    
}