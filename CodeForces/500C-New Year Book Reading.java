import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int bookCount = scan.nextInt();
		int dayCount = scan.nextInt();
		int[] weightRecord = new int[bookCount];
		for(int i = 0;i < bookCount;i ++)
			weightRecord[i] = scan.nextInt();
		int[] bookRecord = new int[dayCount];
		for(int i = 0;i < dayCount;i ++)
			bookRecord[i] = scan.nextInt() - 1;
		int[] order = new int[bookCount];
		Arrays.fill(order, -1);
		int currentOrder = 0;
		for(int i = 0;i < dayCount;i ++){
			int index = bookRecord[i];
			if(order[index] >= 0)
				continue;
			else{
				order[index] = currentOrder;
				currentOrder ++;
			}
		}
		int[] position = new int[currentOrder];
		for(int i = 0;i < bookCount;i ++){
			if(order[i] >= 0)
				position[order[i]] = i;
		}
		int result = 0;
		for(int i = 0;i < dayCount;i ++){
			int book = bookRecord[i];
			for(int j = 0;j < currentOrder;j ++){
				if(position[j] != book)
					result += weightRecord[position[j]];
				else{
					// change the position
					for(int k = j; k > 0;k --)
						position[k] = position[k - 1];
					position[0] = book;
					break;
				}
			}
		}
		System.out.println(result);
		scan.close();
	}
}