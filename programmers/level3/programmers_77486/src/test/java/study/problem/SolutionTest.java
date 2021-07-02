package study.problem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SolutionTest {

	private Solution solution;

	@BeforeEach
	void init() {
		solution = new Solution();
	}

	@ParameterizedTest
	@CsvSource(value = {
		"[\"john\", \"mary\", \"edward\", \"sam\", \"emily\", \"jaimie\", \"tod\", \"young\"];"
			+ "[\"-\", \"-\", \"mary\", \"edward\", \"mary\", \"mary\", \"jaimie\", \"edward\"];"
			+ "[\"young\", \"john\", \"tod\", \"emily\", \"mary\"];"
			+ "[12, 4, 2, 5, 10];"
			+ "[360, 958, 108, 0, 450, 18, 180, 1080]",
		"[\"john\", \"mary\", \"edward\", \"sam\", \"emily\", \"jaimie\", \"tod\", \"young\"];"
			+ "[\"-\", \"-\", \"mary\", \"edward\", \"mary\", \"mary\", \"jaimie\", \"edward\"];"
			+ "[\"sam\", \"emily\", \"jaimie\", \"edward\"];"
			+ "[2, 3, 5, 4];"
			+ "[0, 110, 378, 180, 270, 450, 0, 0]"
	},
		delimiter = ';')
	void testCase(String enrollStr, String referralStr, String sellerStr, String amountStr,
		String resultStr) {
		int[] answer = this.solution
			.solution(strToStrAry(enrollStr), strToStrAry(referralStr), strToStrAry(sellerStr),
				strToIntAry(amountStr));
		int[] results = strToIntAry(resultStr);
		printIntAry(answer);
		printIntAry(results);
		assertArrayEquals(results, answer, "답이 같아야 한다.");
	}

	private void printIntAry(int[] ints) {
		for (int value : ints) {
			System.out.print(value + " ");
		}
		System.out.println();
	}

	private String[] strToStrAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		str = str.replaceAll("\"", "");
		String[] entity = str.split(",");
		return Arrays.stream(entity).map(String::trim).toArray(String[]::new);
	}

	private int[] strToIntAry(String str) {
		str = str.replaceAll("\\[", "");
		str = str.replaceAll("]", "");
		String[] entity = str.split(",");
		return Arrays.stream(entity).map(String::trim).mapToInt(Integer::parseInt).toArray();
	}
}