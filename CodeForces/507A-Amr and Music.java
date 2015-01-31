import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public class ArrayIndexComparator implements Comparator<Integer>
	{
	    private final int[] array;

	    public ArrayIndexComparator(int[] array)
	    {
	        this.array = array;
	    }

	    public Integer[] createIndexArray()
	    {
	        Integer[] indexes = new Integer[array.length];
	        for (int i = 0; i < array.length; i++)
	        {
	            indexes[i] = i; // Autoboxing
	        }
	        return indexes;
	    }

	    @Override
	    public int compare(Integer index1, Integer index2)
	    {
	         // Autounbox from Integer to int to use as array indexes
	        return array[index1] - (array[index2]);
	    }
	}

	public void solve(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] record = new int[n];
		for(int i = 0; i < n; i++){
			record[i] = scan.nextInt();
		}

		ArrayIndexComparator comparator = new ArrayIndexComparator(record);
		Integer[] indexes = comparator.createIndexArray();
		Arrays.sort(indexes, comparator);
		int tempResult = 0;
		int useCount = 0;
		while(useCount < n &&tempResult + record[indexes[useCount]] <= m){
			tempResult += record[indexes[useCount]];
			useCount ++;
		}
		System.out.println(useCount);
		if(useCount > 0){
			for(int i = 0; i < useCount; i++){
				System.out.print(indexes[i] + 1);
				System.out.print(" ");
			}
		}
		scan.close();
	}
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
		return;
	}
}