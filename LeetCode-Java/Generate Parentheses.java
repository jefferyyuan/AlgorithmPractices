public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> recordList = new ArrayList<List<String>>();
        // first two array
        List<String> list0 = new ArrayList<String>();
        list0.add("");
        recordList.add(list0);
        List<String> list1 = new ArrayList<String>();
        list1.add("()");
        recordList.add(list1);
        for(int i = 2;i <= n;i ++)
        {
            List<String> newList = new ArrayList<String>();
            for(int j = 0;j < i;j ++)
            {
                List<String> tempList1 = recordList.get(j);
                List<String> tempList2 = recordList.get(i - j - 1);
                for(int m = 0; m < tempList1.size(); m ++)
                {
                    for(int k = 0;k < tempList2.size();k ++)
                    {
                        String tempResult = "("+tempList1.get(m) + ")" + tempList2.get(k);
                        newList.add(tempResult);
                    }
                }
            }
            recordList.add(newList);
        }
        return recordList.get(n);
    }
}