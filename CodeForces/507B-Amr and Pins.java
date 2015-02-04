import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long r = scan.nextInt();
		long x1 = scan.nextInt();
		long y1 = scan.nextInt();
		long x2 = scan.nextInt();
		long y2 = scan.nextInt();
		r = 2 * r;
		long target = (long)Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
		long count = target / r;
		count = Math.max(0, count - 1);
		while(count * count * r * r < (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2))
			count ++;
		System.out.println(count);
		scan.close();
		return;
	}
}