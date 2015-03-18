import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Your submission should *ONLY* use the following class name
public class Problem
{
	boolean[] numbers = new boolean[1005];
	public void init() {
		Scanner scan = new Scanner(System.in);
		int upper = Integer.valueOf(scan.nextLine());
		this.initNumber();
		for (int i = upper; i >= 2; i--) {
			if (numbers[i] && numbers[i - 2]) {
				System.out.println((i-2) + "," + (i));
				break;
			}
		}
		scan.close();
	}
	public void initNumber(){
		Arrays.fill(numbers, true);
		for (int i = 2;i < numbers.length; i++) {
			if (!numbers[i]) {
				continue;
			}
			for (int j = i + i; j < numbers.length; j += i) {
				numbers[j] = false;
			}
		}
	}
    public static void main(String[] args)
    {
    	Problem tool = new Problem();
    	tool.init();

       
    }

}