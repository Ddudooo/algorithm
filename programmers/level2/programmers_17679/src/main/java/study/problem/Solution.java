package study.problem;

public class Solution {

	private static final int[] dx = {-1, +1, -1, +1};
	private static final int[] dy = {-1, -1, +1, +1};

	public int solution(int m, int n, String[] board) {
		int answer = 0;
		int removeBlock = remove(m, n, board);
		while (removeBlock > 0) {
			answer += removeBlock;
			while (true) {
				if (!downFall(m, n, board)) {
					break;
				}
			}
			removeBlock = remove(m, n, board);
		}
		return answer;
	}

	private int remove(int m, int n, String[] board) {
		int removeBlock = 0;
		for (int i = 0; i < m; i++) { // y
			for (int j = 0; j < n; j++) { // x
				for (int d = 0; d < 4; d++) {
					int x = j + dx[d];
					int y = i + dy[d];
					if (isSameArea(x, j, y, i, m, n, board)) {
						removeBlock += removeArea(x, j, y, i, board);
					}
				}
			}
		}
		return removeBlock;
	}

	private boolean isSameArea(int ax, int bx, int ay, int by, int m, int n, String[] board) {
		int minX = Math.min(ax, bx);
		int maxX = Math.max(ax, bx);
		int minY = Math.min(ay, by);
		int maxY = Math.max(ay, by);
		if (minX < 0 || maxX >= n) {
			return false;
		}
		if (minY < 0 || maxY >= m) {
			return false;
		}
		char area = Character.toUpperCase(board[minY].charAt(minX));
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				char element = Character.toUpperCase(board[j].charAt(i));
				if (area != element) {
					return false;
				}
			}
		}
		return true;
	}

	private int removeArea(int ax, int bx, int ay, int by, String[] board) {
		int removeBlock = 0;
		int minX = Math.min(ax, bx);
		int maxX = Math.max(ax, bx);
		int minY = Math.min(ay, by);
		int maxY = Math.max(ay, by);
		for (int i = minX; i <= maxX; i++) {
			for (int j = minY; j <= maxY; j++) {
				char element = board[j].charAt(i);
				if (Character.isUpperCase(element)) {
					removeBlock++;
				}
				char remove = Character.toLowerCase(element);
				char[] rows = board[j].toCharArray();
				rows[i] = remove;
				board[j] = String.copyValueOf(rows);
			}
		}
		return removeBlock;
	}

	private boolean downFall(int m, int n, String[] board) {
		boolean downFlag = false;
		for (int i = m - 1; i >= 0; i--) {
			char[] row = board[i].toCharArray();
			for (int j = 0; j < n; j++) {
				char ele = row[j];
				if (Character.isLowerCase(ele) || ele == ' ') {
					if (i == 0) {
						row[j] = ' ';
						board[i] = String.copyValueOf(row);
					} else {
						char[] nextRow = board[i - 1].toCharArray();
						char nextRowEle = nextRow[j];
						if (ele == nextRowEle) {
							continue;
						}
						row[j] = nextRowEle;
						nextRow[j] = nextRowEle == ' ' ? ' ' : Character.toLowerCase(nextRowEle);
						board[i] = String.copyValueOf(row);
						board[i - 1] = String.copyValueOf(nextRow);
						downFlag = true;
					}
				}
			}
		}
		return downFlag;
	}

	private void print(String[] board) {
		System.out.println("=================================================");
		for (String row : board) {
			System.out.println(row);
		}
		System.out.println("=================================================");
	}

	private void printAreaColored(int ax, int bx, int ay, int by, String[] board, String msg) {
		System.out.printf("===============[%-20s]=================\n", msg);
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_RED = "\u001B[31m";
		int minX = Math.min(ax, bx);
		int maxX = Math.max(ax, bx);
		int minY = Math.min(ay, by);
		int maxY = Math.max(ay, by);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				char ele = board[i].charAt(j);
				if (minY <= i && i <= maxY) {
					if (minX <= j && j <= maxX) {
						System.out.print(ANSI_RED);
					}
				}
				System.out.print(ele);
				if (minY <= i && i <= maxY) {
					if (minX <= j && j <= maxX) {
						System.out.print(ANSI_RESET);
					}
				}
			}
			System.out.println();
		}
		System.out.printf("===============[%-20s]=================\n", msg);
	}
}