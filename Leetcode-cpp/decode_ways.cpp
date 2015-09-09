class Solution {
public:
    int numDecodings(string s) {
        if (s.length() == 0) return 0;
        vector<int> record(s.length(), 0);
        for (int i = s.length() - 1; i >= 0; --i) {
            int v1 = 0, v2 = 0;
            if (s[i] != '0') v1 = 1;
            if (i != s.length() - 1) v1 *= record[i + 1];
            if (i < s.length() - 1) {
                if (s[i] == '1' || (s[i] == '2' && s[i + 1] <= '6')) v2 = 1;
                if (i < s.length() - 2) v2 *= record[i + 2];
            }
            record[i] = v1 + v2;
        }
        return record[0];
    }
};