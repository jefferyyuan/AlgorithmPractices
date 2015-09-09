class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordDict) {
        unordered_map<string, int> ref;
        for(string s : wordDict) ref[s] = -1;
        ref[beginWord] = 0;
        ref[endWord] = -1;
        list<string> record;
        int count = 0;
        record.push_back(beginWord);
        count++;
        int dis = 0;
        while (count > 0) {
            dis++;
            int new_count = 0;
            while (count > 0) {
                string current = record.front();
                record.pop_front();
                count--;
                for (int i = 0; i < current.length(); ++i) {
                    char raw = current[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == raw) continue;
                        current[i] = c;
                        if (ref.find(current) != ref.end() && ref[current] == -1) {
                            record.push_back(string(current));
                            ref[current] = dis;
                            new_count++;
                        }
                    }
                    current[i] = raw;
                }
            }
            if (ref[endWord] >= 0) break;
            count = new_count;
        }
        return ref[endWord] + 1;
    }
};