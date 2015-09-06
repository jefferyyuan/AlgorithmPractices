class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string result = "";
        if (strs.size() == 0) return result;
        int index = 0;
        while (true) {
            bool valid = true;
            for (int i = 0; i < strs.size(); ++i) {
                if (strs[i].length() == index || strs[i][index] != strs[0][index]) {
                    valid = false;
                    break;
                }
            }
            if (!valid) break;
            result += strs[0][index++];
        }
        return result;
    }
};