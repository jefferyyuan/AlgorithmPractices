
public void replaceSpace(char[] source, int length)
{
	int newLength = 0;
	for(int i = 0;i < length;i ++)
	{
		if(source[i] == ' ')
			newLength += 3;
		else
			newLength ++;
	}
	if(newLength > source.length)
		return;
	newLength --;
	length --;
	while(newLength >= 0)
	{
		if(source[length] == ' ')
		{
			source[newLength --] = '0';
			source[newLength --] = '2';
			source[newLength --] = '%';
		}
		else
			source[newLength --] = source[length];
		length --;
	}
	return;
}