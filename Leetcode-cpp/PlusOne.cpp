#include <vector>
#include <algorithm>
using namespace std;
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        reverse(digits.begin(),digits.end());
        int index = 0;
        while(index < digits.size())
        {
            digits[index] += 1;
            if(digits[index] == 10)
            {
                digits[index] = 0;
                index ++;
            }
            else
            {
                break;
            }
        }
        if(digits[digits.size()-1] == 0)
        {
            digits.push_back(1);
        }
        reverse(digits.begin(),digits.end());
        return digits;
    }
};
