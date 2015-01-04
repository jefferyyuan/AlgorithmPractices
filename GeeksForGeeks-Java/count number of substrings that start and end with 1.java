// 	ref: http://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/

public List<String> returnSubstrings(String s){
	List<Integer> record = new ArrayList<Integer>();
	List<String> result = new ArrayList<String>();
	for(int i = 0; i < s.length();i ++){
		if(s.charAt(i) == '1'){
			for(int j = 0;j < record.size();j ++){
				String tempString = s.substring(record.get(j), i + 1);
				result.add(tempString);
			}
			record.add(i);
		}
	}
	return result;
}

// 	Not considering duplicates
//	also, why "1" is not a valid substring? It matches the definition well.
public int countSubstrings(String s){
	int oneCount = 0;
	for(int i = 0;i < s.length();i ++){
		if(s.charAt(i) == '1')
			oneCount ++;
	}
	// there might be overflow
	// return (oneCount - 1) * oneCount / 2; 
	// an optimal solution
	if(oneCount % 2 == 0)
		return (oneCount / 2) * (oneCount - 1);
	else
		return ((oneCount - 1) / 2) * oneCount;
}