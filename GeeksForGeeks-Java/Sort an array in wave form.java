
public void sortInWave(int[] numbers){
	if(numbers == null || numbers.length <= 1)
		return;
	boolean isBig = false;
	for(int i = 0;i < numbers.length - 1;i ++){
		if((isBig && numbers[i] > numbers[i + 1])
			||(!isBig && numbers[i] < numbers[i + 1])){
			int temp = numbers[i];
			numbers[i] = numbers[i + 1];
			numbers[i + 1] = temp;
		}
		isBig = !isBig;
	}
	return;
}

public void test_1(){
	int[] source = {1, 2, 3, 4, 5};
	sortInWave(source);
	for(int i = 0;i < source.length;i ++)
		System.out.print(source[i] + " ");
	return;
}
