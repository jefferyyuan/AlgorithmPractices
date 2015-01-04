//	The numbers are represented in reverse order
//	7->1->6 => 617
public ListNode addTwoNumbersReverse(ListNode num1, ListNode num2){
	int unit = 10;
	ListNode fakeHead = new ListNode(-1);
	ListNode pre = fakeHead;
	boolean isUp = false;
	while(num1 != null || num2 != null){
		int val = 0;
		if(num1 == null){
			val = num2.val;
			num2 = num2.next;
		}
		else if(num2 == null){
			val = num1.val;
			num1 = num1.next;
		}
		else
		{
			val = num1.val + num2.val;
			num1 = num1.next;
			num2 = num2.next;
		}
		if(isUp)
			val ++;
		if(val >= unit)
			isUp = true;
		val %= 10;
		ListNode tempNode = new ListNode(val);
		pre.next = tempNode;
		pre = tempNode;
	}
	if(isUp){
		pre.next = new ListNode(1);
	}
	return fakeHead.next;
}

//	The numbers are represented in original order
//	7->1->6 => 716
public ListNode addTwoNumbers(ListNode num1, ListNode num2){
	int length1 = getDepth(num1);
	int length2 = getDepth(num2);
	if(length1 < length2){
		ListNode temp = num2;
		num2 = num1;
		num1 = temp;
	}
	int k = Math.abs(length1 - length2);
	ListNode fakeHead = new ListNode(-1);
	ListNode traverse = fakeHead;
	while(k > 0){
		ListNode tempNode = new ListNode(num1.val);
		traverse.next = tempNode;
		traverse = tempNode;
		num1 = num1.next;
	}
	while(num1 != null){
		ListNode tempNode = new ListNode(num1.val + num2.val);
		traverse.next = tempNode;
		traverse = tempNode;
		num1 = num1.next;
		num2 = num2.next;
	}
	int tempValue = validate(fakeHead.next);
	if(tempValue == 0)
		return fakeHead.next;
	else{
		fakeHead.val = tempValue;
		return fakeHead;
	}
}
public int validate(ListNode num){
	if(num == null)
		return 0;
	int val = num.val + validate(num.next);
	num.val(val % 10);
	return val / 10;
}
public int getDepth(ListNode num){
	int result = 0;
	while(num != null){
		num = num.next;
		result ++;
	}
	return result;
}