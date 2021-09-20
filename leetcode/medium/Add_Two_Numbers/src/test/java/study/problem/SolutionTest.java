package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.opentest4j.AssertionFailedError;

class SolutionTest {

	private Solution solution;

	@BeforeEach
	void init() {
		solution = new Solution();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"[2,4,3]\t[5,6,4]\t[7,0,8]",
		"[0]\t[0]\t[0]",
		"[9,9,9,9,9,9,9]\t[9,9,9,9]\t[8,9,9,9,0,0,0,1]"
	}, delimiter = '\t')
	void testCase(String l1Str, String l2Str, String resultStr) {
		ListNode answer = solution.addTwoNumbers(strToListNode(l1Str), strToListNode(l2Str));

		ListNode expect = strToListNode(resultStr);
		assertListNodeEquals(expect, answer);
	}

	private void assertListNodeEquals(ListNode expect, ListNode answer) {
		boolean flag = true;

		while (flag) {
			try {
				int expectVal = expect.val;
				int answerVal = answer.val;
				assertEquals(expectVal, answerVal);
				if (expect.next == null && answer.next == null) {
					return;
				}
				expect = expect.next;
				answer = answer.next;
			} catch (Exception e) {
				throw new AssertionFailedError("not matched expected value!");
			}
		}
	}

	public ListNode strToListNode(String str) {
		int[] ary = strToIntAry(str);
		ListNode result = new ListNode();
		ListNode cursor = result;
		Queue<Integer> queue = new LinkedList<>();
		Arrays.stream(ary).forEach(queue::add);
		while (!queue.isEmpty()) {
			Integer value = queue.poll();
			cursor.val = value;
			if (!queue.isEmpty()) {
				cursor.next = new ListNode();
				cursor = cursor.next;
			}
		}
		return result;
	}

	private int[] strToIntAry(String str) {
		String[] split = str.split(",");
		return Arrays.stream(split)
			.map(s -> s.replaceAll("\\D", ""))
			.map(String::trim)
			.mapToInt(Integer::valueOf)
			.toArray();
	}
}