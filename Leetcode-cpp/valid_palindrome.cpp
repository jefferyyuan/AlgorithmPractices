class Solution {
public:
    bool isPalindrome(string s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < end && !isalnum(s[start])) start++;
            while (start < end && !isalnum(s[end])) end--;
            char l = s[start];
            if (l >= 'A' && l <= 'Z') l -= ('A' - 'a');
            char r = s[end];
            if (r >= 'A' && r <= 'Z') r -= ('A' - 'a');
            if (l != r) return false;
            start++;
            end--;
        }
        return true;
    }
};