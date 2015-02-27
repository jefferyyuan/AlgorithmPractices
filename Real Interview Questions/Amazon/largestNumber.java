
// naive implementation
public int secondLargest(int[] input) {
	if (input == null || input.length < 2) {
		// throw exception
	}
	int[] record = new int[2];
	record[0] = Math.max(input[0], input[1]);
	record[1] = Math.min(input[0], input[1]);
	for (int i = 2; i < input.length; i++) {
		if (input[i] < record[1]) {
			continue;
		} else if (input[i] >= record[0]) {
			record[1] = record[0];
			record[0] = input[i];
		} else {
			record[1] = input[i];
		}
	}
	return record[1];
}

// binary search and update O(kn)
public int kthLargest(int[] input, int k) throws Exception {
	if (input == null || input.length < k) {
		// throw exception
		throw new Exception("Invalid input.");
	}
	int[] record = new int[k];
	for (int i = 0; i < k; i++) {
		record[i] = input[i];
	}
	Arrays.sort(record);
	for (int i = k; i < input.length; i++) {
		int index = binarySearch(record, input[i]);
		if(index < 0) {
			continue;
		} else {
			for (int j = 0; j < index; j++) {
				record[j] = record[j + 1];
			}
			record[index] = input[i];
		}
	}
	return record[0];
}

public int binarySearch(int[] record, int target) {
	int start = 0, end = record.length - 1;
	while(start <= end) {
		int mid = (start + end) / 2;
		if (record[mid] == target) {
			return mid;
		} else if (record[mid] > target) {
			end = mid - 1;
		} else {
			start = mid + 1;
		}
	}
	return start - 1;
}

// priority queue
public int kthLargest(int[] input, int k) throws Exception {
	if (input == null || input.length < k) {
		// throw exception
		throw new Exception("Invalid input.");
	}
	PriorityQueue<Integer> record = new PriorityQueue<Integer>(k);
	for (int i = 0; i < input.length; i++) {
		if(record.size() < k) {
			record.add(input[i]);
		} else {
			if(input[i] > record.peek()) {
				record.poll();
				record.add(input[i]);
			}
		}
	}
	return record.peek();
}