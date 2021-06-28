package study.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {

	static Cache cache;

	public int solution(int cacheSize, String[] cities) {
		Solution.cache = new Cache(cacheSize);
		int answer = 0;
		for (String city : cities) {
			city = city.toUpperCase();
			answer += cache.contain(city);
		}
		return answer;
	}
}

class Cache {

	List<Entry> entries;
	int size;

	public Cache(int size) {
		this.entries = new ArrayList<>();
		this.size = size;
	}

	public int contain(String city) {
		if (entries.contains(new Entry(city))) {
			entries.get(entries.indexOf(new Entry(city))).used();
			return 1;
		} else {
			if (size == 0) {
				return 5;
			} else if (size > entries.size()) {
				entries.add(new Entry(city));
			} else {
				entries.sort(Entry::compareTo);
				entries.remove(0);
				entries.add(0, new Entry(city));
			}
			return 5;
		}
	}
}

class Entry implements Comparable<Entry> {

	String value;
	long used;

	public Entry(String value) {
		this.value = value;
		this.used = System.nanoTime();
	}

	public void used() {
		this.used = System.nanoTime();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Entry entry = (Entry) o;
		return Objects.equals(value, entry.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(Entry o) {
		return (int) (this.used - o.used);
	}
}