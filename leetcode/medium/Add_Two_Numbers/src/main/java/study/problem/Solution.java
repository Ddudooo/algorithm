package study.problem;

class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = new ListNode(0);
		ListNode result = answer;
		int roundUpValue = 0;
		while (l1.next != null || l2.next != null) {
			int val1 = l1 == null ? 0 : l1.val;
			System.out.println("val1 = " + val1);
			int val2 = l2 == null ? 0 : l2.val;
			System.out.println("val2 = " + val2);
			int sum = val1 + val2 + roundUpValue;
			answer.val = sum % 10;
			roundUpValue = sum / 10;

			if (l1.next != null) {
				l1 = l1.next;
			} else {
				l1 = new ListNode(0);
			}

			if (l2.next != null) {
				l2 = l2.next;
			} else {
				l2 = new ListNode(0);
			}
			answer.next = new ListNode(0);
			answer = answer.next;
		}

		int val1 = l1 == null ? 0 : l1.val;
		System.out.println("val1 = " + val1);
		int val2 = l2 == null ? 0 : l2.val;
		System.out.println("val2 = " + val2);
		int sum = val1 + val2 + roundUpValue;
		answer.val = sum % 10;
		roundUpValue = sum / 10;
		if (roundUpValue > 0) {
			answer.next = new ListNode(roundUpValue);
		}
		return result;
	}
}

class ListNode {

	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}