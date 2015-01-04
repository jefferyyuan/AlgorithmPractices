public Solution{
	public String reverseString(String s);
	char[] record = s.toCharArray();
	int startIndex = 0, endIndex = record.length - 1;
	while(startIndex < endIndex)
	{
		char temp = record[startIndex];
		record[startIndex] = record[endIndex];
		record[endIndex] = temp;
		startIndex ++;
		endIndex --;
	}
	return String.valueOf(record);
}