package study.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public int[][] solution(int[][] nodeinfo) {
		PriorityQueue<Node> queue = new PriorityQueue<>(
			(a, b) -> -1 * Integer.compare(a.height, b.height));
		int idx = 1;
		for (int[] node : nodeinfo) {
			queue.add(new Node(node[0], node[1], idx++));
		}
		Tree tree = new Tree(queue.poll());
		while (!queue.isEmpty()) {
			tree.insert(queue.poll());
		}
		int[] preOrder = tree.preOrder().stream().mapToInt(Integer::intValue).toArray();
		int[] postOrder = tree.postOrder().stream().mapToInt(Integer::intValue).toArray();
		return new int[][]{preOrder, postOrder};
	}
}

class Tree {

	Node node;
	Tree left;
	Tree right;

	public Tree(Node node) {
		this.node = node;
	}

	public void insert(Node node) {
		if (this.node.compareTo(node) > 0) {
			if (this.left == null) {
				this.left = new Tree(node);
			} else {
				this.left.insert(node);
			}
		} else {
			if (this.right == null) {
				this.right = new Tree(node);
			} else {
				this.right.insert(node);
			}
		}
	}

	public List<Integer> preOrder() {
		List<Integer> result = new ArrayList<>();
		result.add(this.node.idx);
		if (this.left != null) {
			result.addAll(left.preOrder());
		}
		if (this.right != null) {
			result.addAll(right.preOrder());
		}
		return result;
	}

	public List<Integer> postOrder() {
		List<Integer> result = new ArrayList<>();
		if (this.left != null) {
			result.addAll(this.left.postOrder());
		}
		if (this.right != null) {
			result.addAll(this.right.postOrder());
		}
		result.add(this.node.idx);
		return result;
	}
}

class Node implements Comparable<Node> {

	final int value;
	final int height;
	final int idx;


	Node(int value, int height, int idx) {
		this.value = value;
		this.height = height;
		this.idx = idx;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.value, o.value);
	}
}