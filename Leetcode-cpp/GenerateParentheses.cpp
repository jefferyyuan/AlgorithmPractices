class Solution {
public:
    vector<string> result;
    vector<int> record;
    vector<string> generateParenthesis(int n) 
    {
        result = vector<string>();
        record = vector<int>(2 * n, 0);
        int left = n, right = n, sum = 0;
        recursiveSearch(left, right, sum, n);
        return result;
    }
    void recursiveSearch(int left, int right, int sum, int n)
    {
        if(left == 0 && right == 0)
        {
            result.push_back(getStringFromVector());
            return;
        }
        else
        {
            if(left > 0)
            {
                record[(n - left) + (n - right)] = 0;
                recursiveSearch(left - 1, right, sum - 1, n);
            }
            if(right > 0 && sum < 0)
            {
                record[(n - left) + (n - right)] = 1;
                recursiveSearch(left, right - 1, sum + 1, n);
            }
            return;
        }
    }
    string getStringFromVector()
    {
        string result = "";
        for(int i = 0;i < record.size();i ++)
        {
            if(record[i] == 0) //left
                result += "(";
            else
                result += ")";
        }
        return result;
    }
};
