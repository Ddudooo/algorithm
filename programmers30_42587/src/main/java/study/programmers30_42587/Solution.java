package study.programmers30_42587;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public int solution(int[] priorities, int location) {
		Queue<Doc> queue = new LinkedList<>();
		for (int i = 0; i < priorities.length; i++) {
			queue.add(new Doc(priorities[i], i));
		}
		int printCnt = 0;
		while (!queue.isEmpty()) {
			printCnt++;
			Doc doc = queue.poll();
			if (!isMostImportant(doc, queue)) {
				queue.add(doc);
				printCnt--;
			} else if (doc.index == location) {
				break;
			}
		}
		return printCnt;
	}

	public boolean isMostImportant(Doc document, Queue<Doc> queue) {
		for (Doc doc : queue) {
			if (!doc.importantThan(document)) {
				return false;
			}
		}
		return true;
	}
}

class Doc {

	int priority;
	int index;

	public Doc(int priority, int index) {
		this.priority = priority;
		this.index = index;
	}

	public boolean importantThan(Doc doc) {
		return this.priority <= doc.priority;
	}
}