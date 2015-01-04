    public class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean isStar = false;
            int preMStart = 0, preNStart = 0;
            int mIndex = 0, nIndex = 0;
            while(true)
            {
                if(mIndex == m && nIndex == n)
                    return true;
                else if(mIndex == m)
                {
                    while(nIndex < n && p.charAt(nIndex) == '*')
                        nIndex ++;
                    return nIndex == n;
                }
                else if(nIndex == n)
                {
                    if(!isStar)
                        return false;
                    else
                    {
                        preMStart ++;
                        if(preMStart == m)
                            return false;
                        mIndex = preMStart;
                        nIndex = preNStart;
                    }
                }
                else
                {
                    if(p.charAt(nIndex) == '?')
                    {
                        mIndex ++;
                        nIndex ++;
                        continue;
                    }
                    else if(p.charAt(nIndex) == '*')
                    {
                        isStar = true;
                        preNStart = nIndex;
                        while(preNStart < n && p.charAt(preNStart) == '*')
                            preNStart ++;
                        if(preNStart == n)
                            return true;
                        preMStart = mIndex;
                        mIndex = preMStart;
                        nIndex = preNStart;
                    }
                    else if(s.charAt(mIndex) == p.charAt(nIndex))
                    {
                        mIndex ++;
                        nIndex ++;
                    }
                    else
                    {
                        if(!isStar)
                            return false;
                        else
                        {
                            preMStart ++;
                            if(preMStart == m)
                                return false;
                            mIndex = preMStart;
                            nIndex = preNStart;
                        }
                    }
                }
            }
        }
    }