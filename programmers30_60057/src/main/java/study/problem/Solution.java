package study.problem;

public class Solution {

	public int solution(String s) {
		int answer = s.length(); // 1로 잘랐을 경우
		for (int i = 1; i <= s.length(); i++) {
			answer = Math.min(answer, compression(s, i));
		}
		return answer;
	}

	private int compression(String str, int size) {

		int count = 1;
		StringBuilder result = new StringBuilder();
		String preStr = str.substring(0, size);

		for (int i = size; i <= str.length() + size; i += size) {

			String nowStr = "";

			// 전 문자열과 비교할 현재 문자열
			if (i >= str.length()) { // 현재 문자열이 없을 때
				nowStr = "";
			} else if (str.length() < i + size) { // 마지막 현재 문자열일 때
				nowStr = str.substring(i);
			} else {
				nowStr = str.substring(i, i + size); // 그 외
			}

			if (nowStr.equals(preStr)) { // 똑같으면
				count++;
			} else if (count >= 2) { // 다르고 count가 2회 이상이면 압축 가능
				result.append(count).append(preStr);
				count = 1;
			} else { // 압축 불가능하면 그냥 그대로 문자열 이어붙이기
				result.append(preStr);
			}
			// 2. size 길이만큼 문자열을 자른다.
			preStr = nowStr;
		}

		return result.length();
	}
}