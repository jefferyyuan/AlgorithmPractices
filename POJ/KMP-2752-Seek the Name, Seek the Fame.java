//	KMP practices
//	don't forget itself(always true)
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	char[] source;
	int[] next;

	public void set(String t_source){
		next = new int[t_source.length()];
		source = t_source.toCharArray();
		next[0] = -1;
		for(int i = 1;i < source.length;i ++){
			int index = next[i - 1];
			while(index >= 0 && source[index] != source[i - 1])
				index = next[index];
			next[i] = index + 1;
		}
	}
	public void solve(){
		List<Integer> record = new ArrayList<Integer>();
		int index = next[source.length - 1];
		while(index >= 0){
			if(source[index] == source[source.length - 1])
				record.add(index + 1);
			index = next[index];
		}
		for(int i = record.size() - 1;i >= 0;i --)
			System.out.print(record.get(i) + " ");
		System.out.println(source.length);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		while(scan.hasNextLine()){
			String source = scan.nextLine();
			solution.set(source);
			solution.solve();
		}
		scan.close();
		return;
	}
}
