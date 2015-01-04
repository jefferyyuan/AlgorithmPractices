

String compressString(String s)
{
	if(s == null || s.length() <= 1)
		return s;
	int newLength = 0;
	char c = 0;
	for(int i = 0;i < s.length();i ++)
	{
		char t = s.charAt(i);
		if(t != c)
		{
			newLength += 2;
			c = t;
		}
	}
	if(newLength >= s.length())
		return s;
	//	return new String(s);
	char[] resultArray = new char[newLength];
	int index = 0;
	c = 0;
	int dupCount = 0;
	for(int i = 0;i <= s.length();i ++)
	{
		if(i == 0)
		{
			c = s.charAt(i);
			dupCount = 1;
		}
		else if(i == s.length() || s.charAt(i) != c)
		{
			resultArray[index ++] = c;
			resultArray[index ++] = (char)('0' + dupCount);
			if(i != s.length())
			{
				c = s.charAt(i);
				dupCount = 1;
			}
		}
		else
			dupCount ++;
	}
	return String.valueOf(resultArray);
}