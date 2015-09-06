class Solution {
public:
    string countAndSay(int n) {
        string start = "1";
        for (int i = 2; i <= n; ++i) {
            start = next_string(start);
        }
        return start;
    }
    string next_string(string val) {
        string result = "";
        char current_val = val[0];
        int count = 0;
        for (int i = 0; i <= val.length(); ++i) {
            if (i == val.length()) {
                if (count > 0) result += to_string(count) + to_string((int)(current_val - '0'));
            } else if (current_val == val[i]) {
                count++;
            } else {
                if (count > 0) result += to_string(count) + to_string((int)(current_val - '0'));
                current_val = val[i];
                count = 1;
            }
        }
        return result;
    }
};