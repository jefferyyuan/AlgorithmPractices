import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	//using hashmap
	//all duplicates print out
	public List<List<Integer>> twoSum(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (input == null || input.length <= 1) {
			return result;
		}
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			if(record.containsKey(target - input[i])) {
				for (int j = 0; j < record.get(target - input[i]); j++) {
					List<Integer> tempResult = new ArrayList<Integer>();
					tempResult.add(input[i]);
					tempResult.add(target - input[i]);
					Collections.sort(tempResult);
					result.add(tempResult);
				} 
			}
			if (!record.containsKey(input[i])) {
				record.put(input[i], 0);
			}
			record.put(input[i], record.get(input[i]) + 1);
		}
		return result;
	}

	//using hashmap
	//without duplicates
	public List<List<Integer>> twoSum(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (input == null || input.length <= 1) {
			return result;
		}
		HashMap<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < input.length; i++) {
			int rest = target - input[i];
			if( (rest == input[i] && record.containsKey(input[i]) && record.get(input[i]) == 1)
				||(rest != input[i] && record.containsKey(rest) && !record.containsKey(input[i]))) {
				List<Integer> tempResult = new ArrayList<Integer>();
				tempResult.add(Math.min(input[i], rest));
				tempResult.add(Math.max(input[i], rest));
				result.add(tempResult);
			}
			if (!record.containsKey(input[i])) {
				record.put(input[i], 1);
			} else {
				record.put(input[i], record.get(input[i]) + 1);
			}
		}
		return result;
	}

	//using sort
	//with duplicates
	public List<List<Integer>> twoSum(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (input == null || input.length <= 1) {
			return result;
		}
		Arrays.sort(input);
		int startIndex = 0, endIndex = input.length - 1;
		while (startIndex < endIndex) {
			if (input[startIndex] + input[endIndex] < target) {
				startIndex++;
			} else if(input[startIndex] + input[endIndex] > target) {
				endIndex--;
			} else {
				if (input[startIndex] == input[endIndex]) {
					int n = endIndex - startIndex + 1;
					for (int i = 0; i < n * (n - 1) / 2; i++) {
						List<Integer> tempResult = new ArrayList<Integer>();
						tempResult.add(input[startIndex]);
						tempResult.add(input[endIndex]);
						result.add(tempResult);
					}
					break;
				} else {
					int leftCount = 0;
					int startValue = input[startIndex];
					while (startIndex < endIndex && input[startIndex] == startValue) {
						startIndex++;
						leftCount++;
					}
					int rightCount = 0;
					int endValue = input[endIndex];
					while (endIndex > startIndex && input[endIndex] == endValue) {
						endIndex--;
						rightCount++;
					}
					for (int i = 0; i < leftCount * rightCount; i++) {
						List<Integer> tempResult = new ArrayList<Integer>();
						tempResult.add(startValue);
						tempResult.add(endValue);
						result.add(tempResult);
					}
				}
			}
		}
		return result;
	}
	//using sort
	//without duplicates
	public List<List<Integer>> twoSum(int[] input, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (input == null || input.length <= 1) {
			return result;
		}
		Arrays.sort(input);
		int startIndex = 0, endIndex = input.length - 1;
		while (startIndex < endIndex) {
			if (input[startIndex] + input[endIndex] < target) {
				startIndex++;
			} else if(input[startIndex] + input[endIndex] > target) {
				endIndex--;
			} else {
				if (input[startIndex] == input[endIndex]) {
					List<Integer> tempResult = new ArrayList<Integer>();
					tempResult.add(input[startIndex]);
					tempResult.add(input[endIndex]);
					result.add(tempResult);
					break;
				} else {
					int startValue = input[startIndex];
					while (startIndex < endIndex && input[startIndex] == startValue) {
						startIndex++;
					}
					int endValue = input[endIndex];
					while (endIndex > startIndex && input[endIndex] == endValue) {
						endIndex--;
					}
					List<Integer> tempResult = new ArrayList<Integer>();
					tempResult.add(startValue);
					tempResult.add(endValue);
					result.add(tempResult);
				}
			}
		}
		return result;
	}


	public void print(List<List<Integer>> result) {
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) throws FileNotFoundException{	
		Solution tool = new Solution();
		int[] input = {2,3,2,3,5};
		tool.print(tool.twoSum(input, 5));

	}
}