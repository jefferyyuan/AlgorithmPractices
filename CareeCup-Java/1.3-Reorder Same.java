public class Solution{
	boolean isReorderSame(String s, String p){
		if(s.length() != p.length())
			return false;
		HashMap<Character,Integer> record = new HashMap<Character,Integer>();
		for(int i = 0;i < s.length();i ++)
		{
			char c = s.charAt(i);
			if(record.containsKey(c))
			{
				int val = record.get(c);
				record.put(c, val + 1);
			}
			else
				record.put(c, 1);

			c = p.charAt(i);
			if(record.containsKey(c))
			{
				int val = record.get(c);
				record.put(c, val - 1);
			}
			else
				record.put(c, -1);
		}
		for(Integer val : record.values())
		{
			if(val != 0)
				return false;
		}
		return true;

	}
}