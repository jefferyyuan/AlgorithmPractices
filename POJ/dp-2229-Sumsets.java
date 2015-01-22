import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] record = new int[1000001];
		record[0] = 1;
		record[1] = 1;
		for(int i = 2;i <= n;i ++){
			if((i & 1) > 0)
				record[i] = record[i - 1];
			else
				record[i] = (record[i - 2] + record[i / 2]) % 1000000000;
		}
		System.out.println(record[n]);
		scan.close();
	}
}