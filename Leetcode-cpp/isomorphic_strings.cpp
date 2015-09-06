class Solution {
public:
    bool isIsomorphic(string s, string t) {
        unordered_map<char, char> record1, record2;
        for (int i = 0; i < s.length(); ++i) {
            if (record1.find(s[i]) == record1.end() && record2.find(t[i]) == record2.end()) {
                record1[s[i]] = t[i];
                record2[t[i]] = s[i];
            } else if (record1.find(s[i]) == record1.end() || record2.find(t[i]) == record2.end()) {
                return false;
            } else if (record1[s[i]] != t[i] || record2[t[i]] != s[i]) {
                return false;
            }
        }
        return true;
    }
};