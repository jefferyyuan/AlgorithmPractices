class Solution {
public:
    string getPermutation(int n, int k) {
        vector<int> ref = {1};
        int current = 1;
        for (int i = 1; i <= n; ++i) {
            ref.push_back(i * ref[i - 1]);
        }
        string result = "";
        vector<int> candidates;
        for (int i = 1; i <= n; ++i) candidates.push_back(i);
        for (int i = 1; i <= n; ++i) {
            int index = (k - 1) / ref[n - i];
            vector<int>::iterator it = candidates.begin() + index;
            k = (k - 1) % ref[n - i] + 1;
            result += to_string(*it);
            candidates.erase(it);
        }
        return result;
    }
};