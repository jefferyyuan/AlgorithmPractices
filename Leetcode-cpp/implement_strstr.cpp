class Solution {
public:
    int strStr(string haystack, string needle) {
        int i, j;
        if (needle.length() > haystack.length()) return -1;
        if (haystack.length() == 0) return 0;
        for (i = 0; i <= haystack.length() - needle.length(); ++i) {
            for (j = 0; j < needle.length(); ++j) {
                if (needle[j] != haystack[i + j]) break;
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }
};