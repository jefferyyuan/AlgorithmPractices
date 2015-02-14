//给你一个缺了一角的pizza，剩下的pizza被分成了N角（每一块面积不一样）(你可以想象输入是一个int[] array， 你可以从最左边的数取，或者最右边的
//数取。).你和另一个朋友分披萨。每次拿披萨的人只能拿缺口边上的pizza。你先拿，你拿一块，他拿一块直到都拿完。问你怎么拿，才能保证最后你拿到的pizza的面积
//是最大的。

int[][] firstMax; // the maximum value that you could get from a subarray if you were the first
int[][] secondMax;
boolean[][] choice; // true for picking from left, false for picking from right
public int getPizza(int[] input){
	firstMax = new int[input.length][input.length];
	secondMax = new int[input.length][input.length];
	choice = new boolean[input.length][input.length];
	for (int length = 0; length < input.length; length++) {
		for(int i = 0; i + length < input.length; i++){
			if(length == 0){
				firstMax[i][i + length] = input[i];
				secondMax[i][i + length] = 0;
				choice[i][i + length] = true;
			} else {
				if(input[i] + secondMax[i + 1][i + length] > input[i + length] + secondMax[i][i + length - 1]){
					choice[i][i + length] = true;
					firstMax[i][i + length] = input[i] + secondMax[i + 1][i + length] ;
					secondMax[i][i + length] = firstMax[i + 1][i + length];
				} else {
					choice[i][i + length] = false;
					firstMax[i][i + length] = input[i + length] + secondMax[i][i + length - 1]
					secondMax[i][i + length] = firstMax[i][i + length - 1];
				}
			}
		}
	}
	return firstMax[0][input.length - 1];
}
