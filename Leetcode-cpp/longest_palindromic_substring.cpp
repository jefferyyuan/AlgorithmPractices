class Solution {
public:
    string longestPalindrome(string s) {
        if (s.length() == 0) return "";
        int max_length = 1, max_start = 0;
        for (int i = 0; i < s.length(); ++i) {
            int start = i, end = i;
            while (start >= 0 && end < s.length() && s[start] == s[end]) {
                --start;
                ++end;
            }
            if (end - start - 1 > max_length) {
                max_length = end - start - 1;
                max_start = start + 1;
            }
            start = i, end = i + 1;
            while (start >= 0 && end < s.length() && s[start] == s[end]) {
                --start;
                ++end;
            }
            if (end - start - 1 > max_length) {
                max_length = end - start - 1;
                max_start = start + 1;
            }
        }
        return s.substr(max_start, max_length);
    }
};