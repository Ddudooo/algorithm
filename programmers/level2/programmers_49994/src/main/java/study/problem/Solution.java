package study.problem;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Solution {

	public int solution(String dirs) {
		Set<Road> roads = new HashSet<>();
		Unit unit = new Unit();
		Road.Position prePosition = new Road.Position(0, 0);
		for (char dir : dirs.toCharArray()) {
			if (unit.move(dir)) {
				Road.Position movePosition = new Road.Position(unit.getX(), unit.getY());
				roads.add(new Road(prePosition, movePosition));
				prePosition = movePosition;
			}
		}
		return roads.size();
	}
}

class Unit {

	private int x = 0;
	private int y = 0;

	public Unit() {
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean move(char order) {
		if (order == 'U') {
			if (this.y >= 5) {
				return false;
			}
			this.y++;
		}
		if (order == 'D') {
			if (this.y <= -5) {
				return false;
			}
			this.y--;
		}

		if (order == 'R') {
			if (this.x >= 5) {
				return false;
			}
			this.x++;
		}
		if (order == 'L') {
			if (this.x <= -5) {
				return false;
			}
			this.x--;
		}
		return true;
	}
}

class Road {

	private final Position start;
	private final Position end;

	Road(Position start, Position end) {
		this.start = start;
		this.end = end;
	}

	static class Position {

		private final int x;
		private final int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Position position = (Position) o;
			return x == position.x && y == position.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}

		@Override
		public String toString() {
			return new StringJoiner(", ", "[", "]")
				.add("x=" + x)
				.add("y=" + y)
				.toString();
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
		Road road = (Road) o;
		return (start.equals(road.start) && end.equals(road.end))
			|| (start.equals(road.end) && end.equals(road.start));
	}

	@Override
	public int hashCode() {
		if (start.getX() == end.getX()) {
			if (start.getY() >= end.getY()) {
				return Objects.hash(start, end);
			}
			return Objects.hash(end, start);
		}
		if (start.getX() < end.getX()) {
			return Objects.hash(end, start);
		}
		return Objects.hash(start, end);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Road.class.getSimpleName() + "[", "]")
			.add("start=" + start)
			.add("end=" + end)
			.toString();
	}
}