
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	int count;
	ArrayList<Long> xList = new ArrayList<Long>();
	ArrayList<Long> yList = new ArrayList<Long>();
	long x0,y0;
	public void init(){
		Scanner scan = new Scanner(System.in);
		count = scan.nextInt();
		x0 = scan.nextLong();
		y0 = scan.nextLong();
		int result = 0;
		boolean special = false;
		for(int i = 0; i < count; i++){
			long tempx = scan.nextLong();
			long tempy = scan.nextLong();
			if(tempx == x0 && tempy == y0){
				special = true;
				continue;
			}
			boolean isDuplicate = false;
			for(int j = 0; j < result; j++){
				long x1 = xList.get(j);
				long y1 = yList.get(j);
				if((x1 - x0) * (tempy - y0) == (y1 - y0) * (tempx - x0)){
					isDuplicate = true;
					break;
				}
			}
			if(!isDuplicate){
				xList.add(tempx);
				yList.add(tempy);
				result++;
			}
		}
		if(special && result == 0)
			result = 1;
		System.out.println(result);
		scan.close();
	}

	public void solve(){
		
	}
	public static void main(String[] args){	
		Solution tool = new Solution();
		tool.init();
		tool.solve();
	}
}