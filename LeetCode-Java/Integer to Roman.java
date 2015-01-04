public class Solution {
    public String intToRoman(int num) {
        HashMap<Integer,String> map = new HashMap<Integer,String>();
        map.put(0,"");
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        String result = "";
        int unit = getUnit(num);
        while(num > 0)
        {
            result += intToRomanPart((num / unit) * unit, map);
            num %= unit;
            unit /= 10;
        }
        return result;
    }
    
    public String intToRomanPart(int num,HashMap<Integer,String> map)
    {
        String result = "";
        int unit = getUnit(num);
        if(unit == 0) return result;
        int count = num / unit;
        if(count == 9)
        {
            result += map.get(unit) + map.get(10 * unit);
        }
        else if(count == 4)
        {
            result += map.get(unit) + map.get(5 * unit);
        }
        else
        {
            result += map.get((count / 5) * 5 * unit);
            for(int i = 0;i < count % 5;i ++)
            {
                result += map.get(unit);
            }
        }
        return result;
    }
    public int getUnit(int num)
    {
        int i = 1;
        for(;i <= num;i *= 10);
        return i / 10;
    }
}