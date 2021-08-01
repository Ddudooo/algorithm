package study.problem;

public class Solution {

	public int[] solution(String[][] places) {
		int length = places.length;
		int[] answer = new int[length];
		for (int i = 0; i < length; i++) {
			String[] place = places[i];
			if (checkDistance(place)) {
				answer[i] = 1;
			}
		}
		return answer;
	}

	private boolean checkDistance(String[] place) {
		char[][] map = new char[5][5];
		for (int i = 0; i < place.length; i++) {
			map[i] = place[i].toCharArray();
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == 'P' && searchNearBy(i, j, map)) {
					System.out.println("거리두기 실패.");
					return false;
				}
			}
		}
		return true;
	}

	private boolean searchNearBy(int x, int y, char[][] map) {
		System.out.printf("x = %d, y = %d 기준으로 거리두기를 확인합니다.\n", x, y);
		print(x, y, map);
		int X = Math.max(x - 2, 0);
		int Y = Math.max(y - 2, 0);
		int maxX = Math.min(x + 3, 5);
		int maxY = Math.min(y + 3, 5);
		for (int i = X; i < maxX; i++) {
			for (int j = Y; j < maxY; j++) {
				if (i == x && j == y) {
					continue;
				}

				if (map[i][j] == 'P') {
					int distance = calculateDistance(i, j, x, y);
					if (distance <= 1) {
						System.out.printf("x = %d, y = %d 거리가 가깝습니다.\n", i, j);
						return true;
					}
					if (distance <= 2 && isByPassBetween(x, y, i, j, map)) {
						return true;
					}
				}
			}
		}
		System.out.printf("x = %d, y = %d 거리두기 준수중!\n", x, y);
		System.out.println("===================================");
		return false;
	}

	private boolean isByPassBetween(int ax, int ay, int bx, int by, char[][] map) {
		System.out.printf("x = %d -> %d, y = %d -> %d,  중간에 가림막을 확인합니다.\n", ax, bx, ay, by);
		int minX = Math.min(ax, bx);
		int maxX = Math.max(ax, bx);
		int minY = Math.min(ay, by);
		int maxY = Math.max(ay, by);
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				if (map[i][j] == 'O') {
					return true;
				}
			}
		}
		return false;
	}

	private int calculateDistance(int ax, int ay, int bx, int by) {
		return Math.abs(ax - bx) + Math.abs(ay - by);
	}

	private void print(int x, int y, char[][] map) {
		final String ANSI_RED = "\u001B[31m";
		final String ANSI_RESET = "\u001B[0m";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == x && j == y) {
					System.out.print(ANSI_RED + map[i][j] + " " + ANSI_RESET);
				} else {
					System.out.print(map[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println("===================================");
	}
}