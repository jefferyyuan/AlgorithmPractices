class Solution {
public:
    string multiply(string num1, string num2) {
        vector<int> record(num1.length() + num2.length(), 0);
        for (int i = 0; i < num1.length(); ++i) {
            for (int j = 0; j < num2.length(); ++j) {
                record[i + j] += ((int)(num1[num1.length() - 1 - i] - '0')) * ((int)(num2[num2.length() - 1 - j] - '0'));
            }
        }
        for (int i = 0; i < record.size() - 1; ++i) {
            record[i + 1] += record[i] / 10;
            record[i] %= 10;
        }
        string result = "";
        while (record.size() > 1 && record.back() == 0) record.pop_back();
        for (int i = record.size() - 1; i >= 0; --i) {
            result += to_string(record[i]);
        }
        return result;
    }
};