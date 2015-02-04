import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long h = scan.nextLong();
		long exit = scan.nextLong() - 1;
		long count = 0;
		boolean leftFirst = true;
		long base = 1;
		while(h > 0){
			count ++;
			if(leftFirst && exit < (base << (h - 1))){
				leftFirst = false;
			} else if(leftFirst && exit >= (base << (h - 1))){
				leftFirst = true;
				count += ((base << h) - 1);
			} else if(exit < (base << (h - 1))){
				leftFirst = false;
				count += ((base << h) - 1);
			} else{
				leftFirst = true;
			}
			exit = exit % (base << (h - 1));
			h --;
		}
		System.out.println(count);
		scan.close();
	}
}