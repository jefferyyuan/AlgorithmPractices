// return the last k_th node of a LinkedList(given head node)
// if the length of the LinkedList is less than k, return null
public ListNode findLastKthNode(ListNode head, int k){
	ListNode fast = head;
	k --;
	while(k > 0 && fast != null)
		fast = fast.next;
	if(k > 0)
		return null;
	while(fast != null){
		fast = fast.next;
		head = head.next;
	}
	return head;
}