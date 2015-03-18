import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
	public void init() {
		Scanner scan = new Scanner(System.in);
		int coin = scan.nextInt();
		int setSize = scan.nextInt();
		int[] set = new int[setSize];
		for (int i = 0; i < setSize; i++) {
			set[i] = scan.nextInt();
		}
		Arrays.sort(set);
		int[] record = new int[coin + 1];
		Arrays.fill(record, -1);
		for(int i = 1; i <= coin; i++) {
			if (Arrays.binarySearch(set, i) >= 0) {
				record[i] = i;
			} else {
				int index = 0;
				while ( index < set.length && set[index] <= i) {
					if (record[i - set[index]] < 0) {
						record[i] = set[index];
						break;
					}
					index++;
				}
			}
		}
		System.out.println(record[coin]);
		scan.close();
	}
    public static void main(String[] args)
    {
    	Problem tool = new Problem();
    	tool.init();

       
    }

}