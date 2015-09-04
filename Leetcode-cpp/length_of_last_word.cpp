class Solution {
public:
    int lengthOfLastWord(string s) {
        int last_index = s.length() - 1;
        while (last_index >= 0 && s[last_index] == ' ') last_index--;
        int first_index = last_index;
        while (first_index >= 0 && s[first_index] != ' ') first_index--;
        return last_index - first_index;
    }
};