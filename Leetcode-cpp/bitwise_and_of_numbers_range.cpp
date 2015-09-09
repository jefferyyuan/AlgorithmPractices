class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
		long long diff = n - m;
		diff++;
		long long val = 1;
		while (val < diff) {
			val = val << 1;
			m = m >> 1;
			n = n >> 1;
		}
		int result = INT_MAX;
		for (int i = m; i < n; i++) {
			result &= i;
		}
		result &= n;
		long long newVal = 1;
		while (newVal < val) {
			newVal = newVal << 1;
			result = result << 1;
		}
		return result;
    }
};