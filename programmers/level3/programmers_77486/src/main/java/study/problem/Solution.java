package study.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {


	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Node> nodeMap = new HashMap<>();
		Node root = new Node("center");
		Node[] nodes = new Node[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			nodes[i] = new Node(enroll[i]);
			nodeMap.put(enroll[i], nodes[i]);
		}
		for (int i = 0; i < referral.length; i++) {
			if (referral[i].equals("-")) {
				nodes[i].setParent(root);
			} else {
				nodes[i].setParent(nodeMap.get(referral[i]));
			}
		}
		for (int i = 0; i < seller.length; i++) {
			Node sellerNode = nodeMap.get(seller[i]);
			int sellBenefit = amount[i] * 100;
			sellerNode.sell(sellBenefit);
		}
		int[] answer = new int[enroll.length];
		for (int i = 0; i < enroll.length; i++) {
			answer[i] = nodes[i].getMoney();
		}
		return answer;
	}
}

class Node {

	private Node parent = null;
	private String name;
	private int money = 0;

	public Node(String name) {
		this.name = name;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void sell(int benefit) {
		if (this.parent != null) {
			int sendingMoney = benefit / 10;
			int ownBenefit = benefit - sendingMoney;
			this.money += ownBenefit;
			this.parent.sell(sendingMoney);
		} else {
			this.money += benefit;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Node node = (Node) o;
		return Objects.equals(name, node.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}