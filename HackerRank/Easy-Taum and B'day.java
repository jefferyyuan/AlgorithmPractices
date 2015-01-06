import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

//  The only one trick is the long data type.(failed once)
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        for(int i = 0; i < testCount; i++){
            long blackCount = scan.nextLong();
            long whiteCount = scan.nextLong();
            long blackValue = scan.nextLong();
            long whiteValue = scan.nextLong();
            long transfer = scan.nextLong();
            blackValue = Math.min(blackValue, whiteValue + transfer);
            whiteValue = Math.min(whiteValue, blackValue + transfer);
            long result = blackCount * blackValue + whiteCount * whiteValue;
            System.out.println(result);
        }
        scan.close();
    }
}