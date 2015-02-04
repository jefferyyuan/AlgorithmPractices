import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		for(int i = 0; i < n; i++){
			if(i % 2 == 0){
				for(int j = 0; j < m; j++){
					System.out.print("#");
				}
				System.out.println();
			} else{
				if(i % 4 == 1){
					for(int j = 0; j < m - 1; j++){
						System.out.print(".");
					}
					System.out.println("#");
				} else {
					System.out.print("#");
					for(int j = 1; j < m; j++){
						System.out.print(".");
					}
					System.out.println();
				}
			}
		}
		scan.close();
		
	}
}