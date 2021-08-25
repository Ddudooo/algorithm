package study.problem;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
		"\"HaEaLaLaObWORLDb\"\t\"HELLO WORLD\"",
		"\"SpIpGpOpNpGJqOqA\"\t\"SIGONG JOA\"",
		"\"AxAxAxAoBoBoB\"\t\"invalid\"",
		"aIaAM\tI AM",
		"baHELLOabWORLD\tinvalid",
		"aHbEbLbLbOacWdOdRdLdDc\tHELLO WORLD",
		"bAaOb\tAO",
		"\"TxTxTxbAb\"\t\"invalid\"",
		"\"bTxTxTaTxTbkABaCDk\"\t\"invalid\"",
		"aa\tinvalid",
		"aaA\tinvalid",
		"aGbWbFbDakGnWnLk\tGWFD GWL",
		"aCaCa\tinvalid"
	}, delimiter = '\t')
	void testCase(String sentence, String result) {
		sentence = sentence.replaceAll("\"", "");
		result = result.replaceAll("\"", "");
		String answer = this.solution.solution(sentence);

		assertEquals(result, answer, "답이 같아야 한다.");
	}
}