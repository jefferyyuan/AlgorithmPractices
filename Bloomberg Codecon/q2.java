import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
	int[] start = new int[1000000];
	int[] end = new int[1000000];
	int index = 0;
	public void init() {
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		int peopleCount = scan.nextInt();
		for (int i = 0; i < peopleCount; i++) {
			scan.next();
			int caseCount = scan.nextInt();
			for (int j = 0; j < caseCount; j++) {
				start[index] = scan.nextInt();
				end[index] = scan.nextInt();
				index++;
			}
		}
		HashSet<Integer> record = new HashSet<Integer>();
		for (int i = 0; i < index; i++) {
			record.add(start[i]);
			record.add(end[i]);
		}
		ArrayList<Integer> templist = new ArrayList<Integer>();
		for(int tempNumber: record) {
			templist.add(tempNumber);
		}
		templist.add(0);
		templist.add(24 * 60 / 15);
		Collections.sort(templist);
		boolean[] free = new boolean[templist.size() - 1];
		Arrays.fill(free, true);
		for (int i = 0; i < index; i++) {
			int startIndex = Collections.binarySearch(templist, start[i]);
			int endIndex = Collections.binarySearch(templist, end[i]);
			for (int j = startIndex; j < endIndex; j++) {
				free[j] = false;
			}
		}
		boolean valid = false;
		for (int i = 0; i < free.length; i++) {
			if(free[i] && templist.get(i + 1) - templist.get(i) >= length) {
				System.out.println(templist.get(i));
				valid = true;
				break;
			}
		}
	    if (!valid) {
	        System.out.println(-1);
	    }	
		scan.close();
	}
    public static void main(String[] args)
    {
    	Problem tool = new Problem();
    	tool.init();

       
    }

}