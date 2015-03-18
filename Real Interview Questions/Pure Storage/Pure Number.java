
public boolean isPureNumber(int value) {
	if (value <= 0) {
		return false;
	}
	HashSet<Integer> record = new HashSet<Integer>();
	while (value != 1 && !record.contains(value)) {
		record.add(value);
		int tempValue = 0;
		while (value > 0) {
			int digit = value % 10;
			tempValue += digit * digit;
			value /= 10;
		}
		value = tempValue;
	}
	return value == 1;
}