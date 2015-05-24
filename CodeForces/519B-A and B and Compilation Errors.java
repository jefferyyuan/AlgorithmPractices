import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public void init(){
		Scanner scan = new Scanner(System.in);
		int count = scan.nextInt();
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < count; i++) {
			int value = scan.nextInt();
			if (!record.containsKey(value)) {
				record.put(value, 0);
			}
			record.put(value, record.get(value) + 1);
		}

		HashMap<Integer, Integer> tempRecord = new HashMap<Integer, Integer>(record);

		for (int i = 0; i < count - 1; i++) {
			int value = scan.nextInt();
			tempRecord.put(value, tempRecord.get(value) - 1);
			if(tempRecord.get(value) == 0) {
				tempRecord.remove(value);
			}
		}
		for (Integer key: tempRecord.keySet()) {
			System.out.println(key);
			record.put(key, record.get(key) - 1);
			if (record.get(key) == 0) {
				record.remove(key);
			}
		}

		tempRecord = new HashMap<Integer, Integer>(record);

		for (int i = 0; i < count - 2; i++) {
			int value = scan.nextInt();
			tempRecord.put(value, tempRecord.get(value) - 1);
			if(tempRecord.get(value) == 0) {
				tempRecord.remove(value);
			}
		}
		for (Integer key: tempRecord.keySet()) {
			System.out.println(key);
			record.put(key, record.get(key) - 1);
		}

		scan.close();
	}

	public void solve(){
		
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
		tool.solve();
	}
}