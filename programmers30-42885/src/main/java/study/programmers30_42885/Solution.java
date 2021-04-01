package study.programmers30_42885;

import java.util.Arrays;

public class Solution {

	public int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int peopleLen = people.length - 1;
		int min = 0;
		for (int i = peopleLen; i >= min; i--) {
			//최대 무게 인원 기준
			if (people[min] + people[i] <= limit) {
				//못태운 인원중 최대 무게 인원과 최소 크기 인원
				min++;
			}
			answer++;
		}
		return answer;
	}
}