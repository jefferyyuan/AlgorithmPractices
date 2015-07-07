class Solution {
public:
    vector<vector<int> > permute(vector<int> &num) {
       sort(num.begin(), num.end());
       vector<vector<int>> result;
       do
       {
           vector<int> temp = num;
           result.push_back(temp);
       } while(next_permutation(num.begin(),num.end()));
       return result;
    }
};
