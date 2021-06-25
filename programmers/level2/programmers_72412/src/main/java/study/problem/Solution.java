package study.problem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		List<Person> people = getInfo(info);
		for (int i = 0; i < query.length; i++) {
			String[] queries = getQuery(query[i]);
			long count = people.stream()
				.filter(person -> person.eqLanguage(queries[0]))
				.filter(person -> person.eqTask(queries[1]))
				.filter(person -> person.eqJunior(queries[2]))
				.filter(person -> person.eqPizza(queries[3]))
				.filter(person -> person.gteScore(queries[4]))
				.count();
			answer[i] = (int) count;
		}
		return answer;
	}

	private String[] getQuery(String s) {
		return s.split(" and | ");
	}

	public List<Person> getInfo(String[] infoArray) {
		return Arrays.stream(infoArray)
			.map(infoStr -> {
				String[] info = infoStr.split(" ");
				return new Person(info);
			})
			.collect(Collectors.toList());
	}
}

class Person {

	private final String language;
	private final boolean backend;
	private final boolean junior;
	private final boolean pizza;
	private final int score;

	Person(String... info) {
		this.language = info[0];
		this.backend = "backend".equals(info[1]);
		this.junior = "junior".equals(info[2]);
		this.pizza = "pizza".equals(info[3]);
		this.score = Integer.parseInt(info[4]);
	}

	public boolean eqLanguage(String query) {
		return "-".equals(query.trim()) || language.equals(query.trim());
	}

	public boolean eqTask(String query) {
		if ("-".equals(query.trim())) {
			return true;
		}
		return "backend".equals(query.trim()) == backend;
	}

	public boolean eqJunior(String query) {
		if ("-".equals(query.trim())) {
			return true;
		}
		return "junior".equals(query.trim()) == junior;
	}

	public boolean eqPizza(String query) {
		if ("-".equals(query.trim())) {
			return true;
		}
		return "pizza".equals(query.trim()) == pizza;
	}

	public boolean gteScore(String query) {
		if ("-".equals(query.trim())) {
			return true;
		}
		return score >= Integer.parseInt(query.trim());
	}
}