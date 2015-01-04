public class TwoSum {
    HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
	public void add(int number) {
	    int value = 0;
	    if(record.containsKey(number))
	        value = record.get(number);
	    record.put(number, value + 1);
	}

	public boolean find(int value) {
	    for(Integer key : record.keySet()){
	        int another = value - key;
	        if(another == key && record.get(key) > 1)
	            return true;
	        if(another != key && record.containsKey(another))
	            return true;
	    }
	    return false;
	}
}