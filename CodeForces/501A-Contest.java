import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Solution{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double[] points = new double[2];
		for (int i = 0; i < points.length; i++){
			points[i] = scan.nextDouble();
		}
		double[] time = new double[2];
		for (int i = 0; i < points.length; i++){
			time[i] = scan.nextDouble();
		}
		double[] score = new double[2];
		for (int i = 0; i < score.length; i++){
			score[i] = Math.max(0.3 * points[i], points[i] - points[i] * time[i] / 250);
		}
		if(score[0] > score[1])
			System.out.println("Misha");
		else if(score[0] < score[1])
			System.out.println("Vasya");
		else
			System.out.println("Tie");

		scan.close();
	}
}