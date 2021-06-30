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
		"img12.png,img10.png,img02.png,img1.png,IMG01.GIF,img2.JPG;"
			+ "img1.png,IMG01.GIF,img02.png,img2.JPG,img10.png,img12.png"}, delimiter = ';')
	void testCase(String input, String result) {
		String[] answer = this.solution.solution(strConvertAry(input));

		assertArrayEquals(strConvertAry(result), answer);
	}

	private String[] strConvertAry(String source) {
		String[] split = source.split(",");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}
}