class Solution {
public:
    string addBinary(string a, string b) {
        string result = "";
        int extra = 0;
        int index_a = a.length() - 1;
        int index_b = b.length() - 1;
        while (!(index_a < 0 && index_b < 0 && extra == 0)) {
            if (index_a >= 0) extra += a[index_a--] - '0';
            if (index_b >= 0) extra += b[index_b--] - '0';
            result = to_string(extra & 1) + result;
            extra = extra >> 1;
        }
        return result;
    }
};