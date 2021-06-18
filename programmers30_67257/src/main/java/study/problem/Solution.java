package study.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	static Operator[] ops;
	static Operator[] ranks;
	static boolean[] visit;
	static long answer;

	public long solution(String expression) {
		answer = 0;
		ops = new HashSet<>(getOperators(expression)).toArray(Operator[]::new);
		ranks = new Operator[ops.length];
		visit = new boolean[ops.length];
		combinationOps(0, ops.length, expression);
		return answer;
	}

	private void combinationOps(int size, int target, String expression) {
		if (size == target) {
			answer = Math
				.max(answer, calculate(getNumbers(expression), getOperators(expression), ranks));
		}
		for (int i = 0; i < ops.length; i++) {
			if (!visit[i]) {
				visit[i] = true;
				ranks[size] = ops[i];
				combinationOps(size + 1, target, expression);
				visit[i] = false;
			}
		}
	}

	private List<Long> getNumbers(String expression) {
		String[] numbers = expression.split("\\D");
		return Arrays.stream(numbers)
			.map(Long::valueOf)
			.collect(Collectors.toList());
	}

	private List<Operator> getOperators(String expression) {
		return Arrays.stream(expression.split("\\d"))
			.filter(e -> e.length() > 0)
			.map(Operator::of)
			.collect(Collectors.toList());
	}

	private static long calculate(List<Long> numbers, List<Operator> operators,
		Operator[] operatorRank) {
		for (Operator curOp : operatorRank) {
			for (int i = 0; i < operators.size(); i++) {
				Operator op = operators.get(i);
				if (op.equals(curOp)) {
					int opIdx = operators.indexOf(op);
					long result = op.calculate(numbers.get(opIdx), numbers.get(opIdx + 1));
					numbers.remove(opIdx);
					numbers.remove(opIdx);
					numbers.add(opIdx, result);
					operators.remove(op);
					i--;
				}
			}
		}
		return Math.abs(numbers.get(0));
	}
}

enum Operator {
	PLUS,
	MINUS,
	MULTIPLY;

	public static Operator of(String operator) throws IllegalArgumentException {
		switch (operator.trim()) {
			case "+":
				return PLUS;
			case "-":
				return MINUS;
			case "*":
				return MULTIPLY;
			default:
				throw new IllegalArgumentException("no such elements");
		}
	}

	public long calculate(long pre, long sur) {
		switch (this) {
			case PLUS:
				return pre + sur;
			case MINUS:
				return pre - sur;
			case MULTIPLY:
				return pre * sur;
			default:
				throw new IllegalArgumentException("not support operator.");
		}
	}
}