// ref: http://www.geeksforgeeks.org/check-given-array-contains-duplicate-elements-within-k-distance/

public boolean hasDuplicatesWithinKDistance(int[] numbers){
	HashMap<Integer,Integer> record = new HashMap<Integer, Integer>();
	for(int i = 0;i < numbers.length;i ++){
		if(record.containsKey(numbers[i]) && i - record.get(numbers[i]) <= k)
			return true;
		record.put(numbers[i], i);
	}
	return false;
}