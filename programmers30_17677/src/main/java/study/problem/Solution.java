package study.problem;

import static java.lang.Character.isLetter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Solution {

	public int solution(String str1, String str2) {
		List<PartStr> partStrs1 = strToCharSet(str1);
		List<PartStr> partStrs2 = strToCharSet(str2);
		float result = jaccard(partStrs1, partStrs2);
		return Math.round(result * 65536);
	}

	private float jaccard(Collection<PartStr> partStrs1, Collection<PartStr> partStrs2) {
		//교집합
		List<PartStr> intersection = new ArrayList<>();
		List<PartStr> union = new ArrayList<>();
		for (PartStr elem : partStrs1) {
			if (partStrs2.contains(elem)) {
				intersection.add(elem);
				partStrs2.remove(elem);
			}
			union.add(elem);
		}
		union.addAll(partStrs2);
		//합집합
		BigDecimal intersectionCount = BigDecimal.valueOf(intersection.size());
		BigDecimal unionCount = BigDecimal.valueOf(union.size());
		try {
			return intersectionCount.divide(unionCount, 5, RoundingMode.FLOOR).floatValue();
		} catch (Exception e) {
			return 1L;
		}
	}

	// 두글자 조합
	public List<PartStr> strToCharSet(String str) {
		List<PartStr> result = new ArrayList<>();
		str = str.toUpperCase();
		for (int i = 0; i < str.length() - 1; i++) {
			char a = str.charAt(i);
			char b = str.charAt(i + 1);
			if (!isLetter(a) || !isLetter(b)) {
				continue;
			}
			result.add(new PartStr(a, b));
		}
		return result;
	}
}

class PartStr {

	private char a;
	private char b;

	public PartStr(char a, char b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		PartStr partStr = (PartStr) o;
		return (a == partStr.a && b == partStr.b);
	}

	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}

	@Override
	public String toString() {
		return "'" + a + b + "'";
	}
}

