class Solution {
public:
    string convert(string s, int numRows) {
        if (s.length() < 2 || numRows < 2) return string(s);
        string result = "";
        int iteration = 2 * numRows - 2;
        int count = 0;
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j <= s.length() / iteration + 1; ++j) {
                int temp_index;
                if (i != 0 && i != numRows - 1) {
                    temp_index = j * iteration - i;
                    if (temp_index < s.length()) result += s[temp_index];
                }
                temp_index = j * iteration + i;
                if (temp_index < s.length()) result += s[temp_index];
            }
        }
        return result;
    }
};