class Solution {
public:
	string minWindow(string s, string t) {
		unordered_map<char, int> record_t;
		for (char c : t) record_t[c]++;
		unordered_map<char, int> record_s;
		int count = 0;
		int result = INT_MAX;
		int index = -1;
		int start_index = 0, end_index = -1;
		while (end_index < (int)s.length() - 1) {
			while (end_index < (int)s.length() - 1 && count < record_t.size()) {
				end_index++;
				char c = s[end_index];
				record_s[c]++;
				if (record_t.find(c) != record_t.end() && record_s[c] == record_t[c]) count++;
			}
			if (count != record_t.size()) break;
			while (start_index <= end_index && count == record_t.size()) {
				char c = s[start_index];
				if (record_t.find(c) != record_t.end() && record_s[c] == record_t[c]) count--;
				record_s[c]--;
				start_index++;
			}
			if (end_index - start_index + 2 < result) {
				result = end_index - start_index + 2;
				index = start_index - 1;
			}
		}
		if (result == INT_MAX) return "";
		else return s.substr(index, result);
	}
};