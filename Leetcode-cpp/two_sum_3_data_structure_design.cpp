class TwoSum {
public:
    unordered_map<int, int> record;
	void add(int number) {
	    record[number]++;
	}

	bool find(int value) {
	    for (auto val : record) {
	        int left = val.first;
	        if (left + left == value) {
	            if (val.second >= 2) return true;
	        } else if (record.find(value - left) != record.end()) {
	            return true;
	        }
	    }
	    return false;
	}
};