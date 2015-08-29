class Solution {
public:
    void reverseWords(string &s) {
        int startIndex = 0;
        for (int i = 0; i <= s.length(); ++i) {
            if (i == s.length() || s[i] == ' ') {
                reverse(s.begin() + startIndex, s.begin() + i);
                startIndex = i + 1;
            }
        }
        reverse(s.begin(), s.end());
    }
};