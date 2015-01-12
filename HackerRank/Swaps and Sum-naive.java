import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numberCount = scan.nextInt();
        int caseCount = scan.nextInt();
        int[] numbers = new int[numberCount];
        for(int i = 0;i < numberCount;i ++){
            numbers[i] = scan.nextInt();
        }
        for(int i = 0;i < caseCount;i ++){
            int type = scan.nextInt();
            int start = scan.nextInt() - 1;
            int end = scan.nextInt() - 1;
            if(type == 1){
                for(int j = start;j < end; j += 2){
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
            else{
                int result = 0;
                for(int j = start;j <= end;j ++)
                    result += numbers[j];
                System.out.println(result);
            }
        }
        return;
    }
}