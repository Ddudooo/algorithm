package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.problem.Road.Position;

class SolutionTest {

	private Solution solution;

	@BeforeEach
	void init() {
		solution = new Solution();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"\"ULURRDLLU\"\t7",
		"\"LULLLLLLU\"\t7",
		"LRLRL\t1"
	}, delimiter = '\t')
	void testCase(String dirStr, int result) {
		String dirs = dirStr.replaceAll("\\W", "");
		int answer = this.solution.solution(dirs);

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	@Test
	void roadEqualsTest() {
		Road roadA = new Road(new Position(0, 0), new Position(1, 1));
		Road roadB = new Road(new Position(1, 1), new Position(0, 0));

		assertEquals(roadA, roadB, "방향성에 상관없이 같아야 한다.");
	}

	@Test
	void roadEqualsHashTest() {
		Road roadA = new Road(new Position(0, 0), new Position(1, 1));
		Road roadB = new Road(new Position(1, 1), new Position(0, 0));

		assertEquals(roadA.hashCode(), roadB.hashCode(), "방향성에 상관없이 같아야 한다.");
	}
}