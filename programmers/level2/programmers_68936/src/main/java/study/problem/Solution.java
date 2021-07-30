package study.problem;

public class Solution {

	public int[] solution(int[][] arr) {
		int size = arr.length;
		int[] answer = calculate(0, 0, size, size, arr);
		return answer;
	}

	public int[] calculate(int startX, int startY, int endX, int endY, int[][] map) {

		int[] result = new int[2];
		result[0] = 0;
		result[1] = 0;
		int ele = map[startX][startY];
		boolean matched = true;
		notMatch:
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if (ele != map[i][j]) {
					matched = false;
					break notMatch;
				}
			}
		}
		if (matched) {
			result[ele] = 1;
			System.out.printf("stX = %d, endX = %d, stY = %d, endY = %d\n", startX, endX, startY,
				endY);
			System.out.println("result[0] = " + result[0] + ", result[1] = " + result[1]);
			print(startX, startY, endX, endY, map);
			return result;
		}
		int midX = (startX + endX) / 2;
		int midY = (startY + endY) / 2;
		int[] area1 = calculate(startX, startY, midX, midY, map);
		int[] area2 = calculate(midX, startY, endX, midY, map);
		int[] area3 = calculate(startX, midY, midX, endY, map);
		int[] area4 = calculate(midX, midY, endX, endY, map);
		result[0] = area1[0] + area2[0] + area3[0] + area4[0];
		result[1] = area1[1] + area2[1] + area3[1] + area4[1];
		System.out.printf("stX = %d, endX = %d, stY = %d, endY = %d\n", startX, endX, startY, endY);
		System.out.println("result[0] = " + result[0] + ", result[1] = " + result[1]);
		print(startX, startY, endX, endY, map);
		return result;
	}

	private void print(int startX, int startY, int endX, int endY, int[][] map) {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_RED = "\u001B[31m";
		int size = map.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (((startX == endX) && (startX == i) || startX <= i && i < endX)
					&& ((startY == endY) && (startY == j) || startY <= j && j < endY)) {
					System.out.printf("%s%d %s", ANSI_RED, map[i][j], ANSI_RESET);
				} else {
					System.out.printf("%d ", map[i][j]);
				}
			}
			System.out.println();
		}
	}
}