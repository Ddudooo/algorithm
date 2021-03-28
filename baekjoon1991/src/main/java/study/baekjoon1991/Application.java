package study.baekjoon1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Application {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int n;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char leftData = st.nextToken().charAt(0);
			char rightData = st.nextToken().charAt(0);
			tree.add(data, leftData, rightData);
		}
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
		System.out.println();
		br.close();
	}
}

class Node {

	char data;
	Node leftNode;
	Node rightNode;

	public Node(char data) {
		this.data = data;
	}

	public void setTreeNodeData(char left, char right) {
		setLeftNode(left);
		setRightNode(right);
	}

	public void setLeftNode(char leftData) {
		if (leftData != '.') {
			this.leftNode = new Node(leftData);
		}
	}

	public void setRightNode(char rightData) {
		if (rightData != '.') {
			this.rightNode = new Node(rightData);
		}
	}
}

class Tree {

	Node root;

	public void add(char data, char leftData, char rightData) {
		Node addNode = new Node(data);
		if (root == null) {
			root = addNode;
			root.setTreeNodeData(leftData, rightData);
		} else {
			search(root.leftNode, data, leftData, rightData);
			search(root.rightNode, data, leftData, rightData);
		}
	}

	public void search(Node searchNode, char data, char leftData, char rightData) {
		if (searchNode == null) {
			return;
		} else if (searchNode.data == data) {
			searchNode.setTreeNodeData(leftData, rightData);
		} else {
			search(searchNode.leftNode, data, leftData, rightData);
			search(searchNode.rightNode, data, leftData, rightData);
		}
	}

	/**
	 * mid -> left -> right
	 */
	public void preOrder(Node print) {
		System.out.print(print.data);

		if (print.leftNode != null) {
			preOrder(print.leftNode);
		}
		if (print.rightNode != null) {
			preOrder(print.rightNode);
		}
	}

	/**
	 * left -> mid -> right
	 */
	public void inOrder(Node print) {
		if (print.leftNode != null) {
			inOrder(print.leftNode);
		}
		System.out.print(print.data);
		if (print.rightNode != null) {
			inOrder(print.rightNode);
		}
	}

	/**
	 * left -> right -> mid
	 */
	public void postOrder(Node print) {
		if (print.leftNode != null) {
			postOrder(print.leftNode);
		}
		if (print.rightNode != null) {
			postOrder(print.rightNode);
		}
		System.out.print(print.data);
	}
}