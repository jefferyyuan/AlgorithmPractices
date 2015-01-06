//	KMP practices
//	overlap is permitted
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	int[] next;
	String source;
	String input;
	public void set(String t_source, String t_input){
		source = t_source;
		input = t_input;
		//	compute next array
		next = new int[source.length() + 1];
		next[0] = -1;
		for(int i = 1;i < next.length;i ++){
			char c = source.charAt(i - 1);
			int index = next[i - 1];
			while(index >= 0 && c != source.charAt(index))
				index = next[index];
			next[i] = index + 1;
		}
	}
	public void solve(){
		int s_index = 0;
		int i_index = 0;
		int result = 0;
		while(i_index < input.length()){
			if(source.charAt(s_index) == input.charAt(i_index)){
				s_index ++;
				i_index ++;
				//	match
				if(s_index == source.length()){
					result ++;
					s_index = next[s_index];
				}
			}
			else{
				int tempIndex = next[s_index];
				while(tempIndex >= 0 && source.charAt(tempIndex) != input.charAt(i_index)){
					tempIndex = next[tempIndex];
				}
				s_index = tempIndex + 1;
				i_index ++;
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int count = Integer.valueOf(scan.nextLine());
		Main solution = new Main();
		for(int i = 0;i < count;i ++){
			String source = scan.nextLine();
			String input = scan.nextLine();
			solution.set(source, input);
			solution.solve();
		}
		scan.close();
		return;
	}
}