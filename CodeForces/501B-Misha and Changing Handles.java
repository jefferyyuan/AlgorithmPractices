import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

	public static void main(String[] args){
		HashMap<String, String> record = new HashMap<String, String>();
		Scanner scan = new Scanner(System.in);
		int caseCount = scan.nextInt();
		for (int i = 0; i < caseCount; i++){
			String oldName = scan.next();
			String newName = scan.next();
			if(!record.containsKey(oldName))
				record.put(newName, oldName);
			else{
				String sourceName = record.get(oldName);
				record.put(newName, sourceName);
				record.remove(oldName);
			}
		}
		System.out.println(record.size());
		for (Map.Entry<String, String> entry : record.entrySet()) {
    		String key = entry.getKey();
    		String value = entry.getValue();
    		System.out.println(value + " " + key);
		}

		scan.close();
	}
}