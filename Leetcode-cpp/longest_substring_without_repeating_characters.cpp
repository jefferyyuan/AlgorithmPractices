class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> record;
        int result = 0;
        int current_start = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (record.find(s[i]) != record.end() && record[s[i]] >= current_start) {
                result = max(result, i - current_start);
                current_start = record[s[i]] + 1;
            }
            record[s[i]] = i;
        }
        result = max(result, (int)s.length() - current_start);
        return result;
    }
};