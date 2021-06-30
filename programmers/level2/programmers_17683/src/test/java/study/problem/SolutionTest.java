package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		"ABCDEFG; 12:00,12:14,HELLO,CDEFGAB. 13:00,13:05,WORLD,ABCDEF; HELLO",
		"CC#BCC#BCC#BCC#B; 03:00,03:30,FOO,CC#B. 04:00,04:08,BAR,CC#BCC#BCC#B; FOO",
		"ABC; 12:00,12:14,HELLO,C#DEFGAB. 13:00,13:05,WORLD,ABCDEF; WORLD"
	}, delimiter = ';')
	void testCase(String m, String musics, String result) {
		String answer = this.solution.solution(m, getMusicInfos(musics));

		assertEquals(result, answer, "답이 같아야 한다.");
	}

	private String[] getMusicInfos(String musics) {
		String[] split = musics.split("\\.");
		return Arrays.stream(split).map(String::trim).toArray(String[]::new);
	}
}