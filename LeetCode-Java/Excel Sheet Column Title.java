public class Solution {
    public String convertToTitle(int n) {
        int mod = 26;
        String result = "";
        while(n > 0)
        {
            n --;
            int val = n % mod;
            char c = (char)((int)'A' + val);
            result = String.valueOf(c) + result;
            n = n / mod;
        }
        return result;
    }
}