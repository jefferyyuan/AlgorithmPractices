public class Solution{
	public boolean isCharDifferent(String s)
	{
		HashSet<Character> record = new HashSet<Character>();
		for(int i = 0;i < s.length();i ++){
			if(record.contains(s.charAt(i)))
				return false;
			else
				record.add(s.charAt(i));
		}
		return true;
	}

	public boolean isCharDifferentSimple(String s)
	{
		char[] record = s.toCharArray();
		Arrays.sort(record);
		for(int i = 0;i < s.length() - 1;i ++)
		{
			if(record[i] == record[i + 1])
				return false;
		}
		return true;
	}
}