
public boolean isRotate(String s, String p)
{
	if(s == null) 
		return p == null;
	if(s.length() != p.length())
		return false;
	String test = p + p;
	return isSubstring(test, s);
}

public boolean isSubstring(String s, String p)
{
	if(s == null)
		return (p == null);
	else
		return (p.indexOf(p) >= 0);
}