class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<char, int> record;
        for (auto c : s) ++record[c];
        for (auto c : t) --record[c];
        for (auto value_pair : record) {
            if (value_pair.second != 0) return false;
        }
        return true;
    }
};