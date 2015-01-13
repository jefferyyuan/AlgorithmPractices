//DP practices
//partial sums problem : target->sum/2
//挑战程序设计竞赛 p63
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main{
	int typeCount = 6;
	int[] numberRecord = new int[typeCount];

	String[] output = {"Can't be divided.","Can be divided."};

	public int solve(Scanner scan){
		int sum = 0;
		for(int i = 0; i < typeCount; i++){
			numberRecord[i] = scan.nextInt();
			sum += numberRecord[i] * (i + 1);
		}
		if((sum & 1) > 0)
			return 0;
		if(sum == 0)
			return -1;
		int target = sum / 2;
		int[] record = new int[target + 1];
		Arrays.fill(record, -1);
		for(int i = 0; i < typeCount; i++){
			record[0] = numberRecord[i];
			for(int j = 1;j <= target; j++){
				if(record[j] >= 0)
					record[j] = numberRecord[i];
				else if(j < i + 1)
					record[j] = -1;
				else
					record[j] = record[j - i - 1] - 1;
			}
		}
		if(record[target] >= 0)
			return 1;
		else
			return 0;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Main solution = new Main();
		int index = 0;
		int result = solution.solve(scan);
		while(result != -1){
			index ++;
			if(index > 1)
				System.out.println();
			System.out.println("Collection #" + index + ":" );
			System.out.println(solution.output[result]);
			result = solution.solve(scan);
		}
		scan.close();
	}
}